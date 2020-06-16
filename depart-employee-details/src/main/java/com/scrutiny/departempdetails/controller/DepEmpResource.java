package com.scrutiny.departempdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scrutiny.departempdetails.model.DepartmentDetail;
import com.scrutiny.departempdetails.model.DepartmentResponse;
import com.scrutiny.departempdetails.model.DetailedResponse;
import com.scrutiny.departempdetails.service.DepartmentService;
import com.scrutiny.departempdetails.service.EmployeeService;

@RestController
@RequestMapping("/details")
public class DepEmpResource {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping("/getDetails")	
	public DetailedResponse getDetails(){
//		String departURL="http://localhost:8082/department/getDepartmentDetails";
//		String employeeURL="http://localhost:8083/employee/getemployeeDetails/1";
		String departURL="http://department-details/department/getDepartmentDetails";
		String employeeURL="http://employee-details/employee/getemployeeDetails/1";
		
		DetailedResponse detailedResponse=new DetailedResponse();		
		
		DepartmentResponse departmentResponse=departmentService.getDepartmentDetails(departURL);
		List<DepartmentDetail> departmentDetails=employeeService.getemployeeDetails(employeeURL, departmentResponse);		
		detailedResponse.setDepartmentDetails(departmentDetails);	
		return detailedResponse;
	}	
}
