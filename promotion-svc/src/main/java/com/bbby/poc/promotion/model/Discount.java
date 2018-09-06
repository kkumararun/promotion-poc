package com.bbby.poc.promotion.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.bbby.poc.promotion.dto.CURRENCY;
import com.bbby.poc.promotion.dto.DISCOUNTSCOPE;

@Entity
@Table(name = "DISCOUNT")
public class Discount implements IModel {
	
	private static final long serialVersionUID = -2894248926854674319L;

	private Long discountID;
	
	private String discountCode;
	
	private Double discountPercent;
	
	private Double discountAmount;
	
	private CURRENCY currency;
	
	private Date startDate;
	
	private Date endDate;
	
	private String additionalNotes;
	
	private DISCOUNTSCOPE discountScope;
	
	private Set<DiscountRule> discountRules;
	
	private Boolean active = false;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DISCOUNT_ID", unique = true, nullable = false)
	@Override
	public Long getId() {
		return discountID;
	}

	@Override
	public void setId(Long id) {
		this.discountID = id;
	}

	@Column(name = "DISCOUNT_CODE", nullable = false, length = 20, unique = true)
	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	@Column(name = "DISCOUNT_PERCENT", nullable = true)
	public Double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}

	@Column(name = "DISCOUNT_AMOUNT", nullable = true)
	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Column(name = "CURRENCY", nullable = false)
	@Enumerated(EnumType.STRING)
	public CURRENCY getCurrency() {
		return currency;
	}

	public void setCurrency(CURRENCY currency) {
		this.currency = currency;
	}

	@Column(name = "START_DATE", nullable = true)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "END_DATE", nullable = true)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "ADDITIONAL_NOTES", nullable = true)
	public String getAdditionalNotes() {
		return additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	/**
	 * @return the discountrule
	 */
	@Column(name = "DISCOUNT_RULE", nullable = false)
	@Enumerated(EnumType.STRING)
	public DISCOUNTSCOPE getDiscountScope() {
		return discountScope;
	}

	/**
	 * @param discountrule
	 *            the discountrule to set
	 */
	public void setDiscountScope(DISCOUNTSCOPE discountScope) {
		this.discountScope = discountScope;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "DISCOUNT_X_DISCOUNT_RULE", joinColumns = { @JoinColumn(name = "DISCOUNT_ID", referencedColumnName = "DISCOUNT_ID") }, inverseJoinColumns = { @JoinColumn(name = "DISCOUNT_RULE_ID", referencedColumnName = "DISCOUNT_RULE_ID") })
	public Set<DiscountRule> getDiscountRules() {
		return discountRules;
	}

	public void setDiscountRules(Set<DiscountRule> discountRules) {
		this.discountRules = discountRules;
	}

	/**
	 * @return the active
	 */
	@Type(type="yes_no")
	@Column(name = "ACTIVE", unique = false, nullable = true, length = 1, columnDefinition = "CHAR DEFAULT 'N'")
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
