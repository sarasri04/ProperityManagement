package com.market.simplified.repositoryImpl;

//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.market.simplified.entity.model.request;
import com.market.simplified.repository.AttendanceRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import com.market.simplified.entity.AttendanceEntity;


@Repository
public class AttendanceRepositoryImpl {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	//hitting Database to get employee details
	public List<AttendanceEntity> getEmployeeInfo(List<request> req) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<AttendanceEntity> criteriaQuery = cb.createQuery(AttendanceEntity.class);
			Root<AttendanceEntity> root = criteriaQuery.from(AttendanceEntity.class);

			List<Predicate> finalPredicateList = new ArrayList<>();
			for(request re : req) {
				CriteriaBuilder internalCB = entityManager.getCriteriaBuilder();
				List<Predicate> predicates = new ArrayList<>();
				if(re.getResponsiblePersonId() != null) {
					predicates.add(internalCB.and(internalCB.like(root.get("responsiblePersonId"), "%"+re.getResponsiblePersonId()+"%" )));
				}
				SimpleDateFormat DATE_FORMAT1 = new SimpleDateFormat("dd/MM/yyyy");

				if(re.getcDate() != null) {
					try {
						//Date date = sdf.parse(re.getcDate()); //java.sql.Date 
						System.out.println(DATE_FORMAT1.parse(re.getcDate()));
						//System.out.println("to_timestamp('"+sdf.format(date)+"', 'dd/mm/yyyy')");//date_created = @0::timestamp", dateCreated.ToString("yyyy-MM-dd HH:00:00")
						//predicates.add(internalCB.and(internalCB.equal(root.get("cDate"), "to_timestamp('26/04/2023', 'dd/mm/yyyy')" )));
						predicates.add(internalCB.and(internalCB.equal(root.get("cDate"),  DATE_FORMAT1.parse(re.getcDate()))));

					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Predicate predicate = internalCB.and(predicates.toArray(new Predicate[predicates.size()]));
				finalPredicateList.add(predicate);
			}

			Predicate finalPredicate =  cb.or(finalPredicateList.toArray(new Predicate[finalPredicateList.size()]));
			criteriaQuery.where(finalPredicate);
			return entityManager.createQuery(criteriaQuery).getResultList();
		} finally {
			if(entityManager != null) {
				entityManager.close();
			}

		}		

	}


}





