package com.sougata.purchasereport.repository.customrepository;

import java.util.List;

import com.sougata.purchasereport.entity.ScmPoHdr;

public interface ScmPoHdrCustomRepository {

	ScmPoHdr getScmPoHdrById(String Id);
	ScmPoHdr getScmPoHdrByPoType(String poType);
    
    List<ScmPoHdr> getAllScmPoHdr();
	

}
