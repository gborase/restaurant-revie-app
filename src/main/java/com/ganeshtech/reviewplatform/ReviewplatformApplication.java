package com.ganeshtech.reviewplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
public class ReviewplatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewplatformApplication.class, args);
	}

}
