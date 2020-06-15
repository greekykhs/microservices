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
		return getHarcodedDetails();
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
