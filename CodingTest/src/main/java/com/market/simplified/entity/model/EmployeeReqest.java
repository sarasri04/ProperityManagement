package com.market.simplified.entity.model;

public class EmployeeReqest {
	
//	{
//		   "empNo":1043232,
//		   "empName": "saranya",
//		   "empemailid:"saran@gmail.com",
//		   "empDOB": 10/04/2012 -- date,
//		   "empAddress":"Thuraiyur"
//			}
	private Integer empId;
	
	private String empName;
	
	private String empemailid;
	
    
	private String dob;
	
	private String empAddress;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpemailid() {
		return empemailid;
	}

	public void setEmpemailid(String empemailid) {
		this.empemailid = empemailid;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
	

}
