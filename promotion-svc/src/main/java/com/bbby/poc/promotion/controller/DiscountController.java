package com.bbby.poc.promotion.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bbby.poc.promotion.dto.QueryConstants;
import com.bbby.poc.promotion.dto.UriMappingConstants;
import com.bbby.poc.promotion.enums.CURRENCY;
import com.bbby.poc.promotion.enums.DISCOUNTSCOPE;
import com.bbby.poc.promotion.model.Discount;
import com.bbby.poc.promotion.model.DiscountRule;
import com.bbby.poc.promotion.repository.DiscountRepository;
import com.bbby.poc.promotion.repository.DiscountRuleRepository;

@RestController
@RequestMapping(value = UriMappingConstants.DISCOUNT)
public class DiscountController {
	
	@Autowired
	DiscountRepository discountRepository;
	
	@Autowired
	DiscountRuleRepository discountRuleRepository;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/saveDiscount", method = RequestMethod.POST)
	public void saveDiscount(
			@RequestParam(QueryConstants.DISCOUNT_CODE) final String discountCode,
			@RequestParam(QueryConstants.DISCOUNT_PERCENT) final String discountPercent,
			@RequestParam(QueryConstants.DISCOUNT_AMOUNT) final String discountAmount,
			@RequestParam(QueryConstants.DISCOUNT_CURRENCY) final String currency,
			@RequestParam(QueryConstants.DISCOUNT_ADDITIONALNOTES) final String additionalNotes,
			@RequestParam(QueryConstants.DISCOUNT_SCOPE) final String discountScope,
			@RequestParam(QueryConstants.DISCOUNT_RULES) final String discountRules,
			@RequestParam(QueryConstants.DISCOUNT_APPLICABLE) final String applicable,
			HttpServletRequest request, UriComponentsBuilder uriBuilder,
			HttpServletResponse response) throws ParseException {
		
		Discount discount = new Discount();
		discount.setActive(Boolean.parseBoolean(applicable));
		discount.setAdditionalNotes(additionalNotes);
		discount.setCurrency(CURRENCY.valueOf(currency));
		if(discountPercent==null || discountPercent.equals("") || discountPercent.equals("0")){
			discount.setDiscountPercent(null);
		} else{
			discount.setDiscountPercent(Double.parseDouble(discountPercent));
		}
		if(discountAmount==null || discountAmount.equals("") || discountAmount.equals("0")){
			discount.setDiscountAmount(null);
		} else{
			discount.setDiscountAmount(Double.parseDouble(discountAmount));
		}
		discount.setDiscountCode(discountCode);
		
		String discountArray[] = discountRules.split("_");
		Set<DiscountRule> discountRulesList = new HashSet<DiscountRule>();
		for(int i=0; i<discountArray.length; i++) {
			DiscountRule rule = null;//discountRuleService.get(Long.parseLong(discountArray[i]));//listDiscountRuleByExpression(discountArray[i]);
			discountRulesList.add(rule);
			/*if(discount.getCurrency() == rule.getCurrency()){
				discountRulesList.add(rule);
			}*/
		}
		discount.setDiscountRules(discountRulesList);
		discount.setDiscountScope(DISCOUNTSCOPE.valueOf(discountScope));
		discountRepository.save(discount);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/updateDiscount", method = RequestMethod.POST)
	public void updateDiscount(
			@RequestParam(QueryConstants.ID) final String id,
			@RequestParam(QueryConstants.DISCOUNT_CODE) final String discountCode,
			@RequestParam(QueryConstants.DISCOUNT_PERCENT) final String discountPercent,
			@RequestParam(QueryConstants.DISCOUNT_AMOUNT) final String discountAmount,
			@RequestParam(QueryConstants.DISCOUNT_CURRENCY) final String currency,
			@RequestParam(QueryConstants.DISCOUNT_STARTDATE) final String startDate,
			@RequestParam(QueryConstants.DISCOUNT_ENDDATE) final String endDate,
			@RequestParam(QueryConstants.DISCOUNT_ADDITIONALNOTES) final String additionalNotes,
			@RequestParam(QueryConstants.DISCOUNT_SCOPE) final String discountScope,
			@RequestParam(QueryConstants.DISCOUNT_RULES) final String discountRules,
			@RequestParam(QueryConstants.DISCOUNT_APPLICABLE) final String applicable,
			HttpServletRequest request, UriComponentsBuilder uriBuilder,
			HttpServletResponse response) throws ParseException {
		
		Discount discount = discountRepository.findOne(Long.parseLong(id));
		discount.setActive(Boolean.parseBoolean(applicable));
		discount.setAdditionalNotes(additionalNotes);
		discount.setCurrency(CURRENCY.valueOf(currency));
		discount.setDiscountAmount(Double.parseDouble(discountAmount));
		discount.setDiscountCode(discountCode);
		discount.setDiscountPercent(Double.parseDouble(discountPercent));
		String discountArray[] = discountRules.split("_");
		Set<DiscountRule> discountRulesList = new HashSet<DiscountRule>();
		for(int i=0; i<discountArray.length; i++) {
			DiscountRule rule = discountRuleRepository.listDiscountRuleByExpression(discountArray[i]);
			if(discount.getCurrency() == rule.getCurrency()){
				discountRulesList.add(rule);
			}
		}
		discount.setDiscountRules(discountRulesList);
		discount.setDiscountScope(DISCOUNTSCOPE.valueOf(discountScope));
		discount.setEndDate(formatDate(endDate));
		discount.setStartDate(formatDate(startDate));
		discountRepository.save(discount);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/deleteDiscount", method = RequestMethod.POST)
	public void deleteDiscount(
			@RequestParam("id") final String id,
			HttpServletRequest request, UriComponentsBuilder uriBuilder,
			HttpServletResponse response) throws ParseException {
		
		discountRepository.delete(Long.parseLong(id));
	}
	
	private Date formatDate(String input_dt) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//("MM/dd/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.parse(input_dt);
	}

}
