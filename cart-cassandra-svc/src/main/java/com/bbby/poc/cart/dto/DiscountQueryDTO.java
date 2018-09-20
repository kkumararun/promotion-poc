package com.bbby.poc.cart.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * The Class DiscountQueryDTO.
 */
public class DiscountQueryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6451965814289263876L;

	/** The discount code. */
	private String discountCode;

	/** The currency. */
	private CURRENCY currency;

	/** The discount params. */
	private Map<DISCOUNTPARAM, Object> discountParams;
	
	private String productCode;

	/**
	 * Gets the discount code.
	 * 
	 * @return the discount code
	 */
	public String getDiscountCode() {
		return discountCode;
	}

	/**
	 * Sets the discount code.
	 * 
	 * @param discountCode
	 *            the new discount code
	 */
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	/**
	 * Gets the discount params.
	 * 
	 * @return the discount params
	 */
	public Map<DISCOUNTPARAM, Object> getDiscountParams() {
		return discountParams;
	}

	/**
	 * Sets the discount params.
	 * 
	 * @param discountParams
	 *            the discount params
	 */
	public void setDiscountParams(Map<DISCOUNTPARAM, Object> discountParams) {
		this.discountParams = discountParams;
	}

	/**
	 * Gets the currency.
	 * 
	 * @return the currency
	 */
	public CURRENCY getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 * 
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(CURRENCY currency) {
		this.currency = currency;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
}
