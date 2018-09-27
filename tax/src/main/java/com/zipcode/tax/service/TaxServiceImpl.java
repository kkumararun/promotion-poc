package com.zipcode.tax.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zipcode.tax.dto.TaxDTO;
import com.zipcode.tax.entity.CATax;
import com.zipcode.tax.entity.USTax;
import com.zipcode.tax.repo.CAStateTaxRepository;
import com.zipcode.tax.repo.USStateTaxRepository;

/**
 * @author Arun Kumar (BA03203)
 *
 */
@Service
public class TaxServiceImpl implements TaxService {

	@Autowired
	private USStateTaxRepository usStateTaxRepository;

	@Autowired
	private CAStateTaxRepository caStateTaxRepository;

	@Autowired
	private TaxDTO taxDTO;

	/* (non-Javadoc)
	 * @see com.zipcode.tax.service.TaxService
	 * #getTaxAmount(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public TaxDTO getTaxAmount(String siteID, Integer zipcode, Integer amount) {

		if (siteID.equalsIgnoreCase("US"))
			return getTaxForUS(zipcode, amount);
		else if (siteID.equalsIgnoreCase("CA"))
			return getTaxForCA(zipcode, amount);

		return null;
	}

	/**
	 * @param zipcode
	 * @param amount
	 * @return TaxDTO object
	 */
	private TaxDTO getTaxForUS(Integer zipcode, Integer amount) {
		USTax tax = usStateTaxRepository.findOne(zipcode);
		BigDecimal taxToBePaid = new BigDecimal((tax.getTaxPercent() * amount) / 100);
		return taxDTO.convert(tax, taxToBePaid);
	}

	/**
	 * @param zipcode
	 * @param amount
	 * @return TaxDTO object
	 */
	private TaxDTO getTaxForCA(Integer zipcode, Integer amount) {
		CATax tax = caStateTaxRepository.findOne(zipcode);
		BigDecimal taxToBePaid = new BigDecimal((tax.getTaxPercent() * amount) / 100);
		return taxDTO.convertToCADTO(tax, taxToBePaid);
	}
}
