package com.bbby.poc.promotion.dto;

import org.springframework.data.domain.Sort;

public final class QueryConstants {

	public static final String QUESTIONMARK = "?";

	public static final String PAGE = "page";
	public static final String SIZE = "size";
	public static final String SORT_BY = "sortBy";
	public static final String SORT_ORDER = "sortOrder";
	public static final String Q_SORT_BY = QUESTIONMARK + SORT_BY + QueryConstants.OP;
	public static final String S_ORDER = QueryConstants.SEPARATOR_AMPER + QueryConstants.SORT_ORDER + QueryConstants.OP;
	public static final String S_ORDER_ASC = S_ORDER + Sort.Direction.ASC.name();
	public static final String S_ORDER_DESC = S_ORDER + Sort.Direction.DESC.name();
	public static final String P_EMAIL = "email";
	public static final String P_NAME = "name";
	public static final String P_IPADDRESS = "ipaddress";
	
	public static final String GATEWAY_ORDER_ID = "gatewayOrderId";
	public static final String START_DATE = "startDate";
	public static final String END_DATE = "endDate";

	/**
	 * - note: this character represents the ANY wildcard for the server side
	 * (persistence layer)
	 */
	public static final String ANY_SERVER = "%";
	/**
	 * - note: this character represents the ANY wildcard for the client
	 * consumption of the API
	 */
	public static final String ANY_CLIENT = "*";
	public static final String QUERY_PREFIX = QUESTIONMARK + "q=";
	public static final String Q_PARAM = "q";
	public static final String SEPARATOR = ",";
	public static final String SEPARATOR_AMPER = "&";
	public static final String OP = "=";
	public static final String NEGATION = "~";

	public static final String ID = "id"; // is constant because it's used for
											// the controller mapping
	
	public static final String MARKUP_PERCENT = "markupPercent";
	public static final String MARKUP_AMOUNT = "markupAmount";
	
	public static final String DISCOUNT_CODE = "discountCode";
	public static final String DISCOUNT_PERCENT = "discountPercent";
	public static final String DISCOUNT_AMOUNT = "discountAmount";
	public static final String DISCOUNT_CURRENCY = "currency";
	public static final String DISCOUNT_STARTDATE = "startDate";
	public static final String DISCOUNT_ENDDATE = "endDate";
	public static final String DISCOUNT_ADDITIONALNOTES = "additionalNotes";
	public static final String DISCOUNT_SCOPE = "discountScope";
	public static final String DISCOUNT_RULES = "discountRules";
	public static final String DISCOUNT_APPLICABLE = "applicable";
	
	public static final String DISCOUNT_RULE_NAME = "discountRuleName";
	public static final String DISCOUNT_RULE_DESCRIPTION = "discountRuleDescription";
	public static final String DISCOUNT_RULE_EXPRESSION = "discountRuleExpression";
	public static final String DISCOUNT_RULE_TYPE = "discountRuleType";
		
	public static final String EMAIL_TEMPLATE_ID = "emailTemplateId";
	public static final String EMAIL_TEMPLATE_NAME = "emailTemplateName";
	public static final String EMAIL_TEMPLATE_SUBJECT = "emailTemplateSubject";
	public static final String EMAIL_TEMPLATE_FROM = "emailTemplateFrom";
	public static final String EMAIL_TEMPLATE_DESCRIPTION = "emailTemplateDescription";
	public static final String EMAIL_TEMPLATE_LAST_MODIFIED = "emailTemplateLastModified";

	
	private QueryConstants() {
		throw new AssertionError();
	}

}
