package com.bbby.poc.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbby.poc.dbservice.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
