package com.bbby.poc.promotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bbby.poc.promotion.model.DiscountRule;

@Repository
public interface DiscountRuleRepository extends JpaRepository<DiscountRule, Integer> {
	
	@Query("select dr from DiscountRule dr where dr.ruleEl = ?1")
	DiscountRule listDiscountRuleByExpression(String ruleEl);

}
