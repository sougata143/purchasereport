package com.sougata.purchasereport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sougata.purchasereport.dto.ScmPoHdrDTO;
import com.sougata.purchasereport.dto.ScmPoLineItemDTO;
import com.sougata.purchasereport.service.impl.ScmPoHdrServiceImpl;

@RestController
@RequestMapping("/")
public class ScmPoHdrController {
	
	@Autowired
	ScmPoHdrServiceImpl scmpohdrService;

	@RequestMapping(value = "getpohdr", method = RequestMethod.POST)
    @ResponseBody
    public List<ScmPoHdrDTO> populateScmPoHdrList(@RequestBody ScmPoHdrDTO scmpohdrDTO) {	
		return scmpohdrService.populateScmPoHdrList(scmpohdrDTO);
	}
	
	@RequestMapping(value = "getPoLineItemByPoNum/{poNum}", method = RequestMethod.GET)
	@ResponseBody
	public List<ScmPoLineItemDTO> populateOneScmPoLineItemDetails(@PathVariable("poNum") String poNum){
		return scmpohdrService.populateOneScmPoLineItemDetails(poNum);
	}
	
}
