package com.bbby.poc.dbservice.model;

import javax.persistence.*;

@Entity
@Table(name = "SHOPPING_CART_ITEM")
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "PRODUCT_ID")
    private String productID;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    public ShoppingCartItem() {
    	
    }

    public ShoppingCartItem(String productID, String productName) {
        this.productID = productID;
        this.productName = productName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
