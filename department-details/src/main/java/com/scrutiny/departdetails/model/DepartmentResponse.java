package com.scrutiny.departdetails.model;

import java.util.ArrayList;
import java.util.List;

public class DepartmentResponse {
	List<DepartmentDetail> departmentDetails=new ArrayList<DepartmentDetail>();
	public DepartmentResponse() {}
	public List<DepartmentDetail> getDepartmentDetails() {
		return departmentDetails;
	}
	public void setDepartmentDetails(List<DepartmentDetail> departmentDetails) {
		this.departmentDetails = departmentDetails;
	}	
}
