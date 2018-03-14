package com.sougata.purchasereport.component;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sougata.purchasereport.entity.ScmPoLineItem;
import com.sougata.purchasereport.repository.ScmPoLineItemRepository;



@Component
public class ScmPoLineItemDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScmPoLineItemDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    ScmPoLineItemRepository scmPoLineItemRepository;

    @Transactional(readOnly = true)
    public List<ScmPoLineItem> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<ScmPoLineItem> scmindenthdrList = new ArrayList<ScmPoLineItem>();
	for (ScmPoLineItem scmindenthdr : scmPoLineItemRepository.findAll()) {
		scmindenthdrList.add(scmindenthdr);

	}
	return scmindenthdrList;

    }

    @Transactional
	public List<ScmPoLineItem> findByPoNumReturnStream(String ponum) {
    	LOGGER.info("DATASOURCE = " + dataSource);
    	List<ScmPoLineItem> scmindenthdrList = new ArrayList<ScmPoLineItem>();
    	for(ScmPoLineItem scmpolineitem : scmPoLineItemRepository.findByScmLineItemByPoNumReturnStream(ponum)){
    		 scmindenthdrList.add(scmpolineitem);
    	}
		
		return scmindenthdrList;
	}
    

    @Transactional
    public List<ScmPoLineItem> findByIndentNoReturnStream(String indentno){
    	LOGGER.info("DATASOURCE = " + dataSource);
    	List<ScmPoLineItem> scmpolineitemhdrList = new ArrayList<>();
    	for(ScmPoLineItem scmpolineitem : scmPoLineItemRepository.findByScmIndentItemCodeReturnStream(indentno)){
    		scmpolineitemhdrList.add(scmpolineitem);
   	}
    	return scmpolineitemhdrList;
    }
    
    @Transactional
    public List<ScmPoLineItem> findByPoNumAndIndentNoReturnStream(String ponum, String indentno){
    	LOGGER.info("DATASOURCE = " + dataSource);
    	List<ScmPoLineItem> scmpolineitemhdrList = new ArrayList<>();
    	for(ScmPoLineItem scmpolineitem : scmPoLineItemRepository.findByPoNumAndIndentNoReturnStream(ponum, indentno)){
    		scmpolineitemhdrList.add(scmpolineitem);
   	}
    	return scmpolineitemhdrList;
    }
    
   
}
