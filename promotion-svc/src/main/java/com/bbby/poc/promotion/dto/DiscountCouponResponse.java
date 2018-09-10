package com.bbby.poc.promotion.dto;

import java.util.HashSet;
import java.util.Set;

public class DiscountCouponResponse {
	
	private Long id;
	private DiscountDTO discountDTO;
	private Set<String> productCodes = new HashSet<String>(0);

	public DiscountDTO getDiscountDTO() {
		return discountDTO;
	}

	public void setDiscountDTO(DiscountDTO discountDTO) {
		this.discountDTO = discountDTO;
	}

	public Set<String> getProductCodes() {
		return productCodes;
	}

	public void setProductCodes(Set<String> productCodes) {
		this.productCodes = productCodes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return null;
	}

	public void setName(String nameToSet) {

	}

}
