package com.sougata.purchasereport.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sougata.purchasereport.entity.ScmPoHdr;
import com.sougata.purchasereport.repository.customrepository.ScmPoHdrCustomRepository;

@Repository
public interface ScmPoHdrRepository extends JpaRepository<ScmPoHdr, String>, ScmPoHdrCustomRepository {

    Optional<ScmPoHdr> findById(String i);

    @Query("select  u from ScmPoHdr u where u.id = :ponum ")
    List<ScmPoHdr> findByPoNumReturnStream(@Param("ponum") String ponum);
  
    List<ScmPoHdr> findByPoType(@Param("poType") String poType);
    
    List<ScmPoHdr> findByIdAndPoType(@Param("id") String id, @Param("poType") String poType);
    
    @Query("select  u from ScmPoHdr u where u.id = :ponum and u.poDate between :startDate and :endDate")
    List<ScmPoHdr> findByPoNumAndDateReturnStream(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("ponum") String ponum);
    
    @Query("select  u from ScmPoHdr u where u.poType = :poType and u.poDate between :startDate and :endDate")
    List<ScmPoHdr> findByPoTypeAndDateReturnStream(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("poType") String poType);
    
    @Query("select  u from ScmPoHdr u where u.id = :ponum and u.poType = :poType and u.poDate between :startDate and :endDate")
    List<ScmPoHdr> findByPoNumAndPoTypeAndDateReturnStream(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("ponum") String ponum, @Param("poType") String poType);
    
//    @Query("select  u from ScmPoHdr u where u.poDate >= :startDate and u.poDate <= :endDate")
//    List<ScmPoHdr> findByDateReturnStream(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
//    @Query("select  u from ScmPoHdr u where u.poDate >= :startDate ")
//    List<ScmPoHdr> findByDateReturnStream(@Param("startDate") Date startDate);
    
    @Query("select  u from ScmPoHdr u where u.poDate >= :startDate and u.poDate <= :endDate")
    List<ScmPoHdr> findByDateReturnStream(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
//    @Query("select u from ScmPoHdr u where u.suppCode = :suppCode")
//    List<ScmPoHdr> findBySuppCodeReturnStream(@Param("suppCode") String suppCode);
    
    List<ScmPoHdr> findBySuppCode(@Param("suppCode") String suppCode);
    
//    @Query("select u from ScmPoHdr u where u.suppName = :suppName")
//    List<ScmPoHdr> findBySuppNameReturnStream(@Param("suppName") String suppName);
//    
//    @Query("select u from ScmPoHdr u where u.suppCode = :suppCode and u.suppName = :suppName")
//    List<ScmPoHdr> findBySuppCodeAndSuppNameReturnStream(@Param("suppCode") String suppCode, @Param("suppName") String suppName);
    
    @Query("select u from ScmPoHdr u where u.suppCode = :suppCode and u.poDate >= :startDate and u.poDate <= :endDate")
    List<ScmPoHdr> findBySuppCodeAndDateReturnStream(@Param("suppCode") String suppCode, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
//    @Query("select u from ScmPoHdr u where u.suppCode = :suppCode and u.suppName = :suppName and u.poDate >= :startDate and u.poDate <= :endDate")
//    List<ScmPoHdr> findBySuppCodeAndSuppNameAndDateReturnStream(@Param("suppCode") String suppCode, @Param("suppName") String suppName, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
//    @Query("select u from ScmPoHdr u where u.suppName = :suppName and u.poDate >= :startDate and u.poDate <= :endDate")
//    List<ScmPoHdr> findBySuppNameAndDateReturnStream(@Param("suppName") String suppName, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
//    @Query("select u from ScmPoHdr u where u.poStatus = '4'")
//    List<ScmPoHdr> findByPoStatusReturnStream();
    
    List<ScmPoHdr> findByPoStatus(@Param("poStatus") String poStatus);
    
    @Query("select u from ScmPoHdr u where u.poStatus = :poStatus and u.poDate >= :startDate and u.poDate <= :endDate")
    List<ScmPoHdr> findByPoStatusAndDateReturnStream(@Param("poStatus") String poStatus, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
    
}
