package com.sougata.purchasereport.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sougata.purchasereport.entity.ScmIndentLineItem;
import com.sougata.purchasereport.repository.customrepository.ScmIndentLineItemCustomRepository;

@Repository
public interface ScmIndentLineItemRepository extends JpaRepository<ScmIndentLineItem, String>, ScmIndentLineItemCustomRepository {

    Optional<ScmIndentLineItem> findById(String i);

   // List<Activity> findByUserName(String userName);
    
    

     //custom query example and return a stream
  //  @Query("select  u from AxialFan u where u.id = :productGrp and u.flow between :minflow and :maxflow")
    @Query("select  u from ScmIndentLineItem u where u.itemCode = :itemCode")
    List<ScmIndentLineItem> findByScmIndentLineItemReturnStream(@Param("itemCode") String itemCode);
    
    
    @Query("select  u from ScmIndentLineItem u where u.groupCode = :groupCode")
    List<ScmIndentLineItem> findByScmIndentLineItembyGroupCodeReturnStream(@Param("groupCode") String groupCode);
    
    
    @Query("select  u from ScmIndentLineItem u where u.indentNo = :indentNo")
    List<ScmIndentLineItem> findByScmIndentLineItembyIndentNoReturnStream(@Param("indentNo") String indentNo);
    
    
    @Query("select  u from ScmIndentLineItem u where u.deptCode = :deptCode")
    List<ScmIndentLineItem> findByScmIndentLineItembydeptCodeReturnStream(@Param("deptCode") String deptCode);
    
    
    
    
   // @Query("select  u from ScmIndentHdr u where u.itemCode = :itemCode")
   // List<ScmIndentHdr> findByScmIndentItemCodeReturnStream(@Param("itemCode") String itemCode);
    
  //  @Query("select  u from AxialFan u where u.flow >= 180 and u.flow <= 220 and u.id = :productGrp")
   // @Query("select  distinct u from AxialFan u where u.id = :productGrp order by id")
    //List<AxialFan> findByproductGrpReturnStream(@Param("productGrp") String productGrp);

    
    
}
