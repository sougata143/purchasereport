package com.sougata.purchasereport.component;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sougata.purchasereport.entity.ScmIndentHdr;
import com.sougata.purchasereport.repository.ScmIndentHdrRepository;

@Component
public class ScmIndentHdrDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScmIndentHdrDao.class);
    @Autowired
    DataSource dataSource;
    
    @Autowired
    ScmIndentHdrRepository scmindenthdrRepository;
    
    @Transactional
    public List<ScmIndentHdr> findAll(){
    	LOGGER.info("DATASOURCE = " + dataSource);
    	List<ScmIndentHdr> scmindentHdrEntityList = new ArrayList<ScmIndentHdr>();
    	for(ScmIndentHdr scmindenthdrEntity : scmindenthdrRepository.findAll()) {
    		scmindentHdrEntityList.add(scmindenthdrEntity);
    	}
    	return scmindentHdrEntityList;
    }
    
    @Transactional
    public int findAllByIndentTypeCount(String indentType){
    	LOGGER.info("DATASOURCE = " + dataSource);
    	return scmindenthdrRepository.findAllCountByIndentType(indentType);
    }
    
    @Transactional
    public int findAllByIndentTypeAndIndentStatusCount3(String indentType){
    	LOGGER.info("DATASOURCE = " + dataSource);
    	return scmindenthdrRepository.findAllCountByIndentTypeAndIndentStatus3(indentType);
    }
    
    @Transactional
    public int findAllByIndentTypeAndIndentStatusCount4(String indentType){
    	LOGGER.info("DATASOURCE = " + dataSource);
    	return scmindenthdrRepository.findAllCountByIndentTypeAndIndentStatus4(indentType);
    }
    
    /*find by indent type*/
    @Transactional
    public List<ScmIndentHdr> findAllByIndentType(String indentType){
    	LOGGER.info("DATASOURCE = " + dataSource);
    	List<ScmIndentHdr> scmindentHdrEntityList = new ArrayList<ScmIndentHdr>();
    	for(ScmIndentHdr scmindenthdrEntity : scmindenthdrRepository.findAllByIndentType(indentType)) {
    		scmindentHdrEntityList.add(scmindenthdrEntity);
    	}
    	return scmindentHdrEntityList;
    }
    
    
    /*find by indent type with indent status 3*/
    @Transactional
    public List<ScmIndentHdr> findAllByIndentTypeIndentStatus3(String indentType){
    	LOGGER.info("DATASOURCE = " + dataSource);
    	return scmindenthdrRepository.findAllByIndentTypeAndIndentStatus3(indentType);
    }
    
    
    /*find by indent type with indent status 4*/
    @Transactional
    public List<ScmIndentHdr> findAllByIndentTypeIndentStatus4(String indentType){
    	LOGGER.info("DATASOURCE = " + dataSource);
    	return scmindenthdrRepository.findAllByIndentTypeAndIndentStatus4(indentType);
    }

}
