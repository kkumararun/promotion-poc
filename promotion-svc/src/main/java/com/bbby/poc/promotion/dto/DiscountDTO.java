package com.bbby.poc.promotion.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.bbby.poc.promotion.enums.CURRENCY;
import com.bbby.poc.promotion.enums.DATEFORMATS;
import com.bbby.poc.promotion.enums.DISCOUNTSCOPE;
import com.bbby.poc.promotion.model.Discount;
import com.bbby.poc.promotion.util.DateFormatter;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement
@XStreamAlias("discountDTO")
public class DiscountDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8507806295687462973L;
	private Long id;
	private String discountCode;
	private Double discountPercent;
	private Double discountAmount;
	private CURRENCY currency;
	private String startDate;
	private String endDate;
	private String additionalNotes;
	private DISCOUNTSCOPE discountScope;
	private Set<DiscountRuleDTO> discountRulesDTO;
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
	 * @param discountCode the discountCode to set
	 */
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	/**
	 * @return the discountPercent
	 */
	public Double getDiscountPercent() {
		return discountPercent;
	}
	/**
	 * @param discountPercent the discountPercent to set
	 */
	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}
	/**
	 * @return the discountAmount
	 */
	public Double getDiscountAmount() {
		return discountAmount;
	}
	/**
	 * @param discountAmount the discountAmount to set
	 */
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	/**
	 * @return the currency
	 */
	public CURRENCY getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
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
	 * @param startDate the startDate to set
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
	 * @param endDate the endDate to set
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
	 * @param additionalNotes the additionalNotes to set
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
	 * @param discountScope the discountScope to set
	 */
	public void setDiscountScope(DISCOUNTSCOPE discountScope) {
		this.discountScope = discountScope;
	}
	/**
	 * @return the discountRulesDTO
	 */
	public Set<DiscountRuleDTO> getDiscountRulesDTO() {
		return discountRulesDTO;
	}
	/**
	 * @param discountRulesDTO the discountRulesDTO to set
	 */
	public void setDiscountRulesDTO(Set<DiscountRuleDTO> discountRulesDTO) {
		this.discountRulesDTO = discountRulesDTO;
	}
	/**
	 * @return the applicable
	 */
	public Boolean getApplicable() {
		return applicable;
	}
	/**
	 * @param applicable the applicable to set
	 */
	public void setApplicable(Boolean applicable) {
		this.applicable = applicable;
	}
	
	public static DiscountDTO convert(Discount discount) {
		DiscountDTO discountDTO = new DiscountDTO();
		discountDTO.setId(discount.getId());
		discountDTO.setAdditionalNotes(discount.getAdditionalNotes());
		discountDTO.setCurrency(discount.getCurrency());
		discountDTO.setDiscountAmount(discount.getDiscountAmount());
		discountDTO.setDiscountCode(discount.getDiscountCode());
		discountDTO.setDiscountPercent(discount.getDiscountPercent());
		discountDTO.setDiscountRulesDTO(DiscountRuleDTO.convert(discount.getDiscountRules()));
		discountDTO.setDiscountScope(discount.getDiscountScope());
		try {
			discountDTO.setStartDate(DateFormatter.getFormattedDate(discount.getStartDate(), DATEFORMATS.dd_MM_yyyy.getFormatString()));
			discountDTO.setEndDate(DateFormatter.getFormattedDate(discount.getEndDate(), DATEFORMATS.dd_MM_yyyy.getFormatString()));
		} catch (ParseException e) {
			discountDTO.setStartDate("");
			discountDTO.setEndDate("");
		}
		return discountDTO;
	}
		
}
