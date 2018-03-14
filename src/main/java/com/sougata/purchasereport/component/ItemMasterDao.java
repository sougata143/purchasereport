package com.sougata.purchasereport.component;

import java.util.ArrayList;
import java.util.List;

//import javax.activation.DataSource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sougata.purchasereport.entity.ItemMaster;
import com.sougata.purchasereport.repository.ItemMasterRepository;

@Component
public class ItemMasterDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemMasterDao.class);
	
	@Autowired
	javax.sql.DataSource DataSource; 
	
	@Autowired
	ItemMasterRepository itemmasterRepository;
	
	/*find by groupcode*/
	@Transactional
	public List<ItemMaster> findByGroupCodeReturnStream(String groupCode) {
    	LOGGER.info("DATASOURCE = " + DataSource);
    	List<ItemMaster> itemmasterList = new ArrayList<ItemMaster>();
    	for(ItemMaster scmpolineitem : itemmasterRepository.findByGroupCode(groupCode)){
    		itemmasterList.add(scmpolineitem);
    	}
		
		return itemmasterList;
	}
	
	/*find by itemcode and groupcode*/
	@Transactional
	public List<ItemMaster> findByItemCodeAndGroupCodeReturnStream(String id, String groupCode) {
    	LOGGER.info("DATASOURCE = " + DataSource);
    	List<ItemMaster> itemmasterList = new ArrayList<ItemMaster>();
    	for(ItemMaster scmpolineitem : itemmasterRepository.findByItemCodeAndGroupCode(id, groupCode)){
    		itemmasterList.add(scmpolineitem);
    	}
		
		return itemmasterList;
	}
	
	/*find by itemcode*/
	@Transactional
	public ItemMaster findByItemCodeReturnStream(String itemCode) {
    	LOGGER.info("DATASOURCE = " + DataSource);
		return itemmasterRepository.findByItemCode(itemCode);
	}

}
