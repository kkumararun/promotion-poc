package com.bbby.poc.cart.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.support.BasicMapId;
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

import com.bbby.poc.cart.dto.ApplyPromotionDTO;
import com.bbby.poc.cart.dto.CURRENCY;
import com.bbby.poc.cart.dto.CartDTO;
import com.bbby.poc.cart.dto.DISCOUNTPARAM;
import com.bbby.poc.cart.dto.DISCOUNTTYPE;
import com.bbby.poc.cart.dto.DiscountDTO;
import com.bbby.poc.cart.dto.DiscountQueryDTO;
import com.bbby.poc.cart.model.Cart;
import com.bbby.poc.cart.model.CartItem;
import com.bbby.poc.cart.repository.CartItemRepository;
import com.bbby.poc.cart.repository.CartRepository;
import com.datastax.driver.core.utils.UUIDs;

@CrossOrigin
@RestController
@RequestMapping("/rest/db")
public class CartResource {

	private static final Logger LOGGER = Logger.getLogger(CartResource.class);

	private static final String DISCOUNT_MS_URL = "http://localhost:8302/api/promotion-service/discount_coupon/apply";
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartItemRepository cartItemRepository;
	

	/**
	 * Add to Cart API
	 * 
	 * @param cartDTO
	 * @return
	 */
	@PostMapping(path = "/add")
	public CartDTO addItems(@RequestBody CartDTO cartDTO) {
		if (cartDTO.getId() != null) {
			Cart existingCart = cartRepository.findOne(BasicMapId.id("id", cartDTO.getId()));
			if (existingCart != null) {
				LOGGER.info("adding product to existing cart");
				List<CartItem> existingCartItems = cartItemRepository.findByCartID(existingCart.getId().toString());

				BigDecimal orderTotal = existingCart.getOrderTotal();
				for (CartItem item : cartDTO.getShoppingCartItemList()) {
					item.setId(UUIDs.timeBased());
					item.setCartID(existingCart.getId().toString());
					
					cartItemRepository.save(item);
					
					orderTotal = orderTotal.add(item.getSalePrice());
					existingCartItems.add(item);
				}
				existingCart.setOrderTotal(orderTotal);
				cartDTO.setOrderTotal(orderTotal);
				cartDTO.setShoppingCartItemList(existingCartItems);
				cartRepository.save(existingCart);
				//existingCart.setTotalItems(cartDTO.getShoppingCartItemList().size());
				return cartDTO;
			} else {
				LOGGER.info("creating new cart");
				cartDTO.setId(UUIDs.timeBased());
				List<CartItem> newItems = new ArrayList<CartItem>(0);
				List<CartItem> items = cartDTO.getShoppingCartItemList();
				BigDecimal orderTotal = BigDecimal.ZERO;
				for (CartItem item : items) {
					item.setCartID(cartDTO.getId().toString());
					item.setId(UUIDs.timeBased());
					newItems.add(item);
					orderTotal = item.getSalePrice();
				}
				cartDTO.setOrderTotal(orderTotal);
				cartDTO.setCreateDate(new Date().toString());
				Cart cart = new Cart();
				BeanUtils.copyProperties(cartDTO, cart);
				cartRepository.save(cart);
				cartItemRepository.save(newItems);
			}
		} else {
			LOGGER.info("creating new cart");
			cartDTO.setId(UUIDs.timeBased());
			List<CartItem> newItems = new ArrayList<CartItem>(0);
			List<CartItem> items = cartDTO.getShoppingCartItemList();
			BigDecimal orderTotal = BigDecimal.ZERO;
			for (CartItem item : items) {
				item.setCartID(cartDTO.getId().toString());
				item.setId(UUIDs.timeBased());
				newItems.add(item);
				orderTotal = item.getSalePrice();
			}
			cartDTO.setOrderTotal(orderTotal);
			cartDTO.setCreateDate(new Date().toString());
			
			Cart cart = new Cart();
			BeanUtils.copyProperties(cartDTO, cart);
			cartRepository.save(cart);
			
			cartItemRepository.save(newItems);
		}
		//cartDTO.setTotalItems(cart.getShoppingCartItemList().size());
		cartDTO.setMessage("Successfully added product to shopping cart");
		return cartDTO;
	}

