package com.bbby.poc.promotion.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bbby.poc.promotion.dto.DiscountDTO;
import com.bbby.poc.promotion.dto.DiscountQueryDTO;
import com.bbby.poc.promotion.enums.CURRENCY;
import com.bbby.poc.promotion.enums.DISCOUNTPARAM;
import com.bbby.poc.promotion.enums.DISCOUNTSCOPE;
import com.bbby.poc.promotion.enums.RULETYPE;
import com.bbby.poc.promotion.model.Discount;
import com.bbby.poc.promotion.model.DiscountRule;
import com.bbby.poc.promotion.repository.DiscountRepository;
import com.bbby.poc.promotion.repository.DiscountRuleRepository;
import com.bbby.poc.promotion.service.DiscountCouponService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class DiscountTest {

	/** The discount coupon service. */
	@Autowired
	private DiscountCouponService discountCouponService;

	/** The discount service. */
	@Autowired
	private DiscountRepository discountService;
	
	@Autowired
	private DiscountRuleRepository discountRuleService;

	/**
	 * Test create discount coupon.
	 * 
	 * @throws ParseException
	 */
	@Test
	public void testCreateDiscountCouponOrderTotal() throws ParseException {
		if (discountService.findOne(1L) == null) {
			DiscountRule discountRule = new DiscountRule();
			discountRule.setName("10% discount");
			discountRule.setDescription("test 10% discount");
			discountRule.setRuleType(RULETYPE.orderTotal);
			discountRule.setRuleEl(DISCOUNTPARAM.orderTotal.getElPlaceHolder() + ">3000");
			discountRule.setCurrency(CURRENCY.USD);
			Set<DiscountRule> discountRules = new HashSet<DiscountRule>();
			discountRuleService.save(discountRule);
			discountRules.add(discountRule);
			Discount discount = new Discount();
			discount.setActive(true);
			discount.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse("15/07/2018"));
			discount.setStartDate(new Date());
			discount.setCurrency(CURRENCY.USD);
			discount.setDiscountPercent(5.0);
			discount.setDiscountRules(discountRules);
			discount.setDiscountScope(DISCOUNTSCOPE.CART);
			discount.setDiscountCode("10PERCENT");
			// discount.setDiscountCode(IDGENERATOR.COUPONCODE.getIdentifier());
			// -- use in actual call
			discountService.save(discount);
		}
	}
	
	@Test
	public void testCreateDiscountCouponDates() throws ParseException {
		DiscountRule discountRule = new DiscountRule();
		discountRule.setName("Date discount");
		discountRule.setDescription("Cart Value discount");
		discountRule.setRuleType(RULETYPE.purchaseDate);
		discountRule.setRuleEl(DISCOUNTPARAM.purchaseDate.getElPlaceHolder() + ".after(#dateFormatter.parse('01/07/2018'))");
		discountRule.setCurrency(CURRENCY.USD);
		Set<DiscountRule> discountRules = new HashSet<DiscountRule>();
		discountRuleService.save(discountRule);
		discountRules.add(discountRule);
		Discount discount = new Discount();
		discount.setActive(true);
		discount.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse("30/07/2018"));
		discount.setStartDate(new Date());
		discount.setCurrency(CURRENCY.USD);
		discount.setDiscountPercent(5.0);
		discount.setDiscountRules(discountRules);
		discount.setDiscountScope(DISCOUNTSCOPE.CART);
		discount.setDiscountCode("COOLSEP");
		// discount.setDiscountCode(IDGENERATOR.COUPONCODE.getIdentifier());
		// -- use in actual call
		discountService.save(discount);
		
	}
	
	
	@Test
	public void testDiscountRuleApplicabilityDateSuccess() throws ParseException, JsonProcessingException {
		DiscountQueryDTO discountQueryDTO = new DiscountQueryDTO();
		discountQueryDTO.setDiscountCode("COOLSEP");
		Map<DISCOUNTPARAM, Object> discountParams = new HashMap<DISCOUNTPARAM, Object>();
		discountParams.put(DISCOUNTPARAM.orderTotal, 4500);
		discountParams.put(DISCOUNTPARAM.productCategory, null);
		discountParams.put(DISCOUNTPARAM.purchaseDate, new Date());
		discountParams.put(DISCOUNTPARAM.productId, null);
		discountParams.put(DISCOUNTPARAM.userId, "QWERTY1");
		//discountParams.put(DISCOUNTPARAM.purchaseDate, new SimpleDateFormat("dd/MM/yyyy").parse("09/07/2018"));
		discountQueryDTO.setDiscountParams(discountParams);
		discountQueryDTO.setCurrency(CURRENCY.USD);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(discountQueryDTO);
		System.out.println(jsonInString);
		DiscountDTO dto = discountCouponService.applyCoupon(discountQueryDTO);
		assertTrue(dto.getApplicable());
	}

	/**
	 * Test discount rule applicability success.
	 * @throws JsonProcessingException 
	 */
	@Test
	public void testDiscountRuleApplicabilitySuccess() throws JsonProcessingException {
		DiscountQueryDTO discountQueryDTO = new DiscountQueryDTO();
		discountQueryDTO.setDiscountCode("10PERCENT");
		Map<DISCOUNTPARAM, Object> discountParams = new HashMap<DISCOUNTPARAM, Object>();
		discountParams.put(DISCOUNTPARAM.orderTotal, 4500);
		discountParams.put(DISCOUNTPARAM.purchaseDate, new Date());
		discountQueryDTO.setDiscountParams(discountParams);
		discountQueryDTO.setCurrency(CURRENCY.USD);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(discountQueryDTO);
		System.out.println(jsonInString);
		DiscountDTO dto = discountCouponService.applyCoupon(discountQueryDTO);
		assertTrue(dto.getApplicable());
	}

	/**
	 * Test discount rule applicability failure.
	 */
	@Test
	public void testDiscountRuleApplicabilityFailure() {
		DiscountQueryDTO discountQueryDTO = new DiscountQueryDTO();
		discountQueryDTO.setDiscountCode("FAILME");
		Map<DISCOUNTPARAM, Object> discountParams = new HashMap<DISCOUNTPARAM, Object>();
		discountParams.put(DISCOUNTPARAM.orderTotal, 1);
		discountQueryDTO.setDiscountParams(discountParams);
		DiscountDTO dto = discountCouponService.applyCoupon(discountQueryDTO);
		assertFalse(dto.getApplicable());
	}
}
