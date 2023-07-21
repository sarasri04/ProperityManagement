package com.market.simplified.repositoryImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.simplified.entity.EmployeeEntity;

public interface EmployeeRepos extends JpaRepository<EmployeeEntity, Integer> {
	

}
