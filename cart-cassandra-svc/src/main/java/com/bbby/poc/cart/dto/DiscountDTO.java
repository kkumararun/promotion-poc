package com.bbby.poc.cart.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement
@XStreamAlias("discountDTO")
public class DiscountDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8507806295687462973L;
	private Long id;
	private String discountCode;
	private BigDecimal discountPercent;
	private BigDecimal discountAmount;
	private CURRENCY currency;
	private String startDate;
	private String endDate;
	private String additionalNotes;
	private DISCOUNTSCOPE discountScope;
	private Boolean applicable;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return discountCode;
	}

	public void setName(String nameToSet) {
		this.discountCode = nameToSet;
	}

	/**
	 * @return the discountCode
	 */
	public String getDiscountCode() {
		return discountCode;
	}

	/**
	 * @param discountCode
	 *            the discountCode to set
	 */
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	/**
	 * @return the discountPercent
	 */
	public BigDecimal getDiscountPercent() {
		return discountPercent;
	}

	/**
	 * @param discountPercent
	 *            the discountPercent to set
	 */
	public void setDiscountPercent(BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}

	/**
	 * @return the discountAmount
	 */
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	/**
	 * @param discountAmount
	 *            the discountAmount to set
	 */
	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	/**
	 * @return the currency
	 */
	public CURRENCY getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(CURRENCY currency) {
		this.currency = currency;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the additionalNotes
	 */
	public String getAdditionalNotes() {
		return additionalNotes;
	}

	/**
	 * @param additionalNotes
	 *            the additionalNotes to set
	 */
	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	/**
	 * @return the discountScope
	 */
	public DISCOUNTSCOPE getDiscountScope() {
		return discountScope;
	}

	/**
	 * @param discountScope
	 *            the discountScope to set
	 */
	public void setDiscountScope(DISCOUNTSCOPE discountScope) {
		this.discountScope = discountScope;
	}

	/**
	 * @return the applicable
	 */
	public Boolean getApplicable() {
		return applicable;
	}

	/**
	 * @param applicable
	 *            the applicable to set
	 */
	public void setApplicable(Boolean applicable) {
		this.applicable = applicable;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DiscountDTO [discountCode=");
		builder.append(discountCode);
		builder.append(", discountPercent=");
		builder.append(discountPercent);
		builder.append(", discountAmount=");
		builder.append(discountAmount);
		builder.append(", currency=");
		builder.append(currency);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", discountScope=");
		builder.append(discountScope);
		builder.append(", applicable=");
		builder.append(applicable);
		builder.append("]");
		return builder.toString();
	}
}
