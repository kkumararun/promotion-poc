package com.bbby.poc.dbservice.dto;

/**
 * The Enum DISCOUNTPARAM.
 */
public enum DISCOUNTPARAM {

	/** The travel date. **/
	purchaseDate("discountParams[T(com.bbby.poc.promotion.enums.DISCOUNTPARAM).purchaseDate]"),
	/** The order total. **/
	orderTotal("discountParams[T(com.bbby.poc.promotion.enums.DISCOUNTPARAM).orderTotal]"),
	/** The product id. **/
	productId("discountParams[T(com.bbby.poc.promotion.enums.DISCOUNTPARAM).productId]"),
	/** The product category. **/
	productCategory("discountParams[T(com.bbby.poc.promotion.enums.DISCOUNTPARAM).productCategory]"),
	/** The user id. **/
	userId("discountParams[T(com.bbby.poc.promotion.enums.DISCOUNTPARAM).userId]");
	
	/** The el place holder. */
	private String elPlaceHolder;

	/**
	 * Instantiates a new DISCOUNTPARAM.
	 * 
	 * @param elPlaceHolder
	 *            the el place holder
	 */
	DISCOUNTPARAM(String elPlaceHolder) {
		this.elPlaceHolder = elPlaceHolder;
	}

	/**
	 * Gets the el place holder.
	 * 
	 * @return the elPlaceHolder
	 */
	public String getElPlaceHolder() {
		return elPlaceHolder;
	}

	/**
	 * Sets the el place holder.
	 * 
	 * @param elPlaceHolder
	 *            the elPlaceHolder to set
	 */
	public void setElPlaceHolder(String elPlaceHolder) {
		this.elPlaceHolder = elPlaceHolder;
	}
}
