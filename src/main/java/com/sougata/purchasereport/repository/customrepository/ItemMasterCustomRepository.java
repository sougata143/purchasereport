package com.sougata.purchasereport.repository.customrepository;

import java.util.List;

import com.sougata.purchasereport.entity.ItemMaster;



public interface ItemMasterCustomRepository {

	List<ItemMaster>getAllItem();
	ItemMaster findByGroupCode(String id);
	
}
