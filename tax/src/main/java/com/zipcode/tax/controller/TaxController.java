package com.zipcode.tax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zipcode.tax.dto.TaxDTO;
import com.zipcode.tax.service.TaxService;

@RestController
public class TaxController {

	@Autowired
	private TaxService taxService;

	@GetMapping(path = "/tax")
	public TaxDTO getTax(@RequestParam String siteID, @RequestParam Integer zipcode, @RequestParam Integer amount) {
		return taxService.getTaxAmount(siteID, zipcode, amount);
	}
}
