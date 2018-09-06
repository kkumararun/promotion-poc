package com.bby.poc.promotion.dto;

/**
 * The Enum DISCOUNTPARAM.
 */
public enum DISCOUNTPARAM {

	/** The travel date. **/
	purchaseDate("DISCOUNTPARAMs[T(com.bby.poc.promotion.dto.DISCOUNTPARAM).purchaseDate]"),
	/** The order total. **/
	orderTotal("DISCOUNTPARAMs[T(com.bby.poc.promotion.dto.DISCOUNTPARAM).orderTotal]"),
	/** The product id. **/
	productId("DISCOUNTPARAMs[T(com.bby.poc.promotion.dto.DISCOUNTPARAM).productId]"),
	/** The product category. **/
	productCategory("DISCOUNTPARAMs[T(com.bby.poc.promotion.dto.DISCOUNTPARAM).productCategory]"),
	/** The user id. **/
	userId("DISCOUNTPARAMs[T(com.bby.poc.promotion.dto.DISCOUNTPARAM).userId]");
	
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
