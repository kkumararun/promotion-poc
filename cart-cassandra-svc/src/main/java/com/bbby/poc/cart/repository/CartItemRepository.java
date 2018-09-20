package com.bbby.poc.cart.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.bbby.poc.cart.model.CartItem;

public interface CartItemRepository extends CassandraRepository<CartItem> {
	//	@Query("select * from cart_item where cartID = :?")
	List<CartItem> findByCartID(final String cartID);
}
