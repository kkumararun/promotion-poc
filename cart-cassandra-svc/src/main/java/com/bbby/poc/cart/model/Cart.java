package com.bbby.poc.cart.model;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Cart {
	@PrimaryKey
	private UUID id;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private String createDate;
	private String userId;
	private BigDecimal orderTotal;
	private String discountType;
	private BigDecimal discountValue;
	private BigDecimal discountTotalAmount;
	private BigDecimal dicountedTotalPrice;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public BigDecimal getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(BigDecimal discountValue) {
		this.discountValue = discountValue;
	}

	public BigDecimal getDiscountTotalAmount() {
		return discountTotalAmount;
	}

	public void setDiscountTotalAmount(BigDecimal discountTotalAmount) {
		this.discountTotalAmount = discountTotalAmount;
	}

	public BigDecimal getDicountedTotalPrice() {
		return dicountedTotalPrice;
	}

	public void setDicountedTotalPrice(BigDecimal dicountedTotalPrice) {
		this.dicountedTotalPrice = dicountedTotalPrice;
	}
}