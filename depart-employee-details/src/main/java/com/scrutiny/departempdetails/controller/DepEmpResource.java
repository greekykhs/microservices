package com.scrutiny.departempdetails.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.scrutiny.departempdetails.model.DepartmentDetail;
import com.scrutiny.departempdetails.model.DetailedResponse;
import com.scrutiny.departempdetails.model.EmployeeDetail;

@RestController
@RequestMapping("/details")
public class DepEmpResource {
	@RequestMapping("/getDetails")
	public DetailedResponse getDetails(){
		//get all the departments
		List<EmployeeDetail> employeeDetails=new ArrayList<EmployeeDetail>();
		EmployeeDetail e1 = new EmployeeDetail(1, "Colean");
		EmployeeDetail e2 = new EmployeeDetail(2, "Richard");
		
		employeeDetails.add(e1);
		employeeDetails.add(e2);		
		//get list of employees working in each department	
		

		
		//put them together
		DetailedResponse detailedResponse=new DetailedResponse();		
		List<DepartmentDetail> departmentDetails = employeeDetails.stream()
				.map(depart -> 
				new DepartmentDetail(1, "HR", Collections.singletonList(new EmployeeDetail(1, "Colean"))))
				.collect(Collectors.toList());
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
