package com.sougata.purchasereport.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sougata.purchasereport.entity.ScmPoLineItemHist;

public interface ScmPoLineItemHistRepository extends CrudRepository<ScmPoLineItemHist, Long> {

	@Query("select  u from ScmPoLineItemHist u where u.poNum = :poNum")
    ScmPoLineItemHist findByPoNumReturnStream(@Param("poNum") String ponum);
	
}
