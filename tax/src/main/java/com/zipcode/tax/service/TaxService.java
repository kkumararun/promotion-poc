package com.zipcode.tax.service;


import com.zipcode.tax.dto.TaxDTO;

public interface TaxService {	
	public TaxDTO getTaxAmount(String siteId, Integer zipcode,Integer amount);
		
}
