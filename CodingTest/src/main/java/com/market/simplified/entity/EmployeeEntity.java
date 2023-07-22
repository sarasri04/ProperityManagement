package com.market.simplified.entity;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="employee")
@Setter
@Getter


public class EmployeeEntity {
	@Id
	@GeneratedValue
	@Column(name="EMPID")
	private Integer empId;
	
	@Column(name="EMPNAME")
	private String empName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="EMP_EMAIL_ID")
	private String empemailid;
	
	@Column(name="EMP_ADDRESS")
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmpemailid() {
		return empemailid;
	}

	public void setEmpemailid(String empemailid) {
		this.empemailid = empemailid;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
	
	
	 

}
