package com.market.simplified.entity.model;

public class EmployeeReqest {
	
//	{
//		   "empNo":1043232,
//		   "empName": "saranya",
//		   "empemailid:"saran@gmail.com",
//		   "empDOB": 10/04/2012 -- date,
//		   "empAddress":"Thuraiyur"
//			}
	
	
	private String empName;
	
	private String empemailid;
	
    
	private String dob;
	
	private String empAddress;

	

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
