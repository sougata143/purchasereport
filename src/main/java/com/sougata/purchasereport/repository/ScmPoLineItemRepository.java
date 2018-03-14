package com.sougata.purchasereport.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sougata.purchasereport.entity.ScmPoLineItem;
import com.sougata.purchasereport.repository.customrepository.ScmPoLineItemCustomRepository;

@Repository
public interface ScmPoLineItemRepository extends JpaRepository<ScmPoLineItem, Long>, ScmPoLineItemCustomRepository {

    Optional<ScmPoLineItem> findById(Long i);

    @Query("select  u from ScmPoLineItem u where u.poNum = :poNum")
    List<ScmPoLineItem> findByScmLineItemByPoNumReturnStream(@Param("poNum") String poNum);
    
    @Query("select  u from ScmPoLineItem u where u.poNum = :poNum")
    ScmPoLineItem findByScmLineItemByPoNumReturnStream1(@Param("poNum") String poNum);
   
    @Query("select  u from ScmPoLineItem u where u.indentNo = :indentNo")
    List<ScmPoLineItem> findByScmIndentItemCodeReturnStream(@Param("indentNo") String indentNo);
    
    @Query("select  u from ScmPoLineItem u where u.poNum = :poNum and u.indentNo = :indentNo")
    List<ScmPoLineItem> findByPoNumAndIndentNoReturnStream(@Param("poNum") String poNum, @Param("indentNo") String indentNo);
    
    
  
}
