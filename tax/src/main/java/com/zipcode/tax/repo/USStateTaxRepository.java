package com.zipcode.tax.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zipcode.tax.entity.USTax;

@Repository
public interface USStateTaxRepository extends CrudRepository<USTax, Integer>{

}
