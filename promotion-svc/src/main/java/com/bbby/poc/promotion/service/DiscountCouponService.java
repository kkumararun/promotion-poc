package com.bbby.poc.promotion.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParseException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import com.bbby.poc.promotion.dto.DiscountDTO;
import com.bbby.poc.promotion.dto.DiscountQueryDTO;
import com.bbby.poc.promotion.enums.DATEFORMATS;
import com.bbby.poc.promotion.enums.DISCOUNTPARAM;
import com.bbby.poc.promotion.enums.DISCOUNTSCOPE;
import com.bbby.poc.promotion.model.Discount;
import com.bbby.poc.promotion.model.DiscountRule;
import com.bbby.poc.promotion.repository.DiscountRepository;

/**
 * The Class DiscountCouponService.
 * 
 */
@Service
public class DiscountCouponService {

	private static final String DATE_FORMATTER = "dateFormatter";

	/** The logger. */
	private static final Logger logger = Logger
			.getLogger(DiscountCouponService.class);

	/** The discount service. */
	@Autowired
	private DiscountRepository discountService;
	
	/** The parser. */
	private ExpressionParser parser = new SpelExpressionParser();

	/**
	 * Apply coupon.
	 * 
	 * @param discountQueryDTO
	 *            the discount query dto
	 * @return the discount dto
	 */
	public DiscountDTO applyCoupon(DiscountQueryDTO discountQueryDTO) {
		DiscountDTO discountDTO = null;
		Map<DISCOUNTPARAM, Object> discountParamMap = discountQueryDTO.getDiscountParams();
		// Get coupon details from db
		Discount discount = discountService.getCouponDetails(
				discountQueryDTO.getDiscountCode(),
				discountQueryDTO.getCurrency());
		if (null != discount) {
			discountParamMap.put(DISCOUNTPARAM.purchaseDate, new Date());
			discountQueryDTO.setDiscountParams(discountParamMap);
			Boolean isApplicable = checkRulesApplicability(discountQueryDTO,
					discount.getDiscountRules(), discount.getDiscountScope());
			discountDTO = DiscountDTO.convert(discount);
			discountDTO.setApplicable(isApplicable);
			/*if(isApplicable==true && discount.getDiscountScope()==DISCOUNTSCOPE.CART) {
				Double orderTotal = (Double) Double.parseDouble("" + discountParamMap.get(DISCOUNTPARAM.orderTotal));
				Double discountAmount = orderTotal * (1 - (discount.getDiscountPercent()/100));
				//DISCOUNTPARAM.orderTotal
				discountDTO.setDiscountAmount(discountAmount);
			} else if(isApplicable==true && discount.getDiscountScope()==DISCOUNTSCOPE.PRODUCT) {
				Double orderTotal = (Double) Double.parseDouble("" + discountParamMap.get(DISCOUNTPARAM.orderTotal));
				Double discountAmount = orderTotal * (1 - (discount.getDiscountPercent()/100));
				//DISCOUNTPARAM.orderTotal
				discountDTO.setDiscountAmount(discountAmount);
			}*/
		}
		return discountDTO;
	}

	/**
	 * Check rules applicability.
	 * 
	 * @param discountQueryDTO
	 *            the discount query dto
	 * @param discountRules
	 *            the discount rules
	 * @return the boolean
	 */
	private Boolean checkRulesApplicability(DiscountQueryDTO discountQueryDTO, Set<DiscountRule> discountRules, DISCOUNTSCOPE discountScope) {
		Boolean isApplicable = true;
		// enrichDiscountQuery(discountQueryDTO);
		EvaluationContext context = new StandardEvaluationContext(discountQueryDTO);
		context.setVariable(DATE_FORMATTER, new SimpleDateFormat(DATEFORMATS.dd_MM_yyyy.getFormatString()));
		try {
			if (discountRules != null && discountRules.size() == 0)
				isApplicable = false;
			for (DiscountRule discountRule : discountRules) {
				logger.debug("Running Rule " + discountRule.getName());
				if(discountScope == DISCOUNTSCOPE.CART) {
					Expression expression = parser.parseExpression(discountRule.getRuleEl());
					isApplicable = isApplicable && expression.getValue(context, Boolean.class);
				} else if(discountScope == DISCOUNTSCOPE.PRODUCT) {
					List<String> list = (List<String>) parser.parseExpression(discountRule.getRuleEl()).getValue(context);
					String productId = (String) discountQueryDTO.getDiscountParams().get(DISCOUNTPARAM.productId);
					isApplicable = list.contains(productId);
				}
			}
		} catch (ParseException exception) {
			isApplicable = false;
			logger.error("Error in parsing EL " + exception.getMessage());
		} catch (Exception ex) {
			isApplicable = false;
			logger.error("Exception : " + ex.getMessage());
		}
		return isApplicable;
	}

	public void enrichDiscountQuery(DiscountQueryDTO discountQueryDTO) {
		if (discountQueryDTO.getDiscountParams() != null && !discountQueryDTO.getDiscountParams().isEmpty()) {
			if (discountQueryDTO.getDiscountParams().get(DISCOUNTPARAM.purchaseDate) != null) {
				Long dateLong = (Long) discountQueryDTO.getDiscountParams().get(DISCOUNTPARAM.purchaseDate);
				discountQueryDTO.getDiscountParams().put(DISCOUNTPARAM.purchaseDate, converToDate(dateLong));
			}

			if (discountQueryDTO.getDiscountParams().get(DISCOUNTPARAM.purchaseDate) != null) {
				Long dateLong = (Long) discountQueryDTO.getDiscountParams() .get(DISCOUNTPARAM.purchaseDate);
				discountQueryDTO.getDiscountParams().put(DISCOUNTPARAM.purchaseDate, converToDate(dateLong));
			}
		}
	}

	public Date converToDate(Long dateLong) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(dateLong);
		cal.setTimeZone(TimeZone.getTimeZone("GMT"));
		return cal.getTime();
	}

}
