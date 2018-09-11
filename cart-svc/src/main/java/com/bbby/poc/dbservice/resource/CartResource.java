package com.bbby.poc.dbservice.resource;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bbby.poc.dbservice.dto.ApplyPromotionDTO;
import com.bbby.poc.dbservice.dto.CURRENCY;
import com.bbby.poc.dbservice.dto.DISCOUNTPARAM;
import com.bbby.poc.dbservice.dto.DISCOUNTTYPE;
import com.bbby.poc.dbservice.dto.DiscountDTO;
import com.bbby.poc.dbservice.dto.DiscountQueryDTO;
import com.bbby.poc.dbservice.model.Cart;
import com.bbby.poc.dbservice.model.ShoppingCartItem;
import com.bbby.poc.dbservice.repository.CartRepository;

@CrossOrigin
@RestController
@RequestMapping("/rest/db")
public class CartResource {

	private static final Logger LOGGER = Logger.getLogger(CartResource.class);

	private static final String DISCOUNT_MS_URL = "http://localhost:8302/api/promotion-service/discount_coupon/apply";
	
	private CartRepository cartRepository;

	public CartResource(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	/**
	 * Add to Cart API
	 * 
	 * @param cart
	 * @return
	 */
	@PostMapping(path = "/add")
	public Cart addItems(@RequestBody Cart cart) {
		if (cart.getId() != null) {
			Cart existingCart = cartRepository.findOne(cart.getId());
			if (existingCart != null) {
				LOGGER.info("adding product to existing cart");
				List<ShoppingCartItem> existingCartItems = existingCart.getShoppingCartItemList();

				BigDecimal orderTotal = existingCart.getOrderTotal();
				for (ShoppingCartItem item : cart.getShoppingCartItemList()) {
					item.setCart(existingCart);
					orderTotal = orderTotal.add(item.getSalePrice());
					existingCartItems.add(item);
				}
				existingCart.setOrderTotal(orderTotal);
				existingCart.setShoppingCartItemList(existingCartItems);
				cartRepository.save(existingCart);
				return existingCart;
			} else {
				LOGGER.info("creating new cart in case of invalid cart-id");
				List<ShoppingCartItem> newItems = new ArrayList<ShoppingCartItem>(0);
				List<ShoppingCartItem> items = cart.getShoppingCartItemList();
				BigDecimal orderTotal = BigDecimal.ZERO;
				for (ShoppingCartItem item : items) {
					item.setCart(cart);
					newItems.add(item);
					orderTotal = item.getSalePrice();
				}
				cart.setOrderTotal(orderTotal);
				cart.setCreateDate(new Date());
				cart.setShoppingCartItemList(newItems);
				cartRepository.save(cart);
			}
		} else {
			LOGGER.info("creating new cart");
			List<ShoppingCartItem> newItems = new ArrayList<ShoppingCartItem>(0);
			List<ShoppingCartItem> items = cart.getShoppingCartItemList();
			BigDecimal orderTotal = BigDecimal.ZERO;
			for (ShoppingCartItem item : items) {
				item.setCart(cart);
				newItems.add(item);
				orderTotal = item.getSalePrice();
			}
			cart.setOrderTotal(orderTotal);
			cart.setCreateDate(new Date());
			cart.setShoppingCartItemList(newItems);
			cartRepository.save(cart);
		}
		cart.setMessage("Successfully added product to shopping cart");
		return cart;
	}

	/**
	 * Get Cart by ID
	 * 
	 * @param cartID
	 * @return
	 */
	@GetMapping(path = "/get")
	public Cart getCartByID(@RequestParam("id") Integer cartID) {
		final Cart cart = cartRepository.findOne(cartID);
		cart.setMessage("products in existing shopping cart");
		return cart;
	}

	/**
	 * Apply Promotion API
	 * 
	 * @param cart
	 * @return
	 */
	@PostMapping(path = "/apply-promotion")
	public Cart applyPromotion(@RequestBody ApplyPromotionDTO promotion) {
		Cart existingCart = cartRepository.findOne(promotion.getCartID());
		if (existingCart != null) {
			DiscountDTO discount = getApplicableDiscount(promotion.getPromoCode(), existingCart.getOrderTotal());
			if(discount != null && discount.getApplicable()) {
				LOGGER.info("applying promotion to cart");
				applyDiscountOnCart(existingCart, discount);
			}else {
				LOGGER.info("invalid promotion applied");
				existingCart.setMessage("Oops ! Invalid coupon code entered.");
			}
		}
		return existingCart;
	}
	
	/**
	 * Apply Discount on Cart/Product
	 * 
	 * @param existingCart
	 * @param discount
	 */
	private void applyDiscountOnCart(Cart existingCart, DiscountDTO discount) {
		switch(discount.getDiscountScope()) {
			case CART : {
				LOGGER.info("promotion applied at "+discount.getDiscountScope());
				if(discount.getDiscountPercent() != null ) {
					List<ShoppingCartItem> existingCartItems = existingCart.getShoppingCartItemList();
					List<ShoppingCartItem> newItems = new ArrayList<ShoppingCartItem>(0);
					BigDecimal dicountedTotalPrice = BigDecimal.ZERO;
					for (ShoppingCartItem item : existingCartItems) {
						BigDecimal discountedPrice = item.getSalePrice().subtract(item.getSalePrice().multiply(discount.getDiscountPercent().divide(new BigDecimal("100"))));
						item.setDiscountedPrice(discountedPrice);
						dicountedTotalPrice = dicountedTotalPrice.add(discountedPrice);
						newItems.add(item);
					}
					existingCart.setDicountedTotalPrice(dicountedTotalPrice);
					existingCart.setShoppingCartItemList(newItems);
					
					LOGGER.info("promotion applied @ "+discount.getDiscountPercent()+" %");
					existingCart.setDiscountType(DISCOUNTTYPE.PERCENTAGE);
					existingCart.setDiscountValue(discount.getDiscountPercent());
				} else if(discount.getDiscountAmount() != null){
					BigDecimal dicountedTotalPrice = existingCart.getOrderTotal().subtract(discount.getDiscountAmount());
					existingCart.setDicountedTotalPrice(dicountedTotalPrice);
					
					LOGGER.info("promotion applied for "+discount.getCurrency()+" "+discount.getDiscountAmount());
					existingCart.setDiscountType(DISCOUNTTYPE.AMOUNT);
					existingCart.setDiscountValue(discount.getDiscountAmount());
				} else {
					// Not Applicable
				}
				break;
			}
			case PRODUCT : {
				//:TODO TBD
				break;
			}
			default:{
				break;
			}
		}
	}

	/**
	 * Check Discount Applicability
	 * 
	 * @param promoCode
	 * @param orderTotal
	 * @return
	 */
	private DiscountDTO getApplicableDiscount(String promoCode, BigDecimal orderTotal) {
		DiscountDTO dto = null;
		DiscountQueryDTO request = new DiscountQueryDTO();
		request.setCurrency(CURRENCY.USD);
		request.setDiscountCode(promoCode);
		Map<DISCOUNTPARAM, Object> discountParams = new HashMap<DISCOUNTPARAM, Object>();
		discountParams.put(DISCOUNTPARAM.orderTotal, orderTotal);
		discountParams.put(DISCOUNTPARAM.purchaseDate,convertToStringDate());
		request.setDiscountParams(discountParams);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(HttpHeaders.CONTENT_ENCODING, "GZIP");
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(request, headers);
		LOGGER.info("calling discount micro-service --> "+DISCOUNT_MS_URL);
		dto = restTemplate.postForObject(DISCOUNT_MS_URL, requestEntity, DiscountDTO.class);
		LOGGER.info("received response from discount micro-service " + dto.toString());
		return dto;
	}
	
	/**
	 * Format Date
	 * 
	 * @return
	 */
	private String convertToStringDate() {
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(new Date());
	}
}
