package com.market.simplified.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.market.simplified.entity.AttendanceEntity;


public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long>{
//	@Query(value="Select UNDER_EMPLOYEE_NAME from ATTENDANCE_ENTRY where COOKING_CENTER_NAME like ?", nativeQuery=true)
//	List<AttendanceEntity> getByCookingCenter(String a);
	
	@Query(value="Select entity from AttendanceEntity entity where entity.responsiblePersonId = ?1 AND entity.cDate = to_timestamp( ?2 , 'dd/mm/yyyy')") //nativeQuery=true)
	List<AttendanceEntity> getEmployeeDetails(String empId, String date);

}
