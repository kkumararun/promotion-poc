package com.bbby.poc.promotion.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bbby.poc.promotion.dto.CURRENCY;
import com.bbby.poc.promotion.dto.RULETYPE;

/**
 * The Class DiscountRule.
 * 
 *         purpose : Holds the list of discount governing rule expression
 *         [written in spring el]
 */
@Entity
@Table(name = "DISCOUNT_RULE")
public class DiscountRule implements IModel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1833052294763271951L;

	/** The id. */
	private Long id;

	/** The name. */
	private String name;

	/** The rule el. */
	private String ruleEl;

	/** The description. */
	private String description;
	
	/** The description. */
	RULETYPE ruleType;

	private CURRENCY currency;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DISCOUNT_RULE_ID", unique = true, nullable = false)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	@Column(name = "DISCOUNT_RULE_NAME", nullable = false, length = 100)
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Gets the rule el.
	 * 
	 * @return the rule el
	 */
	@Column(name = "DISCOUNT_RULE_EL", unique=false, nullable = false, length = 300)
	public String getRuleEl() {
		return ruleEl;
	}

	/**
	 * Sets the rule el.Will be a spring el expression made from attributes in
	 * the DISCOUNTPARAM enum
	 * 
	 * @param ruleEl
	 *            the new rule el
	 */
	public void setRuleEl(final String ruleEl) {
		this.ruleEl = ruleEl;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	@Column(name = "DISCOUNT_RULE_DESCRIPTION", nullable = false, length = 300)
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * @return the ruleType
	 */
	@Column(name = "DISCOUNT_RULE_TYPE", nullable = false, length = 100)
	@Enumerated(EnumType.STRING)
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
	@Column(name = "CURRENCY", nullable = false)
	@Enumerated(EnumType.STRING)
	public CURRENCY getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(CURRENCY currency) {
		this.currency = currency;
	}

}
