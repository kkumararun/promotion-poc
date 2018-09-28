package com.bbby.poc.tax.service;


import com.bbby.poc.tax.dto.TaxDTO;

public interface TaxService {	
	public TaxDTO getTaxAmount(String siteId, String zipcode,Integer amount);
		
}
