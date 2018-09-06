package com.bbby.poc.product.resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bbby.poc.product.response.FusionResponse;

@RestController
@RequestMapping("/rest/product")
public class ProductServiceResource {
	
	private static final Logger LOGGER = Logger.getLogger(ProductServiceResource.class);
	
	@Autowired
	private RestTemplate restTemplate;
		
	@GetMapping("/{searchTerm}")
	public FusionResponse getProduct(@PathVariable("searchTerm") final String searchTerm) {
		LOGGER.info("searching for product with search term : "+ searchTerm);
		ResponseEntity<FusionResponse> response = restTemplate.getForEntity("https://www.bedbathandbeyond.com/api/apollo/collections/bedbath/query-profiles/v1/select?wt=json&q="+searchTerm+"&rows=100&start=0&site=BedBathUS", FusionResponse.class);
		LOGGER.info("received response from SOLR for product with search term : "+ searchTerm);
		return response.getBody();
	}
}
