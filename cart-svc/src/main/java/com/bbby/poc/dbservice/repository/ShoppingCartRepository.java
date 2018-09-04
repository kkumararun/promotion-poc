package com.bbby.poc.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbby.poc.dbservice.model.ShoppingCartItem;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCartItem, Integer> {
    List<ShoppingCartItem> findByProductID(String productID);
}
