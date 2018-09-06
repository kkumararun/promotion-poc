package com.bbby.poc.promotion.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbby.poc.promotion.model.Discount;
import com.bbby.poc.promotion.repository.DiscountRepository;

@RestController
@RequestMapping("/rest/db")
public class PromotionResource {

	private DiscountRepository discountRepository;

    public PromotionResource(DiscountRepository quotesRepository) {
        this.discountRepository = quotesRepository;
    }

    @GetMapping("/list")
    public List<Discount> getQuotes() {
    	return discountRepository.findAll();
    }	
	
}
