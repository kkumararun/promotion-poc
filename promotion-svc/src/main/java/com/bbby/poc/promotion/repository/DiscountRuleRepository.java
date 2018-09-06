package com.bbby.poc.promotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbby.poc.promotion.model.DiscountRule;

public interface DiscountRuleRepository extends JpaRepository<DiscountRule, Integer> {

}
