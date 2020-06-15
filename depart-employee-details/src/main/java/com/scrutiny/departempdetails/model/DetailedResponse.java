package com.scrutiny.departempdetails.model;

import java.util.ArrayList;
import java.util.List;

public class DetailedResponse {
	List<DepartmentDetail> departmentDetails=new ArrayList<DepartmentDetail>();
	public List<DepartmentDetail> getDepartmentDetails() {
		return departmentDetails;
	}
	public void setDepartmentDetails(List<DepartmentDetail> departmentDetails) {
		this.departmentDetails = departmentDetails;
	}	
}
