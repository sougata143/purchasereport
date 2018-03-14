package com.sougata.purchasereport.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sougata.purchasereport.component.ItemMasterDao;
import com.sougata.purchasereport.component.JuteGateEntryHdrDao;
import com.sougata.purchasereport.component.ScmIndentHdrDao;
import com.sougata.purchasereport.component.ScmIndentLineItemDao;
import com.sougata.purchasereport.component.ScmPoHdrDao;
import com.sougata.purchasereport.component.ScmPoLineItemDao;
import com.sougata.purchasereport.component.ScmPoLineItemHistDao;
import com.sougata.purchasereport.component.SupplierMasterDao;
import com.sougata.purchasereport.dto.ScmPoHdrDTO;
import com.sougata.purchasereport.dto.ScmPoLineItemDTO;
import com.sougata.purchasereport.entity.JuteGateEntryHdr;
import com.sougata.purchasereport.entity.ScmPoHdr;
import com.sougata.purchasereport.entity.ScmPoLineItem;
import com.sougata.purchasereport.entity.ScmPoLineItemHist;
import com.sougata.purchasereport.entity.SupplierMaster;
import com.sougata.purchasereport.service.scmpohdrService;


@Service
public class ScmPoHdrServiceImpl implements scmpohdrService {
	
private static final Logger LOGGER=LoggerFactory.getLogger(ScmPoHdrServiceImpl.class);
    

    @Autowired
    ScmPoHdrDao scmpohdrDao;
    
    @Autowired
    SupplierMasterDao suppliermasterDao;
    
    @Autowired
	ScmPoLineItemDao scmpolineitemDao;
	
	@Autowired
	ItemMasterDao itemmasterDao;
	
	@Autowired
	ScmIndentHdrDao scmindenthdrDao;
	
	@Autowired
	ScmIndentLineItemDao scmindentlineitemDao;
	
	@Autowired
	JuteGateEntryHdrDao jutegateentryhdrDao;
	
	@Autowired
	ScmPoLineItemHistDao scmpolineitemhistDao;

