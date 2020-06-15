package com.scrutiny.departempdetails.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.scrutiny.departempdetails.model.DepartmentDetail;
import com.scrutiny.departempdetails.model.DepartmentResponse;
import com.scrutiny.departempdetails.model.DetailedResponse;
import com.scrutiny.departempdetails.model.EmployeeDetail;
import com.scrutiny.departempdetails.model.EmployeeResponse;

@RestController
@RequestMapping("/details")
public class DepEmpResource {
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/getDetails")
	public DetailedResponse getDetails(){
//		String departURL="http://localhost:8082/department/getDepartmentDetails";
//		String employeeURL="http://localhost:8083/employee/getemployeeDetails/1";
		String departURL="http://department-details/department/getDepartmentDetails";
		String employeeURL="http://employee-details/employee/getemployeeDetails/1";
		
		DetailedResponse detailedResponse=new DetailedResponse();
		EmployeeResponse employeeResponse;
		
		DepartmentResponse departmentResponse=restTemplate.getForObject(departURL,DepartmentResponse.class);
		List<DepartmentDetail> departmentDetails=departmentResponse.getDepartmentDetails();
		for(DepartmentDetail departmentDetail:departmentDetails) {
			//for each department fetch the employees
			employeeResponse=restTemplate.getForObject(employeeURL,EmployeeResponse.class);
			departmentDetail.setEmployees(employeeResponse.getEmployeeDetails());
		}
		detailedResponse.setDepartmentDetails(departmentDetails);		
		
		return detailedResponse;
	}
	
	public DetailedResponse getHarcodedDetails() {
		DepartmentDetail dd1 = new DepartmentDetail(1, "HR", 
				Collections.singletonList(new EmployeeDetail(1, "Colean")));
		DepartmentDetail dd2 = new DepartmentDetail(2, "Marketing", 
				Collections.singletonList(new EmployeeDetail(2, "Richard")));
		
		DetailedResponse detailedResponse=new DetailedResponse();
		detailedResponse.getDepartmentDetails().add(dd1);
		detailedResponse.getDepartmentDetails().add(dd2);
		return detailedResponse;
	}
}
