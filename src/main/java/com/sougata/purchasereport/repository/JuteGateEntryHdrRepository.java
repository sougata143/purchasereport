package com.sougata.purchasereport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sougata.purchasereport.entity.JuteGateEntryHdr;

@Repository
public interface JuteGateEntryHdrRepository extends JpaRepository<JuteGateEntryHdr, String>{
	
//	@Query("select  u from JuteGateEntryHdr u where u.pono = :pono")
//    List<JuteGateEntryHdr> findByPoNoReturnStream(@Param("pono") String pono);

	@Query("select  u from JuteGateEntryHdr u where u.pono = :pono")
	JuteGateEntryHdr findByPoNoReturnStream(@Param("pono") String pono);

}
