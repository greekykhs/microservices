package com.scrutiny.departempdetails.model;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDetail {
	private int departmentId;
	private String departmentName;	
	List<EmployeeDetail> employees=new ArrayList<>();
	
	public DepartmentDetail(int departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	public DepartmentDetail(int departmentId, String departmentName, List<EmployeeDetail> employees) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.employees = employees;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<EmployeeDetail> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmployeeDetail> employees) {
		this.employees = employees;
	}	
}
