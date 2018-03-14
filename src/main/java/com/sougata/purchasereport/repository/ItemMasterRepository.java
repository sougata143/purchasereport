package com.sougata.purchasereport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sougata.purchasereport.entity.ItemMaster;


@Repository
public interface ItemMasterRepository extends JpaRepository<ItemMaster, String>{

	@Query("select  u from ItemMaster u where u.groupCode = :groupCode")
    List<ItemMaster> findByGroupCode(@Param("groupCode") String groupCode);
	
	@Query("select  u from ItemMaster u where u.itemCode = :itemCode")
    ItemMaster findByItemCode(@Param("itemCode") String itemCode);
	
	@Query("select  u from ItemMaster u where u.itemCode = :itemCode and u.groupCode = :groupCode")
    List<ItemMaster> findByItemCodeAndGroupCode(@Param("itemCode") String itemCode, @Param("groupCode") String groupCode);
	
}
