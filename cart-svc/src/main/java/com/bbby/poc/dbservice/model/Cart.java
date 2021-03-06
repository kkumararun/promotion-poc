package com.bbby.poc.dbservice.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.bbby.poc.dbservice.dto.DISCOUNTTYPE;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="CART")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cart {
	private Integer id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date createDate;
	private String userId;
	private BigDecimal orderTotal;
	private DISCOUNTTYPE discountType;
	private BigDecimal discountValue;
	private BigDecimal discountTotalAmount;
	private BigDecimal dicountedTotalPrice;
	private List<ShoppingCartItem> shoppingCartItemList;
	private Integer totalItems;
	private String message;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CART_ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.DATE)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date date) {
		this.createDate = date;
	}

	@Column(name = "USER_ID")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "ORDER_TOTAL")
	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "DISCOUNT_TYPE")
	public DISCOUNTTYPE getDiscountType() {
		return discountType;
	}

	public void setDiscountType(DISCOUNTTYPE discountType) {
		this.discountType = discountType;
	}

	@Column(name = "DISCOUNT_VALUE")
	public BigDecimal getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(BigDecimal discountValue) {
		this.discountValue = discountValue;
	}

	@Column(name = "DISCOUNTED_TOTAL_AMOUNT")
	public BigDecimal getDiscountTotalAmount() {
		return discountTotalAmount;
	}

	public void setDiscountTotalAmount(BigDecimal discountTotalAmount) {
		this.discountTotalAmount = discountTotalAmount;
	}

	@Column(name = "DISCOUNTED_TOTAL_PRICE")
	public BigDecimal getDicountedTotalPrice() {
		return dicountedTotalPrice;
	}

	public void setDicountedTotalPrice(BigDecimal dicountedTotalPrice) {
		this.dicountedTotalPrice = dicountedTotalPrice;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cart", orphanRemoval = true)
	@Cascade({ CascadeType.ALL, CascadeType.SAVE_UPDATE })
	@NotFound(action = NotFoundAction.IGNORE)
	@OnDelete(action = OnDeleteAction.CASCADE)
	public List<ShoppingCartItem> getShoppingCartItemList() {
		return shoppingCartItemList;
	}

	public void setShoppingCartItemList(List<ShoppingCartItem> shoppingCartItemList) {
		this.shoppingCartItemList = shoppingCartItemList;
	}
	
	@Transient
	public Integer getTotalItems() {
		return totalItems != null ? totalItems : shoppingCartItemList.size();
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	@Transient
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
