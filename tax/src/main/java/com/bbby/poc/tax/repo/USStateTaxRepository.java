package com.bbby.poc.tax.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bbby.poc.tax.entity.USTax;

@Repository
public interface USStateTaxRepository extends CrudRepository<USTax, Integer>{

}
