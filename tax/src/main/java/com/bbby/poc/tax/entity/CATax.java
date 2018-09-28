package com.bbby.poc.tax.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table(value="CA_ZIPCODE")
public class CATax implements Tax{

	private String zipcode;
	private String state;
	private Integer taxPercent;
	
	@PrimaryKey
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(value="tax")
	public Integer getTaxPercent() {
		return taxPercent;
	}
	public void setTaxPercent(Integer taxPercent) {
		this.taxPercent = taxPercent;
	}	
}
