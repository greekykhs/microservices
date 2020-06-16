package com.scrutiny.departempdetails.service;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.scrutiny.departempdetails.model.DepartmentDetail;
import com.scrutiny.departempdetails.model.DepartmentResponse;
import com.scrutiny.departempdetails.model.EmployeeDetail;

@Service
public class DepartmentService {
	@Autowired
	RestTemplate restTemplate;
	/*
	@HystrixCommand(fallbackMethod = "fallbackGetDepartmentDetails", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "110"),
	        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
	        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "20"), 
	        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") })
	*/
	
	/*
	@HystrixCommand(fallbackMethod = "fallbackGetDepartmentDetails",
			commandProperties = {
			@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
		})
	*/		
	@HystrixCommand(fallbackMethod = "fallbackGetDepartmentDetails", 
			threadPoolKey = "threadPoolDepartmentDetails", 
			threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "15"), 
			@HystrixProperty(name = "maxQueueSize", value = "5") },
			commandProperties = { 
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "75"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "7000"),
					@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "15000"),
					@HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "5") }
			)
	public DepartmentResponse getDepartmentDetails(String departURL) {
		return restTemplate.getForObject(departURL, DepartmentResponse.class);
	}

	public DepartmentResponse fallbackGetDepartmentDetails(String departURL) {
		DepartmentDetail dd1 = new DepartmentDetail(1, "HR",
				Collections.singletonList(new EmployeeDetail(1, "Colean")));
		DepartmentDetail dd2 = new DepartmentDetail(2, "Marketing",
				Collections.singletonList(new EmployeeDetail(2, "Richard")));

		DepartmentResponse departmentResponse = new DepartmentResponse();
		departmentResponse.getDepartmentDetails().add(dd1);
		departmentResponse.getDepartmentDetails().add(dd2);
		return departmentResponse;
	}
}
