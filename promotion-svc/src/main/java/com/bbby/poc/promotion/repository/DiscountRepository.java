package com.bbby.poc.promotion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bbby.poc.promotion.enums.CURRENCY;
import com.bbby.poc.promotion.model.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    List<Discount> findByDiscountCode(String discountCode);
    
    @Query("select d from Discount d where d.discountCode = ?1 AND d.currency = ?2")
    Discount getCouponDetails(String discountCode, CURRENCY currency);
    
    List<Discount> getDiscountByCurrency(CURRENCY currency);
}
