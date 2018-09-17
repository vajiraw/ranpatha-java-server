package com.ranpatha.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories({"com.ranpatha.search.service"})

public class SearchApplication {
	
	@Autowired
	  private MongoTemplate mongoTemplate;


	public static void main(String[] args) {
		SpringApplication.run(SearchApplication.class, args);
	}
}
