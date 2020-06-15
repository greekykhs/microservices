package com.scrutiny.departempdetails.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeResponse {
	private int departmentId;
	List<EmployeeDetail> employeeDetails=new ArrayList<EmployeeDetail>();	
	
	public EmployeeResponse() {}
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public List<EmployeeDetail> getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(List<EmployeeDetail> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}	
}
