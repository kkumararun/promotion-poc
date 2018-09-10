package com.bbby.poc.promotion.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bbby.poc.promotion.dto.DiscountCouponResponse;
import com.bbby.poc.promotion.dto.DiscountDTO;
import com.bbby.poc.promotion.dto.DiscountQueryDTO;
import com.bbby.poc.promotion.dto.QueryConstants;
import com.bbby.poc.promotion.dto.UriMappingConstants;
import com.bbby.poc.promotion.enums.CURRENCY;
import com.bbby.poc.promotion.enums.DISCOUNTSCOPE;
import com.bbby.poc.promotion.exception.ResourceNotFoundException;
import com.bbby.poc.promotion.model.Discount;
import com.bbby.poc.promotion.model.DiscountRule;
import com.bbby.poc.promotion.repository.DiscountRepository;
import com.bbby.poc.promotion.repository.DiscountRuleRepository;
import com.bbby.poc.promotion.service.DiscountCouponService;

@RestController
@RequestMapping(value = UriMappingConstants.DISCOUNT_COUPON)
public class DiscountCouponController {

	@Autowired
	DiscountRepository discountService;
	
	@Autowired
	DiscountRuleRepository discountRuleService;

	@Autowired
	DiscountCouponService discountCouponService;
		
	/**
	 * @param dtos
	 * @return
	 * 
	 * To apply coupon codes on multiple products
	 * 
	 */
	@RequestMapping(value = "/applyAll", method = RequestMethod.POST, produces = "application/json")
	public DiscountCouponResponse validateCouponCodes(@RequestBody List<DiscountQueryDTO> dtos) {
		// Do null pre validations for required params
		if(dtos==null) {
			throw new ResourceNotFoundException("DTO query list must not be empty");
		}
		Set<String> productCodes = new HashSet<String>(0);
		DiscountCouponResponse discountCouponResponse = new DiscountCouponResponse();
		for(DiscountQueryDTO discountQueryDTO : dtos){
			DiscountDTO discountDTO = discountCouponService.applyCoupon(discountQueryDTO);
			if(discountDTO != null && discountDTO.getApplicable()){
				productCodes.add(discountQueryDTO.getProductCode());
				discountCouponResponse.setDiscountDTO(discountDTO);
			}
		}
		discountCouponResponse.setProductCodes(productCodes);
		return discountCouponResponse;
	}

	@RequestMapping(value = "/apply", method = RequestMethod.POST, produces = "application/json")
	public DiscountDTO checkAndGetCouponDetails(@RequestBody DiscountQueryDTO dto) {
		// Do null pre validations for required params
		if(dto==null) {
			throw new ResourceNotFoundException("DTO query list must not be empty");
		}
		return discountCouponService.applyCoupon(dto);
	}
	

	@RequestMapping(value = "/listDiscount", method = RequestMethod.GET, produces = "application/json")
	public List<DiscountDTO> listDiscount(HttpServletRequest request, UriComponentsBuilder uriBuilder,
			HttpServletResponse response) {
		
		List<Discount> discountList = discountService.findAll();
		List<DiscountDTO> discountDTO = new ArrayList<DiscountDTO>();
		for(Discount d: discountList) {
			DiscountDTO dto = DiscountDTO.convert(d);
			discountDTO.add(dto);
		}
		return discountDTO;
	}
	

	@RequestMapping(value = "/listDiscountByCurrency", method = RequestMethod.GET, produces = "application/json")
	public List<DiscountDTO> listDiscountByCurrency(
			@RequestParam(QueryConstants.DISCOUNT_CURRENCY) final String currency,
			HttpServletRequest request, UriComponentsBuilder uriBuilder, HttpServletResponse response) {
		
		List<Discount> discountList = discountService.getDiscountByCurrency(CURRENCY.valueOf(currency));
		List<DiscountDTO> discountDTO = new ArrayList<DiscountDTO>();
		for(Discount d: discountList) {
			DiscountDTO dto = DiscountDTO.convert(d);
			discountDTO.add(dto);
		}
		return discountDTO;
	}
	
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
			DiscountRule rule = discountRuleService.listDiscountRuleByExpression(discountArray[i]);
			discountRulesList.add(rule);
			/*if(discount.getCurrency() == rule.getCurrency()){
				discountRulesList.add(rule);
			}*/
		}
		discount.setDiscountRules(discountRulesList);
		discount.setDiscountScope(DISCOUNTSCOPE.valueOf(discountScope));
		discountService.save(discount);
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
		
		Discount discount = discountService.findOne(Long.parseLong(id));
		discount.setActive(Boolean.parseBoolean(applicable));
		discount.setAdditionalNotes(additionalNotes);
		discount.setCurrency(CURRENCY.valueOf(currency));
		discount.setDiscountAmount(Double.parseDouble(discountAmount));
		discount.setDiscountCode(discountCode);
		discount.setDiscountPercent(Double.parseDouble(discountPercent));
		String discountArray[] = discountRules.split("_");
		Set<DiscountRule> discountRulesList = new HashSet<DiscountRule>();
		for(int i=0; i<discountArray.length; i++) {
			DiscountRule rule = discountRuleService.listDiscountRuleByExpression(discountArray[i]);
			if(discount.getCurrency() == rule.getCurrency()){
				discountRulesList.add(rule);
			}
		}
		discount.setDiscountRules(discountRulesList);
		discount.setDiscountScope(DISCOUNTSCOPE.valueOf(discountScope));
		discount.setEndDate(formatDate(endDate));
		discount.setStartDate(formatDate(startDate));
		discountService.save(discount);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/deleteDiscount", method = RequestMethod.POST)
	public void deleteDiscount(
			@RequestParam("id") final String id,
			HttpServletRequest request, UriComponentsBuilder uriBuilder,
			HttpServletResponse response) throws ParseException {
		
		discountService.delete(Long.parseLong(id));
	}
	
	public Date formatDate(String input_dt) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//("MM/dd/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.parse(input_dt);
	}
	
}
