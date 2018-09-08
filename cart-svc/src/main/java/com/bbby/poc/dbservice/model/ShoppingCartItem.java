package com.bbby.poc.dbservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "SHOPPING_CART_ITEM")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ShoppingCartItem {
	@JsonIgnore
	private Integer id;
	private String productID;
	private String productName;
	private Integer productQuantity;
	private BigDecimal productListPrice;
	private BigDecimal salePrice;
	private String discountType;
	private BigDecimal discountValue;
	private BigDecimal discountedPrice;
	@JsonIgnore
	private Cart cart;
		
	public ShoppingCartItem() {

	}

	public ShoppingCartItem(String productID, String productName) {
		this.productID = productID;
		this.productName = productName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CART_ITEM_ID", unique = true)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "PRODUCT_ID")
	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	@Column(name = "PRODUCT_NAME")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "PRODUCT_QTY")
	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Column(name = "PRODUCT_LIST_PRICE")
	public BigDecimal getProductListPrice() {
		return productListPrice;
	}

	public void setProductListPrice(BigDecimal productListPrice) {
		this.productListPrice = productListPrice;
	}

	@Column(name = "SALE_PRICE")
	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	@Column(name = "DISCOUNT_TYPE")
	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	@Column(name = "DISCOUNT_VALUE")
	public BigDecimal getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(BigDecimal discountValue) {
		this.discountValue = discountValue;
	}

	@Column(name = "DISCOUNTED_PRICE")
	public BigDecimal getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(BigDecimal discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CART_ID", nullable = true)
	@ForeignKey(name = "FK_CART_ID")
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
