package com.bbby.poc.cart.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.bbby.poc.cart.model.Cart;

public interface CartRepository extends CassandraRepository<Cart> {

}
