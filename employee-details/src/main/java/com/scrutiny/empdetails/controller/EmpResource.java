package com.scrutiny.empdetails.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.scrutiny.empdetails.model.EmployeeDetail;
import com.scrutiny.empdetails.model.EmployeeResponse;

@RestController
@RequestMapping("/employee")
public class EmpResource {
	@RequestMapping("/getemployeeDetails/{departmentId}")
	public EmployeeResponse getDetails(@PathVariable("departmentId") int departmentId){
		return getEmployees(departmentId);
	}
	
	public EmployeeResponse getEmployees(int departmentId) {
		EmployeeDetail e1 = new EmployeeDetail(1, "Colean");
		EmployeeDetail e2 = new EmployeeDetail(2, "Richard");
		
		List<EmployeeDetail> employeeDetails=new ArrayList<EmployeeDetail>();	
		employeeDetails.add(e1);
		employeeDetails.add(e2);
		EmployeeResponse employeeResponse=new EmployeeResponse();
		employeeResponse.setEmployeeDetails(employeeDetails);
		return employeeResponse;
	}
}
