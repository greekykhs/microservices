package com.scrutiny.departdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DepartmentDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentDetailsApplication.class, args);
	}

}
