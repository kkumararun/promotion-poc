package com.zipcode.tax.dto;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.zipcode.tax.entity.CATax;
import com.zipcode.tax.entity.USTax;

@Component
public class TaxDTO {
	
	private Integer zipcode;
	private String state;
	private Integer taxPercent;
	private BigDecimal taxTobePaid;
	
	
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getTaxPercent() {
		return taxPercent;
	}
	public void setTaxPercent(Integer taxPercent) {
		this.taxPercent = taxPercent;
	}
	public BigDecimal getTaxTobePaid() {
		return taxTobePaid;
	}
	public void setTaxTobePaid(BigDecimal taxTobePaid) {
		this.taxTobePaid = taxTobePaid;
	}
	
	public TaxDTO convert(USTax tax,BigDecimal taxToBePaid) {	
		TaxDTO taxDTO=new TaxDTO();
		taxDTO.setZipcode(tax.getZipcode());
		taxDTO.setState(tax.getState());
		taxDTO.setTaxPercent(tax.getTaxPercent());
		taxDTO.setTaxTobePaid(taxToBePaid);				
		return taxDTO;		
	}
	
	public TaxDTO convertToCADTO(CATax tax, BigDecimal taxToBePaid) {
		TaxDTO taxDTO=new TaxDTO();
		taxDTO.setZipcode(tax.getZipcode());
		taxDTO.setState(tax.getState());
		taxDTO.setTaxPercent(tax.getTaxPercent());
		taxDTO.setTaxTobePaid(taxToBePaid);				
		return taxDTO;		
	}

}
