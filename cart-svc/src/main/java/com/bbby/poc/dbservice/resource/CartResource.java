package com.bbby.poc.dbservice.resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bbby.poc.dbservice.dto.ApplyPromotionDTO;
import com.bbby.poc.dbservice.model.Cart;
import com.bbby.poc.dbservice.model.ShoppingCartItem;
import com.bbby.poc.dbservice.repository.CartRepository;

@RestController
@RequestMapping("/rest/db")
public class CartResource {
	
	private static final Logger LOGGER = Logger.getLogger(CartResource.class);

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
		if(cart.getId() != null) {
			Cart existingCart = cartRepository.findOne(cart.getId());
			if(existingCart != null) {
				LOGGER.info("adding product to existing cart");
				List<ShoppingCartItem> existingCartItems = existingCart.getShoppingCartItemList();

				BigDecimal orderTotal = existingCart.getOrderTotal();
				for(ShoppingCartItem item : cart.getShoppingCartItemList()) {
					item.setCart(existingCart);
					orderTotal = orderTotal.add(item.getSalePrice());
					existingCartItems.add(item);
				}
				existingCart.setOrderTotal(orderTotal);
				existingCart.setShoppingCartItemList(existingCartItems);
				cartRepository.save(existingCart);
				return existingCart;
			}else {
				LOGGER.info("creating new cart in case of invalid cart-id");
				List<ShoppingCartItem> newItems = new ArrayList<ShoppingCartItem>(0);
				List<ShoppingCartItem> items = cart.getShoppingCartItemList();
				BigDecimal orderTotal = BigDecimal.ZERO;
				for(ShoppingCartItem item : items) {			
					item.setCart(cart);
					newItems.add(item);
					orderTotal = item.getSalePrice();
				}
				cart.setOrderTotal(orderTotal);
				cart.setCreateDate(new Date());
				cart.setShoppingCartItemList(newItems);
				cartRepository.save(cart);
			}
		}else {
			LOGGER.info("creating new cart");
			List<ShoppingCartItem> newItems = new ArrayList<ShoppingCartItem>(0);
			List<ShoppingCartItem> items = cart.getShoppingCartItemList();
			BigDecimal orderTotal = BigDecimal.ZERO;
			for(ShoppingCartItem item : items) {			
				item.setCart(cart);
				newItems.add(item);
				orderTotal = item.getSalePrice();
			}
			cart.setOrderTotal(orderTotal);
			cart.setCreateDate(new Date());
			cart.setShoppingCartItemList(newItems);
			cartRepository.save(cart);
		}
		return cart;
	}
	
	/**
	 * Get Cart by ID
	 * 
	 * @param cartID
	 * @return
	 */
	@GetMapping(path = "/get")
	public Cart getCartByID(@RequestParam("id") Integer cartID){
		final Cart cart = cartRepository.findOne(cartID);
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
		if(existingCart != null) {
			LOGGER.info("apply promotion to cart");
			List<ShoppingCartItem> existingCartItems = existingCart.getShoppingCartItemList();
			List<ShoppingCartItem> newItems = new ArrayList<ShoppingCartItem>(0);
			BigDecimal dicountedTotalPrice = BigDecimal.ZERO;
			for(ShoppingCartItem item : existingCartItems) {
				BigDecimal discountedPrice = item.getSalePrice().subtract(item.getSalePrice().multiply(new BigDecimal(".20")));
				item.setDiscountedPrice(discountedPrice);
				dicountedTotalPrice = dicountedTotalPrice.add(discountedPrice);
				newItems.add(item);
			}
			existingCart.setDicountedTotalPrice(dicountedTotalPrice);
			existingCart.setShoppingCartItemList(newItems);
			//cartRepository.save(existingCart);
		}
		
		return existingCart;
	}
}
