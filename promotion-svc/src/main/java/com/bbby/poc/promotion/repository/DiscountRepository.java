package com.bbby.poc.promotion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbby.poc.promotion.model.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {
    List<Discount> findByDiscountCode(String discountCode);
}