	@Override
	public List<ScmPoHdrDTO> populateScmPoHdrList(ScmPoHdrDTO scmpohdrDTO) {
		String ponum=scmpohdrDTO.getId();
    	Date endDate=scmpohdrDTO.getEndDate();
    	String poType=scmpohdrDTO.getpoType();
    	String suppcode = scmpohdrDTO.getsuppCode();
    	String itemcode = scmpohdrDTO.getItemCode();
    	String groupcode = scmpohdrDTO.getGroupCode();
    	String indentno = scmpohdrDTO.getIndentno();
    	String poStatus = scmpohdrDTO.getpoStatus();
    	String suppName = scmpohdrDTO.getSuppName();
    	
    	Date startDate=scmpohdrDTO.getStartDate();
    	Date startDate1=scmpohdrDTO.getStartDate();
    	if(startDate1!=null) {
    		LocalDate day = startDate1.toLocalDate();
    		startDate = Date.valueOf(day);
    	}else {
    		startDate = scmpohdrDTO.getStartDate();
    	}
    	
    	
    if(ponum!=null && startDate== null && poType==null && suppcode==null && suppName==null && itemcode == null && groupcode==null && indentno==null && poStatus==null){
    	List<ScmPoHdrDTO> scmpohdrDTOList=new ArrayList<ScmPoHdrDTO>();
			try {
			    List<ScmPoHdr> scmpohdrEntityList=scmpohdrDao.findByPoNumReturnStream(ponum);
			    long count =scmpohdrEntityList.stream().count();
			    
			    scmpohdrEntityList.forEach(scmpohdrEntity->{
			    	try {
			    		System.out.println(count);
						scmpohdrDTOList.add(prepareScmPoHdrDTO(scmpohdrEntity));
					} catch (Exception e) {
						e.printStackTrace();
					}
			    	
			    });
			    
			} catch (Exception e) {
			    e.printStackTrace();
			}
			
			return scmpohdrDTOList;
	
    }else if(startDate== null && poType!=null && ponum==null && suppcode==null && suppName==null && itemcode == null && groupcode==null && indentno==null && poStatus==null){
    	List<ScmPoHdrDTO> scmPoHdrDTOList=new ArrayList<ScmPoHdrDTO>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByPoTypeReturnStream(poType);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrDTO(scmpohdrEntity));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return scmPoHdrDTOList;

    }else if(startDate== null && ponum!=null && poType!=null && suppcode==null && suppName==null && itemcode == null && groupcode==null && indentno==null && poStatus==null){
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByScmPoNumAndPoTypeHdr(ponum, poType);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrDTO(scmpohdrEntity));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return scmPoHdrDTOList;
    }else if(startDate!=null && ponum==null && poType==null && suppcode==null && suppName==null && itemcode == null && groupcode==null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByDateHdr(startDate, endDate);
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrDTO(scmpohdrEntity));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return scmPoHdrDTOList;
    }else if(startDate!=null && ponum!=null && poType==null && suppcode==null && suppName==null && itemcode == null && groupcode==null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByScmPoNumAndDateHdr(startDate, endDate, ponum);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrDTO(scmpohdrEntity));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return scmPoHdrDTOList;
    }else if(startDate!=null && ponum==null && poType!=null && suppcode==null && suppName==null && itemcode == null && groupcode==null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByScmPoTypeAndDateHdr(startDate, endDate, poType);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrDTO(scmpohdrEntity));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return scmPoHdrDTOList;
    }else if(startDate!=null && ponum!=null && poType!=null && suppcode==null && suppName==null && itemcode == null && groupcode==null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByScmPoNumAndPoTypeAndDateHdr(startDate, endDate, ponum, poType);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrDTO(scmpohdrEntity));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return scmPoHdrDTOList;
    }else if(startDate==null && ponum==null && poType==null && suppcode!=null && suppName==null && itemcode == null && groupcode==null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findBySuppCode(suppcode);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrDTO(scmpohdrEntity));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getsuppCode()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    }else if(startDate!=null && ponum==null && poType==null && suppcode!=null && suppName==null && itemcode == null && groupcode==null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findBySuppCodeAndDate(suppcode, startDate, endDate);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrDTO(scmpohdrEntity));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getsuppCode()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    }else if(startDate==null && ponum==null && poType==null && suppcode==null && suppName!=null && itemcode == null && groupcode==null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByDateHdr(startDate, endDate);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			scmPoHdrDTOList.add(prepareScmPoHdrBySuppNameDTO(scmpohdrEntity,suppName));
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getsuppCode()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    }else if(startDate==null && ponum==null && poType==null && suppcode!=null && suppName!=null && itemcode == null && groupcode==null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findBySuppCodeAndDate(suppcode, startDate, endDate);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			scmPoHdrDTOList.add(prepareScmPoHdrBySuppNameDTO(scmpohdrEntity,suppName));
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getsuppCode()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    }else if(startDate!=null && ponum==null && poType==null && suppcode!=null && suppName!=null && itemcode == null && groupcode==null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findBySuppCodeAndDate(suppcode, startDate, endDate);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			scmPoHdrDTOList.add(prepareScmPoHdrBySuppNameDTO(scmpohdrEntity,suppName));
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getsuppCode()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    }else if(startDate!=null && ponum==null && poType==null && suppcode==null && suppName!=null && itemcode == null && groupcode==null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByDateHdr(startDate, endDate);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			scmPoHdrDTOList.add(prepareScmPoHdrBySuppNameDTO(scmpohdrEntity,suppName));
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getsuppCode()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    }else if(startDate!=null && ponum==null && poType==null && suppcode!=null && suppName==null && itemcode == null && groupcode==null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findBySuppCodeAndDate(suppcode, startDate, endDate);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrDTO(scmpohdrEntity));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getId()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmPoHdrDTOList;
    }
    else if(startDate==null && ponum==null && poType==null && suppcode==null && itemcode != null && groupcode==null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByDateHdr(startDate, endDate);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrForLineItemDTO(scmpohdrEntity,itemcode,groupcode));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getId()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    	
    }else if(startDate!=null && ponum==null && poType==null && suppcode==null && itemcode != null && groupcode==null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByDateHdr(startDate, endDate);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrForLineItemDTO(scmpohdrEntity,itemcode,groupcode));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		
    		if(scmpohdrEntity.getId() != null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    }else if(startDate==null && ponum==null && poType==null && suppcode==null && itemcode == null && groupcode!=null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByDateHdr(startDate, endDate);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrForLineItemDTO(scmpohdrEntity,itemcode,groupcode));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getId()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    }else if(startDate!=null && ponum==null && poType==null && suppcode==null && itemcode == null && groupcode!=null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByDateHdr(startDate, endDate);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrForLineItemDTO(scmpohdrEntity,itemcode,groupcode));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getId()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    }else if(startDate==null && ponum==null && poType==null && suppcode==null && itemcode != null && groupcode!=null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByDateHdr(startDate, endDate);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrForLineItemDTO(scmpohdrEntity,itemcode,groupcode));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getId()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    }else if(startDate!=null && ponum==null && poType==null && suppcode==null && itemcode != null && groupcode!=null && indentno==null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByDateHdr(startDate, endDate);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrForLineItemDTO(scmpohdrEntity,itemcode,groupcode));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getId()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    }else if(startDate==null && ponum==null && poType==null && suppcode==null && itemcode == null && groupcode==null && indentno!=null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByDateHdr(startDate, endDate);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			scmPoHdrDTOList.add(prepareScmPoHdrForLineItemByIndentNoDTO(scmpohdrEntity,indentno));
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getId()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    }else if(startDate!=null && ponum==null && poType==null && suppcode==null && itemcode == null && groupcode==null && indentno!=null && poStatus==null) {
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByDateHdr(startDate, endDate);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
    			scmPoHdrDTOList.add(prepareScmPoHdrForLineItemByIndentNoDTO(scmpohdrEntity,indentno));
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getId()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    }else if(startDate==null && ponum==null && poType==null && suppcode==null && itemcode == null && groupcode==null && indentno==null && poStatus!=null) {
    	System.out.println("inside find by postatus");
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
//    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByDateHdr(startDate, endDate);
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByPoStatus(poStatus);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
//    			scmPoHdrDTOList.add(prepareScmPoHdrByIndentNoDTO(scmpohdrEntity,poStatus));
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrDTO(scmpohdrEntity));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getId()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    }else if(startDate!=null && ponum==null && poType==null && suppcode==null && itemcode == null && groupcode==null && indentno==null && poStatus!=null) {
    	System.out.println("inside find by postatus and date");
    	List<ScmPoHdrDTO> scmPoHdrDTOList = new ArrayList<>();
    	try{
//    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByDateHdr(startDate, endDate);
    		List<ScmPoHdr> scmpohdrEntityList = scmpohdrDao.findByPoStatusAndDate(poStatus,startDate, endDate);
    		
    		scmpohdrEntityList.forEach(scmpohdrEntity->{
//    			scmPoHdrDTOList.add(prepareScmPoHdrByIndentNoDTO(scmpohdrEntity,poStatus));
    			try {
					scmPoHdrDTOList.add(prepareScmPoHdrDTO(scmpohdrEntity));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		});
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	List<ScmPoHdrDTO> scmpohdrmodList = new ArrayList<ScmPoHdrDTO>();
    	scmPoHdrDTOList.forEach(scmpohdrEntity->{
    		if(scmpohdrEntity.getId()!=null) {
    			scmpohdrmodList.add(scmpohdrEntity);
    		}else {}
    	});
    	
    	return scmpohdrmodList;
    }
    else{
    	System.out.println("inside find by all result");
    	List<ScmPoHdrDTO> scmpohdrDTOList=new ArrayList<ScmPoHdrDTO>();
    	try {
    	    List<ScmPoHdr> scmpohdrEntityList=scmpohdrDao.findAll();
    	    
    	    scmpohdrEntityList.forEach(scmpohdrEntity->{
    	    	try {
					scmpohdrDTOList.add(prepareScmPoHdrDTO(scmpohdrEntity));
				} catch (Exception e) {
					e.printStackTrace();
				}
    	    });
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    	
    	return scmpohdrDTOList;
   }
	}
	
	private ScmPoHdrDTO prepareScmPoHdrDTO(ScmPoHdr scmhdrEntity) throws Exception {
		
		
		ScmPoHdrDTO scmpohdrDTO = new ScmPoHdrDTO();
		List<ScmPoLineItem> scmpolineitemList = (List<ScmPoLineItem>) scmpolineitemDao.findByPoNumReturnStream(scmhdrEntity.getId());

		//JuteGateEntryHdr jutegateentryhdr = jutegateentryhdrDao.findByPoNumReturnStream(scmhdrEntity.getId());
		
		Optional<SupplierMaster> supplierMaster = 
				suppliermasterDao.getSupplierMasterById(scmhdrEntity.getSuppCode());
		
		String address1 = supplierMaster.get().getaddress1();
		String address2 = supplierMaster.get().getaddress2();
		String address3 = supplierMaster.get().getaddress3();
		String address = address1 + address2 + address3;
		
		
		scmpohdrDTO.setId(scmhdrEntity.getId());
		scmpohdrDTO.setpoType(scmhdrEntity.getPoType());
		scmpohdrDTO.setpoStatus(scmhdrEntity.getpoStatus());
		scmpohdrDTO.setsuppCode(scmhdrEntity.getsuppCode());
		scmpohdrDTO.setSuppName(supplierMaster.get().getsuppName());
		scmpohdrDTO.setPoValWoTax(scmhdrEntity.getPoValWoTax());
		scmpohdrDTO.setPoValueWtTax(scmhdrEntity.getPoValueWtTax());
		scmpohdrDTO.setDate1(scmhdrEntity.getDate1());
		scmpohdrDTO.setUser1(scmhdrEntity.getUser1());;
		scmpohdrDTO.setCreditTerm(scmhdrEntity.getCreditTerm());
		scmpohdrDTO.setDeliveryTimeline(scmhdrEntity.getDeliveryTimeline());
		scmpohdrDTO.setDiscount(scmhdrEntity.getDiscount());
		scmpohdrDTO.setTax(scmhdrEntity.getTax());
		scmpohdrDTO.setPoDate(scmhdrEntity.getPoDate());
		scmpohdrDTO.setFrieghtCharge(scmhdrEntity.getFrieghtCharge());
		scmpohdrDTO.setSuppaddress(address);
		//scmpohdrDTO.setChallanNo(jutegateentryhdr.getChallanNo());
		
		scmpohdrDTO.setStartDate(scmpohdrDTO.getStartDate());
		scmpohdrDTO.setEndDate(scmpohdrDTO.getEndDate());
		
		ScmPoLineItemHist scmpolineitemhist = (ScmPoLineItemHist) scmpolineitemhistDao.findByPoNum(scmhdrEntity.getId());
		
		if(scmpolineitemhist!=null) {
		scmpohdrDTO.setAmmendmentno(scmpolineitemhist.getAmmendmentNo());
		scmpohdrDTO.setAmmendmentdate(scmpolineitemhist.getModDate());
		}
		
		scmpolineitemList.forEach(scmpolineitem->{
			
			@SuppressWarnings("unused")
			JuteGateEntryHdr jutegateentryhdr = new JuteGateEntryHdr();
			try {
				jutegateentryhdr = jutegateentryhdrDao.findByPoNumReturnStream(scmpolineitem.getScmPoHdr().getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			scmpohdrDTO.setPonumlineitem(scmpolineitem.getPoNum());
			scmpohdrDTO.setIndentnolineitem(scmpolineitem.getindentNo());
			scmpohdrDTO.setValuewotaxlineitem(scmpolineitem.getPoValWoTax());
			scmpohdrDTO.setValuewttaxlineitem(scmpolineitem.getPoValueWtTax());
			scmpohdrDTO.setDiscount(scmpolineitem.getDiscount());
			scmpohdrDTO.setItemCode(scmpolineitem.getItemCode());
			
			/*if(jutegateentryhdr.getPono()!= null) {
				scmpohdrDTO.setChallanNo(jutegateentryhdr.getChallanNo());
			}else {}*/

			scmpohdrDTO.setApprovedindent(scmindenthdrDao.findAllByIndentTypeAndIndentStatusCount3(scmpolineitem.getIndentType()));
			scmpohdrDTO.setTotalindent(scmindenthdrDao.findAllByIndentTypeAndIndentStatusCount4(scmpolineitem.getIndentType()));
			scmpohdrDTO.setTotalindent(scmindenthdrDao.findAllByIndentTypeCount(scmpolineitem.getIndentType()));
			
		});
		
		

		    return scmpohdrDTO;
	    }

	private ScmPoHdrDTO prepareScmPoHdrForLineItemDTO(ScmPoHdr scmhdrEntity, String itemcode, String groupcode) throws Exception {
		System.out.println("inside by itemcode");
		ScmPoHdrDTO scmpohdrDto = new ScmPoHdrDTO();
		System.out.println("item code "+itemcode);
		
//		ItemMaster itemmaster = itemmasterDao.findByItemCodeReturnStream(itemcode);
		
		JuteGateEntryHdr jutegateentryhdr = jutegateentryhdrDao.findByPoNumReturnStream(scmhdrEntity.getId());
		
		Optional<SupplierMaster> supplierMaster = 
				suppliermasterDao.getSupplierMasterById(scmhdrEntity.getSuppCode());
		
		String address1 = supplierMaster.get().getaddress1();
		String address2 = supplierMaster.get().getaddress2();
		String address3 = supplierMaster.get().getaddress3();
		String address = address1 + address2 + address3;
		
		ScmPoHdrDTO scmpohdrDTO = new ScmPoHdrDTO();
		
		scmpohdrDTO.setId(scmhdrEntity.getId());
		scmpohdrDTO.setpoType(scmhdrEntity.getPoType());
		scmpohdrDTO.setpoStatus(scmhdrEntity.getpoStatus());
		scmpohdrDTO.setsuppCode(scmhdrEntity.getsuppCode());
		scmpohdrDTO.setSuppName(supplierMaster.get().getsuppName());
		scmpohdrDTO.setPoValWoTax(scmhdrEntity.getPoValWoTax());
		scmpohdrDTO.setPoValueWtTax(scmhdrEntity.getPoValueWtTax());
		scmpohdrDTO.setDate1(scmhdrEntity.getDate1());
		scmpohdrDTO.setUser1(scmhdrEntity.getUser1());;
		scmpohdrDTO.setCreditTerm(scmhdrEntity.getCreditTerm());
		scmpohdrDTO.setDeliveryTimeline(scmhdrEntity.getDeliveryTimeline());
		scmpohdrDTO.setDiscount(scmhdrEntity.getDiscount());
		scmpohdrDTO.setTax(scmhdrEntity.getTax());
		scmpohdrDTO.setPoDate(scmhdrEntity.getPoDate());
		scmpohdrDTO.setFrieghtCharge(scmhdrEntity.getFrieghtCharge());
		scmpohdrDTO.setSuppaddress(address);
		/*scmpohdrDTO.setGroupCode(itemmaster.getItemCode());
		scmpohdrDTO.setGroupCode(itemmaster.getGroupCode());
		scmpohdrDTO.setItemdesc(itemmaster.getItemDesc());*/
		
		
		int itemcodeflag = 0;
		int groupcodeflag = 0;
		
		List<ScmPoLineItemDTO> scmpolineitemDtoList = new ArrayList<ScmPoLineItemDTO>();
		for(ScmPoLineItem scmpolineitem:scmhdrEntity.getScmpolineitem()) {
			ScmPoLineItemDTO scmpolineitemDto = new ScmPoLineItemDTO();
			scmpolineitemDto.setId(scmpolineitem.getId());
			System.out.println(scmpolineitemDto.getId());
			scmpolineitemDto.setItemCode(scmpolineitem.getItemMaster().getItemCode());
			System.out.println("scmpolineitem item code "+scmpolineitem.getItemMaster().getItemCode());
			scmpolineitemDto.setItemDesc(scmpolineitem.getItemMaster().getItemDesc());
			//scmpolineitemDto.setChallanno(scmpolineitem.getJutegateentryhdr().getChallanNo());
			scmpolineitemDto.setChallanno(jutegateentryhdr.getChallanNo());
			scmpolineitemDto.setPoNum(scmpolineitem.getPoNum());
			scmpolineitemDto.setIndentNo(scmpolineitem.getindentNo());
			scmpolineitemDto.setActualQuantity(scmpolineitem.getActualQuantity());
			scmpolineitemDto.setUom(scmpolineitem.getUom());
			scmpolineitemDto.setRate(scmpolineitem.getRate());
			scmpolineitemDto.setPoValueWoTax(scmpolineitem.getPoValWoTax());
			scmpolineitemDto.setPoValueWtTax(scmpolineitem.getPoValueWtTax());
			scmpolineitemDto.setTaxApplied(scmpolineitem.getTaxApplied());
			scmpolineitemDto.setDiscount(scmpolineitem.getDiscount());
			
			scmpolineitemDtoList.add(scmpolineitemDto);
			
			String itemcode1 = scmpolineitem.getItemCode();
			String groupcode2 = scmpolineitem.getGroupCode();
			
			if(itemcode1!=null) {
				if(itemcode1.equals(itemcode)) {
					itemcodeflag=1;
				}else {
					
				}
			}else {}
			
			if(groupcode2!=null) {
				if(groupcode2.equals(groupcode)) {
					groupcodeflag=1;
				}else {}
			}else {}
			
		}
		
		
		
		
		scmpohdrDto.setScmpolineitem(scmpolineitemDtoList);
		
		if(itemcode!=null && groupcode==null) {
			System.out.println("inside by itemcode if");
			if(itemcodeflag==1) {
				return scmpohdrDTO;
			}else {
				ScmPoHdrDTO scmpohdrempDto = new ScmPoHdrDTO();
				return scmpohdrempDto;
			}
		}else if(itemcode==null && groupcode!=null) {
			System.out.println("inside by groupcode if");
			if(groupcodeflag==1) {
				return scmpohdrDTO;
			}else {
				ScmPoHdrDTO scmpohdrempDTO = new ScmPoHdrDTO();
				return scmpohdrempDTO;
			}
		}else if(itemcode!=null && groupcode!=null) {
			if(itemcodeflag==1 && groupcodeflag==1) {
				return scmpohdrDTO;
			}else {
				ScmPoHdrDTO scmpohdrempDto = new ScmPoHdrDTO();
				return scmpohdrempDto;
			}
		}else {
			ScmPoHdrDTO scmpohdrempDto = new ScmPoHdrDTO();
			return scmpohdrempDto;
		}
		
	}

	private ScmPoHdrDTO prepareScmPoHdrForLineItemByIndentNoDTO(ScmPoHdr scmpohdrEntity,String indentno) {
		ScmPoHdrDTO scmpohdrDto = new ScmPoHdrDTO();
		
		ScmPoHdrDTO scmpohdrDTO = new ScmPoHdrDTO();
		
		scmpohdrDTO.setId(scmpohdrEntity.getId());
		scmpohdrDTO.setpoType(scmpohdrEntity.getPoType());
		scmpohdrDTO.setpoStatus(scmpohdrEntity.getpoStatus());
		scmpohdrDTO.setsuppCode(scmpohdrEntity.getsuppCode());
		//scmpohdrDTO.setSuppName(supplierMaster.getsuppName());
		scmpohdrDTO.setPoValWoTax(scmpohdrEntity.getPoValWoTax());
		scmpohdrDTO.setPoValueWtTax(scmpohdrEntity.getPoValueWtTax());
		scmpohdrDTO.setDate1(scmpohdrEntity.getDate1());
		scmpohdrDTO.setUser1(scmpohdrEntity.getUser1());;
		scmpohdrDTO.setCreditTerm(scmpohdrEntity.getCreditTerm());
		scmpohdrDTO.setDeliveryTimeline(scmpohdrEntity.getDeliveryTimeline());
		scmpohdrDTO.setDiscount(scmpohdrEntity.getDiscount());
		scmpohdrDTO.setTax(scmpohdrEntity.getTax());
		scmpohdrDTO.setPoDate(scmpohdrEntity.getPoDate());
		scmpohdrDTO.setFrieghtCharge(scmpohdrEntity.getFrieghtCharge());
		//scmpohdrDTO.setSuppaddress(address);
		
		int indentnoflag = 0;
		List<ScmPoLineItemDTO> scmpolineitemDtoList =new ArrayList<ScmPoLineItemDTO>();
		
		for(ScmPoLineItem scmpolineitem : scmpohdrEntity.getScmpolineitem()) {
			ScmPoLineItemDTO scmpolineitemDto = new ScmPoLineItemDTO();
			scmpolineitemDto.setPoNum(scmpohdrEntity.getId());
			scmpohdrDto.setValuewotaxlineitem(scmpohdrEntity.getPoValWoTax());
			scmpohdrDto.setValuewttaxlineitem(scmpohdrEntity.getPoValueWtTax());
			scmpohdrDto.setsuppCode(scmpohdrEntity.getsuppCode());
			scmpohdrDto.setSuppName(scmpohdrEntity.getSuppliermaster().getsuppName());
			scmpohdrDto.setValuewotaxlineitem(scmpolineitem.getPoValWoTax());
			scmpohdrDto.setValuewttaxlineitem(scmpolineitem.getPoValueWtTax());
			scmpohdrDto.setModOn(scmpohdrEntity.getModOn());
			scmpohdrDto.setModBy(scmpohdrEntity.getModBy());
			scmpohdrDto.setSuppName(scmpohdrEntity.getSuppliermaster().getsuppName());
			
			scmpolineitemDtoList.add(scmpolineitemDto);
			
			String indentno1 = scmpolineitem.getindentNo();
			
			if(indentno1!=null) {
				if(indentno1.equals(indentno)) {
					indentnoflag=1;
				}else {}
			}else {}
			
		}
		
		scmpohdrDto.setScmpolineitem(scmpolineitemDtoList);
		
		if(indentno!=null) {
			if(indentnoflag==1) {
				return scmpohdrDto;
			}else {
				ScmPoHdrDTO scmpohdrempDto = new ScmPoHdrDTO();
				return scmpohdrempDto;
			}
		}else {
			ScmPoHdrDTO scmpohdrempDto = new ScmPoHdrDTO();
			return scmpohdrempDto;
		}
		
	}

	@SuppressWarnings("unused")
	private ScmPoHdrDTO prepareScmPoHdrByIndentNoDTO(ScmPoHdr scmpohdrEntity,String poStatus) {
		ScmPoHdrDTO scmpohdrDto = new ScmPoHdrDTO();
		
	ScmPoHdrDTO scmpohdrDTO = new ScmPoHdrDTO();
		
		scmpohdrDTO.setId(scmpohdrEntity.getId());
		scmpohdrDTO.setpoType(scmpohdrEntity.getPoType());
		scmpohdrDTO.setpoStatus(scmpohdrEntity.getpoStatus());
		scmpohdrDTO.setsuppCode(scmpohdrEntity.getsuppCode());
		//scmpohdrDTO.setSuppName(supplierMaster.getsuppName());
		scmpohdrDTO.setPoValWoTax(scmpohdrEntity.getPoValWoTax());
		scmpohdrDTO.setPoValueWtTax(scmpohdrEntity.getPoValueWtTax());
		scmpohdrDTO.setDate1(scmpohdrEntity.getDate1());
		scmpohdrDTO.setUser1(scmpohdrEntity.getUser1());;
		scmpohdrDTO.setCreditTerm(scmpohdrEntity.getCreditTerm());
		scmpohdrDTO.setDeliveryTimeline(scmpohdrEntity.getDeliveryTimeline());
		scmpohdrDTO.setDiscount(scmpohdrEntity.getDiscount());
		scmpohdrDTO.setTax(scmpohdrEntity.getTax());
		scmpohdrDTO.setPoDate(scmpohdrEntity.getPoDate());
		scmpohdrDTO.setFrieghtCharge(scmpohdrEntity.getFrieghtCharge());
		//scmpohdrDTO.setSuppaddress(address);
		
		int postatusflag = 0;
		
		List<ScmPoLineItemDTO> scmpolineitemDtoList = new ArrayList<ScmPoLineItemDTO>();
		
		for(ScmPoLineItem scmpohdrlineitem : scmpohdrEntity.getScmpolineitem()) {
			ScmPoLineItemDTO scmpolineitemDto = new ScmPoLineItemDTO();
			scmpohdrDto.setPonumlineitem(scmpohdrlineitem.getPoNum());
			scmpohdrDto.setpoType(scmpohdrEntity.getPoType());
			scmpohdrDto.setIndentno(scmpohdrlineitem.getindentNo());
			scmpohdrDto.setModBy(scmpohdrlineitem.getModBy());
			scmpohdrDto.setModOn(scmpohdrlineitem.getModDate());
//			scmpohdrDto.setRemarks(scmpohdrlineitem.getScmPoHdr().ge);
			
			scmpolineitemDtoList.add(scmpolineitemDto);
			
			String poStatus1 = scmpohdrlineitem.getScmPoHdr().getPoStatus();
			
			if(poStatus1!=null) {
				if(poStatus1.equals(poStatus)) {
					postatusflag=1;
				}else {}
			}else {}
		}
		
		scmpohdrDto.setScmpolineitem(scmpolineitemDtoList);
		
		if(poStatus!=null) {
			if(postatusflag==1) {
				return scmpohdrDto;
			}else {
				ScmPoHdrDTO scmpohdrempDto = new ScmPoHdrDTO();
				return scmpohdrempDto;
			}
		}else {
			ScmPoHdrDTO scmpohdrempDto = new ScmPoHdrDTO();
			return scmpohdrempDto;
		}
		
	}

	private ScmPoHdrDTO prepareScmPoHdrBySuppNameDTO(ScmPoHdr scmpohdrEntity, String suppName) {
		ScmPoHdrDTO scmpohdrDto = new ScmPoHdrDTO();
		
	try {
		JuteGateEntryHdr jutegateentryhdr = jutegateentryhdrDao.findByPoNumReturnStream(scmpohdrEntity.getId());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		Optional<SupplierMaster> supplierMaster = 
				suppliermasterDao.getSupplierMasterById(scmpohdrEntity.getSuppCode());
		
		String address1 = supplierMaster.get().getaddress1();
		String address2 = supplierMaster.get().getaddress2();
		String address3 = supplierMaster.get().getaddress3();
		String address = address1 + address2 + address3;
		
		ScmPoHdrDTO scmpohdrDTO = new ScmPoHdrDTO();
		
		scmpohdrDTO.setId(scmpohdrEntity.getId());
		scmpohdrDTO.setpoType(scmpohdrEntity.getPoType());
		scmpohdrDTO.setpoStatus(scmpohdrEntity.getpoStatus());
		scmpohdrDTO.setsuppCode(scmpohdrEntity.getsuppCode());
		scmpohdrDTO.setSuppName(supplierMaster.get().getsuppName());
		scmpohdrDTO.setPoValWoTax(scmpohdrEntity.getPoValWoTax());
		scmpohdrDTO.setPoValueWtTax(scmpohdrEntity.getPoValueWtTax());
		scmpohdrDTO.setDate1(scmpohdrEntity.getDate1());
		scmpohdrDTO.setUser1(scmpohdrEntity.getUser1());;
		scmpohdrDTO.setCreditTerm(scmpohdrEntity.getCreditTerm());
		scmpohdrDTO.setDeliveryTimeline(scmpohdrEntity.getDeliveryTimeline());
		scmpohdrDTO.setDiscount(scmpohdrEntity.getDiscount());
		scmpohdrDTO.setTax(scmpohdrEntity.getTax());
		scmpohdrDTO.setPoDate(scmpohdrEntity.getPoDate());
		scmpohdrDTO.setFrieghtCharge(scmpohdrEntity.getFrieghtCharge());
		scmpohdrDTO.setSuppaddress(address);
		/*scmpohdrDTO.setGroupCode(itemmaster.getItemCode());
		scmpohdrDTO.setGroupCode(itemmaster.getGroupCode());
		scmpohdrDTO.setItemdesc(itemmaster.getItemDesc());*/
		
		int suppNameflag = 0;
		/*SupplierMaster supplierMaster = 
				suppliermasterDao.getSupplierMasterById(scmpohdrEntity.getSuppCode());
		
		String address1 = supplierMaster.getaddress1();
		String address2 = supplierMaster.getaddress2();
		String address3 = supplierMaster.getaddress3();
		String address = address1 + address2 + address3;*/
		
		
		
		List<ScmPoLineItemDTO> scmplineitemDtoList = new ArrayList<ScmPoLineItemDTO>();
		
		for(ScmPoLineItem scmpolineitem : scmpohdrEntity.getScmpolineitem()) {
			ScmPoLineItemDTO scmpolineitemDto = new ScmPoLineItemDTO();
			scmpohdrDto.setsuppCode(scmpohdrEntity.getSuppCode());
			scmpohdrDto.setSuppName(scmpohdrEntity.getSuppliermaster().getsuppName());
			scmpohdrDto.setSuppType(scmpohdrEntity.getSuppliermaster().getdesignation());
			scmpohdrDto.setSuppaddress(address);
			//scmpohdrDto.setPonumlineitem(scmpolineitem.getId());
			scmpohdrDto.setItemCode(scmpolineitem.getItemCode());
			scmpohdrDto.setItemdesc(scmpolineitem.getItemMaster().getItemDesc());
			
			
			String suppName1 = scmpohdrEntity.getSuppliermaster().getsuppName();
			
			if(suppName1!=null) {
				if(suppName1.equals(suppName)) {
					suppNameflag=1;
				}else {}
			}else {}
			
			
			
		}
		scmpohdrDto.setScmpolineitem(scmplineitemDtoList);
		
		
		if(suppName!=null) {
			if(suppNameflag==1) {
				return scmpohdrDto;
			}else {
				ScmPoHdrDTO scmpohdrempDto = new ScmPoHdrDTO();
				return scmpohdrempDto;
			}
		}else {
			ScmPoHdrDTO scmpohdrempDto = new ScmPoHdrDTO();
			return scmpohdrempDto;
		}
		
		
	}

	@Override
	public List<ScmPoLineItemDTO> populateOneScmPoLineItemDetails(String ponum) {
		List<ScmPoLineItemDTO> scmpolineitemDtoList = new ArrayList<ScmPoLineItemDTO>();
		try {
			List<ScmPoLineItem> scmpolineitemEntityList = scmpolineitemDao.findByPoNumReturnStream(ponum);
			scmpolineitemEntityList.forEach(scmpolineitem->{
				scmpolineitemDtoList.add(prepareScmPoLineItemDTO(scmpolineitem));
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return scmpolineitemDtoList;
	}
	
	private ScmPoLineItemDTO prepareScmPoLineItemDTO(ScmPoLineItem scmpolineitem) {
		ScmPoLineItemDTO scmpolienitemDto = new ScmPoLineItemDTO();
		
		scmpolienitemDto.setId(scmpolineitem.getId());
		scmpolienitemDto.setIndentNo(scmpolineitem.getindentNo());
		scmpolienitemDto.setItemCode(scmpolineitem.getItemCode());
		scmpolienitemDto.setItemDesc(scmpolineitem.getItemMaster().getItemDesc());
		scmpolienitemDto.setActualQuantity(scmpolineitem.getActualQuantity());
		scmpolienitemDto.setDiscount(scmpolineitem.getDiscount());
		scmpolienitemDto.setUom(scmpolineitem.getUom());
		scmpolienitemDto.setRate(scmpolineitem.getRate());
		scmpolienitemDto.setPoNum(scmpolineitem.getPoNum());
		scmpolienitemDto.setPoType(scmpolineitem.getScmPoHdr().getPoType());
		scmpolienitemDto.setPoValueWoTax(scmpolineitem.getPoValWoTax());
		scmpolienitemDto.setPoValueWtTax(scmpolineitem.getPoValueWtTax());
		scmpolienitemDto.setTaxApplied(scmpolineitem.getTaxApplied());
		
		
		return scmpolienitemDto;
	}

}
