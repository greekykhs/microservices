package com.scrutiny.departempdetails.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.scrutiny.departempdetails.model.DepartmentDetail;
import com.scrutiny.departempdetails.model.DepartmentResponse;
import com.scrutiny.departempdetails.model.EmployeeDetail;
import com.scrutiny.departempdetails.model.EmployeeResponse;

@Service
public class EmployeeService {
	@Autowired
	RestTemplate restTemplate;
	@HystrixCommand(fallbackMethod = "fallbackGetemployeeDetails", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "110"),
	        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
	        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "20"), 
	        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") })
	public List<DepartmentDetail> getemployeeDetails(String employeeURL, DepartmentResponse departmentResponse) {
		EmployeeResponse employeeResponse;
		List<DepartmentDetail> departmentDetails=departmentResponse.getDepartmentDetails();
		for(DepartmentDetail departmentDetail:departmentDetails) {
			//for each department fetch the employees
			employeeResponse=restTemplate.getForObject(employeeURL,EmployeeResponse.class);
			departmentDetail.setEmployees(employeeResponse.getEmployeeDetails());
		}		
		return departmentDetails;
	}	
	public List<DepartmentDetail> fallbackGetemployeeDetails(String employeeURL, DepartmentResponse departmentResponse) {	
		List<DepartmentDetail> departmentDetails=departmentResponse.getDepartmentDetails();
		for(DepartmentDetail departmentDetail:departmentDetails) {
			EmployeeDetail e1 = new EmployeeDetail(1, "Colean");
			EmployeeDetail e2 = new EmployeeDetail(2, "Richard");			
			List<EmployeeDetail> employeeDetails=new ArrayList<EmployeeDetail>();	
			employeeDetails.add(e1);employeeDetails.add(e2);
			departmentDetail.setEmployees(employeeDetails);
		}		
		return departmentDetails;
	}	
}
