package com.sougata.purchasereport.component;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sougata.purchasereport.entity.JuteGateEntryHdr;
import com.sougata.purchasereport.repository.JuteGateEntryHdrRepository;

@Component
public class JuteGateEntryHdrDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(JuteGateEntryHdrDao.class);
    @Autowired
    DataSource dataSource;
    
    @Autowired
    JuteGateEntryHdrRepository jutegateentryhdrRepository;
    
//    @Transactional(readOnly = true)
//    public List<JuteGateEntryHdr> findByPoNumReturnStream(String pono) throws Exception{
//   
//		List<JuteGateEntryHdr> jutegateentryLt = new ArrayList<JuteGateEntryHdr>();
//		for (JuteGateEntryHdr jutegateentry : jutegateentryhdrRepository.findByPoNoReturnStream(pono)) {
//			jutegateentryLt.add(jutegateentry);
//		}
//	
//	return jutegateentryLt;
//    }
    
    @Transactional(readOnly = true)
    public JuteGateEntryHdr findByPoNumReturnStream(String poNum) throws Exception{
   
    return (JuteGateEntryHdr) jutegateentryhdrRepository.findByPoNoReturnStream(poNum);
    }
    
}
