package com.bbby.poc.promotion.controller;

import java.util.List;

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
import com.bbby.poc.promotion.enums.DISCOUNTPARAM;
import com.bbby.poc.promotion.enums.RULETYPE;
import com.bbby.poc.promotion.model.DiscountRule;
import com.bbby.poc.promotion.repository.DiscountRepository;
import com.bbby.poc.promotion.repository.DiscountRuleRepository;

@RestController
@RequestMapping(value = UriMappingConstants.DISCOUNT_RULE)
public class DiscountRuleController {
	
	@Autowired
	DiscountRepository discountRepository;
	
	@Autowired
	DiscountRuleRepository discountRuleRepository;
	
	@RequestMapping(value = "/listDiscountRule", method = RequestMethod.GET, produces = "application/json")
	public List<DiscountRule> listDiscountRule(HttpServletRequest request, UriComponentsBuilder uriBuilder,
			HttpServletResponse response) {
		List<DiscountRule> discountRuleList = discountRuleRepository.findAll();
		return discountRuleList;
	}
	
	@RequestMapping(value = "/listDiscountRuleByExpression", method = RequestMethod.GET, produces = "application/json")
	public DiscountRule listDiscountRuleByExpression(
			@RequestParam(QueryConstants.DISCOUNT_RULE_EXPRESSION) final String ruleEl,
			HttpServletRequest request, UriComponentsBuilder uriBuilder,
			HttpServletResponse response) {
		
		DiscountRule discountRule = discountRuleRepository.listDiscountRuleByExpression(ruleEl);
		return discountRule;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/saveDiscountRule", method = RequestMethod.POST )
	public void saveDiscountRule(
			@RequestParam(QueryConstants.DISCOUNT_RULE_DESCRIPTION) final String description,
			@RequestParam(QueryConstants.DISCOUNT_RULE_NAME) final String name,
			@RequestParam(QueryConstants.DISCOUNT_RULE_EXPRESSION) String ruleEl,
			@RequestParam(QueryConstants.DISCOUNT_RULE_TYPE) final String ruleType,
			//@RequestParam(QueryConstants.DISCOUNT_CURRENCY) final String currency,
			HttpServletRequest request, UriComponentsBuilder uriBuilder,
			HttpServletResponse response) {
		
		if(RULETYPE.valueOf(ruleType)==RULETYPE.orderTotal){
			ruleEl = DISCOUNTPARAM.orderTotal.getElPlaceHolder() + ruleEl;
		}
		if(RULETYPE.valueOf(ruleType)==RULETYPE.purchaseDate){
			String purchaseDate = ruleEl.replaceAll("==", "");
			purchaseDate = purchaseDate.replaceAll(">=", "");
			purchaseDate = purchaseDate.replaceAll("<=", "");
			purchaseDate = purchaseDate.replaceAll(">", "");
			purchaseDate = purchaseDate.replaceAll("<", "");
			String operator = ruleEl.replaceAll(purchaseDate, "");
			String ruleDate = "";
			if(operator.equals("==")){
				ruleDate = ".equals(#dateFormatter.parse(\""+ purchaseDate + "\"))";
			} else if(operator.equals(">")){
				ruleDate = ".after(#dateFormatter.parse(\""+ purchaseDate + "\"))";
			} else if(operator.equals("<")){
				ruleDate = ".before(#dateFormatter.parse(\""+ purchaseDate + "\"))";
			}
			ruleEl = ruleDate;
			//".after(#dateFormatter.parse('15/08/2014'))"
			ruleEl = DISCOUNTPARAM.purchaseDate.getElPlaceHolder() + ruleEl;
		}
		if(RULETYPE.valueOf(ruleType)==RULETYPE.productId){
			String[] tempRule = ruleEl.split("==");
			String productId = tempRule[1];
			ruleEl = ".equals(\"" + productId + "\")";
			ruleEl = DISCOUNTPARAM.productId.getElPlaceHolder() + ruleEl;
		}
		if(RULETYPE.valueOf(ruleType)==RULETYPE.productCategory){
			String[] tempRule = ruleEl.split("==");
			String productCategory = tempRule[1];
			ruleEl = ".equals(\"" + productCategory + "\")";
			ruleEl = DISCOUNTPARAM.productCategory.getElPlaceHolder() + ruleEl;
		}
		if(RULETYPE.valueOf(ruleType)==RULETYPE.userId){
			String[] tempRule = ruleEl.split("==");
			String userId = tempRule[1];
			ruleEl = ".equals(\"" + userId + "\")";
			ruleEl = DISCOUNTPARAM.userId.getElPlaceHolder() + ruleEl;
		}
		DiscountRule discountRule = new DiscountRule();
		discountRule.setDescription(description);
		discountRule.setName(name);
		discountRule.setRuleEl(ruleEl);
		discountRule.setRuleType(RULETYPE.valueOf(ruleType));
		//discountRule.setCurrency(CURRENCY.valueOf(currency));
		discountRuleRepository.save(discountRule);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/updateDiscountRule", method = RequestMethod.POST )
	public void updateDiscountRule(
			@RequestParam(QueryConstants.ID) final String id,
			@RequestParam(QueryConstants.DISCOUNT_RULE_DESCRIPTION) final String description,
			@RequestParam(QueryConstants.DISCOUNT_RULE_NAME) final String name,
			@RequestParam(QueryConstants.DISCOUNT_RULE_EXPRESSION) final String ruleEl,
			@RequestParam(QueryConstants.DISCOUNT_RULE_TYPE) final String ruleType,
			//@RequestParam(QueryConstants.DISCOUNT_CURRENCY) final String currency,
			HttpServletRequest request, UriComponentsBuilder uriBuilder,
			HttpServletResponse response) {
		
		DiscountRule discountRule = discountRuleRepository.getOne(Integer.parseInt(id));//.get(Long.parseLong(id));
		discountRule.setDescription(description);
		discountRule.setName(name);
		discountRule.setRuleEl(ruleEl);
		discountRule.setRuleType(RULETYPE.valueOf(ruleType));
		//discountRule.setCurrency(CURRENCY.valueOf(currency));
		discountRuleRepository.save(discountRule);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/deleteDiscountRule", method = RequestMethod.POST)
	public void deteleDiscountRule(@RequestParam(QueryConstants.ID) final String discountRuleId,
			HttpServletRequest request, UriComponentsBuilder uriBuilder,
			HttpServletResponse response) {
		discountRuleRepository.delete(Integer.parseInt(discountRuleId));
		}
	
}