	/**
	 * Get Cart by ID
	 * 
	 * @param cartID
	 * @return
	 */
	@GetMapping(path = "/get")
	public Cart getCartByID(@RequestParam("id") UUID cartID) {
		final Cart cart = cartRepository.findOne(BasicMapId.id("id" , cartID));
		/*if(cart != null) {
			cart.setTotalItems(cart.getShoppingCartItemList().size());
			cart.setMessage("products in existing shopping cart");
		}*/
		return cart;
	}
	
	/**
	 * Get Cart by ID
	 * 
	 * @param cartID
	 * @return
	 */
	@GetMapping(path = "/delete")
	public Cart deleteCartItemByID(@RequestParam("id") UUID cartID, @RequestParam("itemID") Integer itemID) {
		final Cart cart = cartRepository.findOne(BasicMapId.id("id" , cartID));
		
		//cart.setMessage("products in existing shopping cart");
		return cart;
	}

	/**
	 * Apply Promotion API
	 * 
	 * @param cart
	 * @return
	 */
	@PostMapping(path = "/apply-promotion")
	public CartDTO applyPromotion(@RequestBody ApplyPromotionDTO promotion) {
		CartDTO dto = new CartDTO();
		Cart existingCart = cartRepository.findOne(BasicMapId.id("id",promotion.getCartID()));
		if (existingCart != null) {
			BeanUtils.copyProperties(existingCart, dto);
			DiscountDTO discount = getApplicableDiscount(promotion.getPromoCode(), existingCart.getOrderTotal());
			if(discount != null && discount.getApplicable()) {
				LOGGER.info("applying promotion to cart");
				applyDiscountOnCart(dto, discount);
				dto.setMessage("Promotion Applied");
			}else {
				LOGGER.info("invalid promotion applied");
				dto.setMessage("Oops ! Invalid coupon code entered.");
			}
		}
		return dto;
	}
	
	/**
	 * Apply Discount on Cart/Product
	 * 
	 * @param cartDTO
	 * @param discount
	 */
	private void applyDiscountOnCart(CartDTO cartDTO, DiscountDTO discount) {
		switch(discount.getDiscountScope()) {
			case CART : {
				LOGGER.info("promotion applied at "+discount.getDiscountScope());
				if(discount.getDiscountPercent() != null ) {
					List<CartItem> existingCartItems = cartDTO.getShoppingCartItemList();
					List<CartItem> newItems = new ArrayList<CartItem>(0);
					BigDecimal dicountedTotalPrice = BigDecimal.ZERO;
					BigDecimal discountTotalAmount = BigDecimal.ZERO;
					for (CartItem item : existingCartItems) {
						BigDecimal discountAmount = item.getSalePrice().multiply(discount.getDiscountPercent().divide(new BigDecimal("100")));
						BigDecimal discountedPrice = item.getSalePrice().subtract(discountAmount);
						item.setDiscountedPrice(discountedPrice);
						dicountedTotalPrice = dicountedTotalPrice.add(discountedPrice);
						discountTotalAmount = discountTotalAmount.add(discountAmount);
						newItems.add(item);
					}
					
					cartDTO.setDiscountTotalAmount(discountTotalAmount);
					cartDTO.setDicountedTotalPrice(dicountedTotalPrice);
					cartDTO.setShoppingCartItemList(newItems);
					
					LOGGER.info("promotion applied @ "+discount.getDiscountPercent()+" %");
					cartDTO.setMessage("promotion applied @ "+discount.getDiscountPercent()+" %");
					
					cartDTO.setDiscountType(DISCOUNTTYPE.PERCENTAGE.name());			
					cartDTO.setDiscountValue(discount.getDiscountPercent());
					
				} else if(discount.getDiscountAmount() != null){
					BigDecimal dicountedTotalPrice = cartDTO.getOrderTotal().subtract(discount.getDiscountAmount());
					cartDTO.setDicountedTotalPrice(dicountedTotalPrice);
					
					LOGGER.info("promotion applied for "+discount.getCurrency()+" "+discount.getDiscountAmount());
					cartDTO.setMessage("promotion applied for "+discount.getCurrency()+" "+discount.getDiscountAmount());
					
					cartDTO.setDiscountTotalAmount(discount.getDiscountAmount());
					cartDTO.setDiscountType(DISCOUNTTYPE.AMOUNT.name());
					cartDTO.setDiscountValue(discount.getDiscountAmount());
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
		return sdf.format(new java.util.Date());
	}
}
