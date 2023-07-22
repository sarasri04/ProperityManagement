package com.market.simplified.repositoryImpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.market.simplified.entity.UserloginEntity;

@Repository
public interface UserloginRepo extends JpaRepository<UserloginEntity, Long> {
	//SELECT * FROM userLogin where userName='SARNYA' AND password='sara123';
	@Query(value="SELECT * FROM userLogin where userName=? AND password=?",nativeQuery = true)
	public String getUser(String userName,String password);

	//public void save(EmployeeEntity num);

	//public void save(String mobileNumber, String emailId);

}
  