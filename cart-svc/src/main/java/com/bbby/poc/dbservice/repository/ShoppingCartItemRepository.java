package com.bbby.poc.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbby.poc.dbservice.model.ShoppingCartItem;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Integer> {

}
