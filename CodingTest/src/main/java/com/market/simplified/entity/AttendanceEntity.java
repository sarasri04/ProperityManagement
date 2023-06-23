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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="ATTENDANCE_ENTRY")
public class AttendanceEntity {
	
	@Id
	@GeneratedValue
	@Column(name="RN_", nullable = false)
	private Integer AttendanceID;

	@Column(name="RESPONSIBLE_PERSON_ID")
	private String responsiblePersonId;

	@Column(name="RESPONSIBLE_PERSON_NAME")
	private String responsiblePersonName;

	@Column(name="RESPONSIBLE_PERSON_MOB")
	private long responsiblePersonMob;

	@Column(name="COOKING_CENTER_ID")
	private String cookingCenterId;

	@Column(name="COOKING_CENTER_NAME")
	private String cookingCenterName;

	@Column(name="UNDER_EMPLOYEE_NAME")
	private String underEmployeeName;

	
	@Column(name="UNDER_EMP_ID")
	private String underEmpId;

	@Column(name="UNDER_EMP_MOB")
	private long underEmpMob;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CDATE")
	private Date cDate;

	@Column(name="STATUS")
	private String status;

	@Column(name="ADMIN_ID")
	private String adminId;

	@Column(name="ADMIN_NAME")
	private String adminName;

	public String getResponsiblePersonId() {
		return responsiblePersonId;
	}

	public void setResponsiblePersonId(String responsiblePersonId) {
		this.responsiblePersonId = responsiblePersonId;
	}

	public String getResponsiblePersonName() {
		return responsiblePersonName;
	}

	public void setResponsiblePersonName(String responsiblePersonName) {
		this.responsiblePersonName = responsiblePersonName;
	}

	public long getResponsiblePersonMob() {
		return responsiblePersonMob;
	}

	public void setResponsiblePersonMob(long responsiblePersonMob) {
		this.responsiblePersonMob = responsiblePersonMob;
	}

	public String getCookingCenterId() {
		return cookingCenterId;
	}

	public void setCookingCenterId(String cookingCenterId) {
		this.cookingCenterId = cookingCenterId;
	}

	public String getCookingCenterName() {
		return cookingCenterName;
	}

	public void setCookingCenterName(String cookingCenterName) {
		this.cookingCenterName = cookingCenterName;
	}

	public String getUnderEmployeeName() {
		return underEmployeeName;
	}

	public void setUnderEmployeeName(String underEmployeeName) {
		this.underEmployeeName = underEmployeeName;
	}

	public String getUnderEmpId() {
		return underEmpId;
	}

	public void setUnderEmpId(String underEmpId) {
		this.underEmpId = underEmpId;
	}

	public long getUnderEmpMob() {
		return underEmpMob;
	}

	public void setUnderEmpMob(long underEmpMob) {
		this.underEmpMob = underEmpMob;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	


}
