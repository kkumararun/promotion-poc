package com.bbby.poc.promotion.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.bbby.poc.promotion.enums.CURRENCY;
import com.bbby.poc.promotion.enums.RULETYPE;
import com.bbby.poc.promotion.model.DiscountRule;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement
@XStreamAlias("discountRuleDTO")
public class DiscountRuleDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7585463815285919673L;
	private Long id;
	private String name;
	private String ruleEl;
	private String description;
	RULETYPE ruleType;
	CURRENCY currency;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the ruleEl
	 */
	public String getRuleEl() {
		return ruleEl;
	}
	/**
	 * @param ruleEl the ruleEl to set
	 */
	public void setRuleEl(String ruleEl) {
		this.ruleEl = ruleEl;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the ruleType
	 */
	public RULETYPE getRuleType() {
		return ruleType;
	}
	/**
	 * @param ruleType the ruleType to set
	 */
	public void setRuleType(RULETYPE ruleType) {
		this.ruleType = ruleType;
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
	
	public static Set<DiscountRuleDTO> convert(Set<DiscountRule> discountRuleList) {
		Set<DiscountRuleDTO> discountRuleDTOList = new HashSet<DiscountRuleDTO>();
		discountRuleList.forEach(discountRule -> {
			DiscountRuleDTO discountRuleDTO = new DiscountRuleDTO();
			discountRuleDTO.setCurrency(discountRule.getCurrency());
			discountRuleDTO.setDescription(discountRule.getDescription());
			discountRuleDTO.setName(discountRule.getName());
			discountRuleDTO.setId(discountRule.getId());
			discountRuleDTO.setRuleEl(discountRule.getRuleEl());
			discountRuleDTO.setRuleType(discountRule.getRuleType());
			discountRuleDTOList.add(discountRuleDTO);
		});
		return discountRuleDTOList;
	}
	
	
}
