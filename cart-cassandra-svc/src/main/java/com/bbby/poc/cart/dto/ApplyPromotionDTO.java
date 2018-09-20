package com.bbby.poc.cart.dto;

public class ApplyPromotionDTO {
	private String promoCode;
	private Integer cartID;

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public Integer getCartID() {
		return cartID;
	}

	public void setCartID(Integer cartID) {
		this.cartID = cartID;
	}
}
