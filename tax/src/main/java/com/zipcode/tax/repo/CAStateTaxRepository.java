package com.zipcode.tax.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zipcode.tax.entity.CATax;

@Repository
public interface CAStateTaxRepository extends CrudRepository<CATax, Integer>{

}
