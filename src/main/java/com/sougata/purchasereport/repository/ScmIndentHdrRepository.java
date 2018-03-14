package com.sougata.purchasereport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sougata.purchasereport.entity.ScmIndentHdr;

@Repository
public interface ScmIndentHdrRepository extends JpaRepository<ScmIndentHdr, String> {

	@Query("select COUNT(u.id) FROM ScmIndentHdr u WHERE u.indentType = :indentType")
	int findAllCountByIndentType(@Param("indentType") String indentType);
	
	@Query("select COUNT(u.id) FROM ScmIndentHdr u WHERE u.indentType = :indentType and u.indentStatus = '3'")
	int findAllCountByIndentTypeAndIndentStatus3(@Param("indentType") String indentType);
	
	@Query("select COUNT(u.id) FROM ScmIndentHdr u WHERE u.indentType = :indentType and u.indentStatus = '4'")
	int findAllCountByIndentTypeAndIndentStatus4(@Param("indentType") String indentType);
	
	@Query("select u.id FROM ScmIndentHdr u WHERE u.indentType = :indentType")
	List<ScmIndentHdr> findAllByIndentType(@Param("indentType") String indentType);
	
	@Query("select u.id FROM ScmIndentHdr u WHERE u.indentType = :indentType and u.indentStatus = 3")
	List<ScmIndentHdr> findAllByIndentTypeAndIndentStatus3(@Param("indentType") String indentType);
	
	@Query("select u.id FROM ScmIndentHdr u WHERE u.indentType = :indentType and u.indentStatus = 4")
	List<ScmIndentHdr> findAllByIndentTypeAndIndentStatus4(@Param("indentType") String indentType);
	
}
