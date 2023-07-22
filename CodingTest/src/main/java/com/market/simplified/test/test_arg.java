package com.market.simplified.test;

import java.util.Date;
import java.util.Locale;

public class test_arg {

	public static void main(String[] args) {

		//DateFormat outputFormat = new SimpleDateFormat("MM/yyyy", Locale.US);
		//DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.US);
		
		//DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		String inputText = "2012-11-17T00:00:00.000-05:00";
		Date date = inputFormat.parse(inputText);
		String outputText = outputFormat.format(date);
	}
//	
//	package com.market.simplified.Dao;
//
//	import java.text.ParseException;
//	import java.text.SimpleDateFormat;
//	import java.util.ArrayList;
//	import java.util.Date;
//	import java.util.List;
//
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.stereotype.Repository;
//
//	import com.market.simplified.entity.model.Attendance;
//	import com.market.simplified.entity.model.request;
//	import com.market.simplified.repository.AttendanceRepository;
//
//	import jakarta.persistence.EntityManager;
//	import jakarta.persistence.EntityManagerFactory;
//	import jakarta.persistence.Persistence;
//	import jakarta.persistence.Query;
//	import jakarta.persistence.criteria.CriteriaBuilder;
//	import jakarta.persistence.criteria.CriteriaQuery;
//	import jakarta.persistence.criteria.Predicate;
//	import jakarta.persistence.criteria.Root;
//
//	import com.market.simplified.entity.AttendanceEntity;
//
//
//
//
//
//	@Repository
//	public class AttendanceDao {
//		@Autowired
//		AttendanceRepository ar;
//		
//		@Autowired
//		EntityManagerFactory entityManagerFactory;
//
//		public String saveAteendance(List<request> req) {
//
//			List<AttendanceEntity> attendanceEntityList = new ArrayList<>();
//			
//			List<AttendanceEntity> attendanceEntityResult = getEmployeeInfo(req);
//			
//			System.out.println(attendanceEntityResult.toString());
//			
//			for(AttendanceEntity res : attendanceEntityResult) {
//				System.out.println(res.getcDate());
//				System.out.println(res.getUnderEmpId());
//			}
//			
//			for(request aa : req) {
//				
//				Date date = null;
//				try {
//					date = new SimpleDateFormat("dd/MM/yyyy").parse(aa.getcDate());
//				} catch (ParseException e) {
//
//					e.printStackTrace();
//				}
//				
//			//	String temp_empId = null;
//				//ar.getEmployeeDetails(aa.getResponsiblePersonId(), date);
//				
////				if(temp_empId.equalsIgnoreCase(aa.getResponsiblePersonId())) {
////					
////				}
////				
//				AttendanceEntity temp = new AttendanceEntity();
//				temp.setResponsiblePersonId(aa.getResponsiblePersonId());
//				temp.setResponsiblePersonName(aa.getResponsiblePersonName());
//				temp.setResponsiblePersonMob(aa.getResponsiblePersonMob());
//				temp.setCookingCenterId(aa.getCookingCenterId());
//				temp.setCookingCenterName(aa.getCookingCenterName());
//				temp.setUnderEmployeeName(aa.getUnderEmployeeName());
//				temp.setUnderEmpId(aa.getUnderEmpId());
//				
//				temp.setUnderEmpMob(aa.getUnderEmpMob());
//				temp.setcDate(date);
//				temp.setStatus(aa.getStatus());
//				temp.setAdminId(aa.getAdminId());
//				temp.setAdminName(aa.getAdminName());
//
//				attendanceEntityList.add(temp);
//
//			}
//	for(AttendanceEntity aaa : attendanceEntityList) {
//		System.out.println(aaa.getResponsiblePersonId());
//		System.out.println(aaa.getResponsiblePersonName());
//		
//	}
//		     ar.saveAll(attendanceEntityList);
//			return "Attendance List Saved";
//		}
//
//		private List<AttendanceEntity> getEmployeeInfo(List<request> req) {
//			
//			List<AttendanceEntity> attendanceEntityList = new ArrayList<>();
//			
//			
//			EntityManager entityManager = entityManagerFactory.createEntityManager();
//			try {
//				CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//				CriteriaQuery<AttendanceEntity> criteriaQuery = cb.createQuery(AttendanceEntity.class);
//				Root<AttendanceEntity> root = criteriaQuery.from(AttendanceEntity.class);
//				
//				List<Predicate> finalPredicateList = new ArrayList<>();
//				for(request re : req) {
//					CriteriaBuilder internalCB = entityManager.getCriteriaBuilder();
//					List<Predicate> predicates = new ArrayList<>();
//					if(re.getResponsiblePersonId() != null) {
//						predicates.add(internalCB.and(internalCB.like(root.get("responsiblePersonId"), "%"+re.getResponsiblePersonId()+"%" )));
//					}
////					if(re.getcDate() != null) {
////						Date date =null;
////						try {
////						   date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(re.getcDate());
////						} catch (ParseException e) {
//	//
////							e.printStackTrace();
////						}
////						predicates.add(internalCB.and(internalCB.like(root.get("cDate"), "%"+date+"%" )));
////					}
//					Predicate predicate = internalCB.and(predicates.toArray(new Predicate[predicates.size()]));
//					finalPredicateList.add(predicate);
//				}
//				
//				Predicate finalPredicate =  cb.or(finalPredicateList.toArray(new Predicate[finalPredicateList.size()]));
//				criteriaQuery.where(finalPredicate);
//				System.out.println("==========>");
//				return entityManager.createQuery(criteriaQuery).getResultList();
//				
//				//attendanceEntityList =  entityManager.createQuery(criteriaQuery).getResultList();
//			} finally {
//				if(entityManager != null) {
//					entityManager.close();
//				}
//				
//			}
//			
//
//			
//			//return attendanceEntityList;
//			
//			
//		}
//	}
//
//
//



}
