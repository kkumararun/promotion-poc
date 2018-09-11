package com.bbby.poc.promotion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@EnableJpaRepositories(basePackages = "com.bbby.poc.promotion.repository")
@EnableAutoConfiguration//(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class PromotionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromotionServiceApplication.class, args);
	}
}
