package com.market.simplified.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.market.simplified.entity.Scheme;

@Repository
public interface CodingTestSchemeRepository extends JpaRepository<Scheme, Long> {

	@Query(value = "select * from schemes where scheme_name like ? ", nativeQuery = true)
	List<Scheme> findBySchemeName(String schemeName);

}
