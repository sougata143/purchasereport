package com.sougata.purchasereport.component;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sougata.purchasereport.entity.ScmIndentLineItem;
import com.sougata.purchasereport.repository.ScmIndentLineItemRepository;


@Component
public class ScmIndentLineItemDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScmIndentLineItemDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    ScmIndentLineItemRepository scmindentlineRepository;

    @Transactional(readOnly = true)
    public List<ScmIndentLineItem> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<ScmIndentLineItem> scmindenthdrList = new ArrayList<ScmIndentLineItem>();
	for (ScmIndentLineItem scmindenthdr : scmindentlineRepository.findAll()) {
		scmindenthdrList.add(scmindenthdr);

	}
	return scmindenthdrList;

    }
    
    
    
    @Transactional(readOnly = true)
    public List<ScmIndentLineItem> findByScmIndentLineItembydeptCode(String deptCode) throws Exception{
   
	List<ScmIndentLineItem> scmindentlineLt = new ArrayList<ScmIndentLineItem>();
	
	for (ScmIndentLineItem scmline : scmindentlineRepository.findByScmIndentLineItembydeptCodeReturnStream(deptCode)) {
		scmindentlineLt.add(scmline);
		
	}
	
	
	return scmindentlineLt;
	
    }
    
    
    
    @Transactional(readOnly = true)
    public List<ScmIndentLineItem> findByScmIndentLineItem(String itemCode) throws Exception{
   
	
	List<ScmIndentLineItem> scmindentlineLt = new ArrayList<ScmIndentLineItem>();
	
	for (ScmIndentLineItem scmline : scmindentlineRepository.findByScmIndentLineItemReturnStream(itemCode)) {
		scmindentlineLt.add(scmline);
		
	}
	
	
	return scmindentlineLt;
	
    }
    
    @Transactional(readOnly = true)
    public List<ScmIndentLineItem> findByScmIndentLineItembyIndentNo(String indentNo) throws Exception{
   
	List<ScmIndentLineItem> scmindentlineLt = new ArrayList<ScmIndentLineItem>();
	
	for (ScmIndentLineItem scmline : scmindentlineRepository.findByScmIndentLineItembyIndentNoReturnStream(indentNo)) {
		scmindentlineLt.add(scmline);
		
	}
	
	return scmindentlineLt;
	
    }
    
    
    @Transactional(readOnly = true)
    public List<ScmIndentLineItem> findByScmIndentLineItembyGroupCode(String groupcode) throws Exception{
   
	List<ScmIndentLineItem> scmindentlineLt = new ArrayList<ScmIndentLineItem>();
	
	for (ScmIndentLineItem scmline : scmindentlineRepository.findByScmIndentLineItembyGroupCodeReturnStream(groupcode)) {
		scmindentlineLt.add(scmline);
		
	}
	
	
	return scmindentlineLt;
	
    }

    
}
