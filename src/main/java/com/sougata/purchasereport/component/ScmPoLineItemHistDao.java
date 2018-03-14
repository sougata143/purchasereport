package com.sougata.purchasereport.component;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sougata.purchasereport.entity.ScmPoLineItemHist;
import com.sougata.purchasereport.repository.ScmPoLineItemHistRepository;

@Component
public class ScmPoLineItemHistDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScmPoLineItemHistDao.class);
    @Autowired
    DataSource dataSource;
    
    @Autowired
    ScmPoLineItemHistRepository scmpolineitemhistRepository;
    
    @Transactional
    public List<ScmPoLineItemHist> findAll() throws Exception{
    	LOGGER.info("DATASOURCE = " + dataSource);
    	List<ScmPoLineItemHist> scmpolineitemhistEntityList = new ArrayList<ScmPoLineItemHist>();
    	for(ScmPoLineItemHist scmpolineitemhist : scmpolineitemhistRepository.findAll() ) {
    		scmpolineitemhistEntityList.add(scmpolineitemhist);
    	}
    	
    	return scmpolineitemhistEntityList;
    }
    
    @Transactional
    public ScmPoLineItemHist findByPoNum(String ponum){
    	LOGGER.info("DATASOURCE = " + dataSource);
    	/*List<ScmPoLineItemHist> scmpolineitemhistEntityList = new ArrayList<ScmPoLineItemHist>();
    	
    	for(ScmPoLineItemHist scmpolineitemhist : scmpolineitemhistRepository.findByPoNumReturnStream(ponum)) {
    		scmpolineitemhistEntityList.add(scmpolineitemhist);
    	}*/
    	
    	return scmpolineitemhistRepository.findByPoNumReturnStream(ponum);
    	
    }
    

}
