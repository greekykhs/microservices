package com.scrutiny.departempdetails.model;

public class EmployeeDetail {
	private int employeeId;
	private String employeeName;
	
	public EmployeeDetail() {}
	public EmployeeDetail(int employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}	
}
