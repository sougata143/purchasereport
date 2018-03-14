package com.sougata.purchasereport.service;

import java.util.List;

import com.sougata.purchasereport.dto.ScmPoHdrDTO;
import com.sougata.purchasereport.dto.ScmPoLineItemDTO;



public interface scmpohdrService {

	public List<ScmPoHdrDTO> populateScmPoHdrList(ScmPoHdrDTO scmpohdrDTO);

	   
	   public List<ScmPoLineItemDTO> populateOneScmPoLineItemDetails(String ponum);
	
}
