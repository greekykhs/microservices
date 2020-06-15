package com.scrutiny.departdetails.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.scrutiny.departdetails.model.DepartmentDetail;
import com.scrutiny.departdetails.model.DepartmentResponse;

@RestController
@RequestMapping("/department")
public class DeptResource {
	@RequestMapping("/getDepartmentDetails")
	public DepartmentResponse getDetails(){
		return getDepartments();
	}	
	public DepartmentResponse getDepartments() {
		DepartmentDetail dd1 = new DepartmentDetail(1, "HR");
		DepartmentDetail dd2 = new DepartmentDetail(2, "Marketing");
		
		DepartmentResponse departmentResponse=new DepartmentResponse();
		departmentResponse.getDepartmentDetails().add(dd1);
		departmentResponse.getDepartmentDetails().add(dd2);
		return departmentResponse;
	}
}
