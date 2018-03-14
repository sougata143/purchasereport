package com.sougata.purchasereport.component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sougata.purchasereport.entity.ScmPoHdr;
import com.sougata.purchasereport.repository.ScmPoHdrRepository;

@Component
public class ScmPoHdrDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScmPoHdrDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    ScmPoHdrRepository scmpohdrRepository;

    @Transactional(readOnly = true)
    public List<ScmPoHdr> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<ScmPoHdr> scmpohdrList = new ArrayList<ScmPoHdr>();
	for (ScmPoHdr scmpohdr : scmpohdrRepository.findAll()) {
		scmpohdrList.add(scmpohdr);

	}
	return scmpohdrList;

    }
    
    
    @Transactional(readOnly = true)
    public List<ScmPoHdr> findByPoNumReturnStream(String ponum) throws Exception{
   
		List<ScmPoHdr> scmpohdrLt = new ArrayList<ScmPoHdr>();
		for (ScmPoHdr scmhdr : scmpohdrRepository.findByPoNumReturnStream(ponum)) {
			scmpohdrLt.add(scmhdr);
		}
	
	return scmpohdrLt;
	
    }
    
    @Transactional(readOnly=true)
    public List<ScmPoHdr> findByPoTypeReturnStream(String poType) throws Exception{
    	List<ScmPoHdr> scmpohdrLt = new ArrayList<ScmPoHdr>();
    	for (ScmPoHdr scmhdr : scmpohdrRepository.findByPoType(poType)){
    		scmpohdrLt.add(scmhdr);
    	}
    		
    	return scmpohdrLt;
    }

    @Transactional(readOnly = true)
    public List<ScmPoHdr> findByScmPoNumAndPoTypeHdr(String id,String poType) throws Exception{
   
	List<ScmPoHdr> scmpohdrLt = new ArrayList<ScmPoHdr>();
	
	for (ScmPoHdr scmhdr : scmpohdrRepository.findByIdAndPoType(id,poType)) {
		scmpohdrLt.add(scmhdr);
		
	}
	
	return scmpohdrLt;
	
    }

    
    @Transactional(readOnly = true)
    public List<ScmPoHdr> findByScmPoNumAndDateHdr(Date startDate, Date enddate, String id) throws Exception{
   
	List<ScmPoHdr> scmpohdrLt = new ArrayList<ScmPoHdr>();
	
	for (ScmPoHdr scmhdr : scmpohdrRepository.findByPoNumAndDateReturnStream(startDate, enddate, id)) {
		scmpohdrLt.add(scmhdr);
		
	}
	
	return scmpohdrLt;
	
    }
    
    @Transactional(readOnly = true)
    public List<ScmPoHdr> findByScmPoTypeAndDateHdr(Date startDate, Date enddate, String poType) throws Exception{
   
	List<ScmPoHdr> scmpohdrLt = new ArrayList<ScmPoHdr>();
	
	for (ScmPoHdr scmhdr : scmpohdrRepository.findByPoTypeAndDateReturnStream(startDate, enddate, poType)) {
		scmpohdrLt.add(scmhdr);
		
	}
	
	return scmpohdrLt;
	
    }
    
    @Transactional(readOnly = true)
    public List<ScmPoHdr> findByScmPoNumAndPoTypeAndDateHdr(Date startDate, Date enddate,String ponum, String poType) throws Exception{
   
	List<ScmPoHdr> scmpohdrLt = new ArrayList<ScmPoHdr>();
	
	for (ScmPoHdr scmhdr : scmpohdrRepository.findByPoNumAndPoTypeAndDateReturnStream(startDate, enddate, ponum, poType)) {
		scmpohdrLt.add(scmhdr);
		
	}
	
	return scmpohdrLt;
	
    }
    
    @Transactional(readOnly = true)
    public List<ScmPoHdr> findByDateHdr(Date startDate, Date enddate) throws Exception{
   
	List<ScmPoHdr> scmpohdrLt = new ArrayList<ScmPoHdr>();
	for (ScmPoHdr scmhdr : scmpohdrRepository.findByDateReturnStream(startDate, enddate)) {
		System.out.println("in dao "+scmhdr.getPoDate());
		scmpohdrLt.add(scmhdr);
	}
    	
	
	return scmpohdrLt;
	
    }
    
    @Transactional(readOnly = true)
    public List<ScmPoHdr> findBySuppCode(String suppCode) throws Exception{
    	List<ScmPoHdr> scmpohdrList = new ArrayList<ScmPoHdr>();
    	for(ScmPoHdr scmpohdr : scmpohdrRepository.findBySuppCode(suppCode)) {
    		scmpohdrList.add(scmpohdr);
    	}
    	
    	return scmpohdrList;
    }
    
    
    
    @Transactional(readOnly = true)
    public List<ScmPoHdr> findBySuppCodeAndDate(String suppCode,Date startDate, Date endDate) throws Exception{
    	List<ScmPoHdr> scmpohdrList = new ArrayList<ScmPoHdr>();
    	for(ScmPoHdr scmpohdr : scmpohdrRepository.findBySuppCodeAndDateReturnStream(suppCode, startDate, endDate)) {
    		scmpohdrList.add(scmpohdr);
    	}
    	
    	return scmpohdrList;
    }
    
    @Transactional(readOnly=true)
    public List<ScmPoHdr> findByPoStatus(String poStatus) throws Exception{
    	List<ScmPoHdr> scmpohdrList = new ArrayList<ScmPoHdr>();
    	for(ScmPoHdr scpohdr : scmpohdrRepository.findByPoStatus(poStatus)) {
    		scmpohdrList.add(scpohdr);
    	}
    	
    	return scmpohdrList;
    }
    
    @Transactional(readOnly=true)
    public List<ScmPoHdr> findByPoStatusAndDate(String poStatus, Date startDate, Date endDate) throws Exception{
    	List<ScmPoHdr> scmpohdrList = new ArrayList<ScmPoHdr>();
    	for(ScmPoHdr scpohdr : scmpohdrRepository.findByPoStatusAndDateReturnStream(poStatus,startDate, endDate)) {
    		scmpohdrList.add(scpohdr);
    	}
    	
    	return scmpohdrList;
    }

    
}
