package com.bbby.poc.promotion.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bbby.poc.promotion.enums.CURRENCY;
import com.bbby.poc.promotion.enums.DISCOUNTPARAM;
import com.bbby.poc.promotion.enums.DISCOUNTSCOPE;
import com.bbby.poc.promotion.enums.RULETYPE;
import com.bbby.poc.promotion.model.Discount;
import com.bbby.poc.promotion.model.DiscountRule;
import com.bbby.poc.promotion.repository.DiscountRepository;
import com.bbby.poc.promotion.repository.DiscountRuleRepository;
import com.bbby.poc.promotion.service.DiscountCouponService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class DiscountCreationTest {

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
			DiscountRule discountRule = new DiscountRule();
			discountRule.setName("10% discount");
			discountRule.setDescription("test 10% discount");
			discountRule.setRuleType(RULETYPE.orderTotal);
			discountRule.setRuleEl(DISCOUNTPARAM.orderTotal.getElPlaceHolder() + ">100");
			discountRule.setCurrency(CURRENCY.USD);
			Set<DiscountRule> discountRules = new HashSet<DiscountRule>();
			discountRuleService.save(discountRule);
			discountRules.add(discountRule);
			Discount discount = new Discount();
			discount.setActive(true);
			discount.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse("15/07/2018"));
			discount.setStartDate(new Date());
			discount.setCurrency(CURRENCY.USD);
			discount.setDiscountPercent(10.0);
			discount.setDiscountRules(discountRules);
			discount.setDiscountScope(DISCOUNTSCOPE.CART);
			discount.setDiscountCode("10PERCENT");
			// discount.setDiscountCode(IDGENERATOR.COUPONCODE.getIdentifier());
			// -- use in actual call
			discountService.save(discount);
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
	public void testCreateDiscountCouponProdCategory() throws ParseException {
		//if (discountService.findOne(1L) == null) {
			DiscountRule discountRule = new DiscountRule();
			discountRule.setName("discount on strollers");
			discountRule.setDescription("test 5% discount");
			discountRule.setRuleType(RULETYPE.productCategory);
			discountRule.setRuleEl(DISCOUNTPARAM.productCategory.getElPlaceHolder() + ".toLowerCase().contains('stroller')");
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
			discount.setDiscountCode("STROLLON");
			// discount.setDiscountCode(IDGENERATOR.COUPONCODE.getIdentifier());
			// -- use in actual call
			discountService.save(discount);
		//}
	}
	
	@Test
	public void testCreateDiscountCouponUserId() throws ParseException {
		//if (discountService.findOne(1L) == null) {
			DiscountRule discountRule = new DiscountRule();
			discountRule.setName("discount for user");
			discountRule.setDescription("test 5% discount");
			discountRule.setRuleType(RULETYPE.userId);
			discountRule.setRuleEl(DISCOUNTPARAM.userId.getElPlaceHolder() + ".equals('QWERTY1')");
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
			discount.setDiscountCode("SPECIAL");
			// discount.setDiscountCode(IDGENERATOR.COUPONCODE.getIdentifier());
			// -- use in actual call
			discountService.save(discount);
		//}
	}
	
	@Test
	public void testCreateDiscountCouponProductId() throws ParseException {
		//if (discountService.findOne(1L) == null) {
			DiscountRule discountRule = new DiscountRule();
			discountRule.setName("discount for prod 1");
			discountRule.setDescription("test PROD1 discount");
			discountRule.setRuleType(RULETYPE.productId);
			discountRule.setRuleEl("{'PROD1', 'PROD2', 'PROD3', 'PROD4'}");
			discountRule.setCurrency(CURRENCY.USD);
			discountRuleService.save(discountRule);
			Set<DiscountRule> discountRules = new HashSet<DiscountRule>();
			discountRules.add(discountRule);
			Discount discount = new Discount();
			discount.setActive(true);
			discount.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse("15/07/2018"));
			discount.setStartDate(new Date());
			discount.setCurrency(CURRENCY.USD);
			discount.setDiscountPercent(5.0);
			discount.setDiscountRules(discountRules);
			discount.setDiscountScope(DISCOUNTSCOPE.PRODUCT);
			discount.setDiscountCode("MULTIPROD");
			// discount.setDiscountCode(IDGENERATOR.COUPONCODE.getIdentifier());
			// -- use in actual call
			discountService.save(discount);
		//}
	}
}
