package com.sougata.purchasereport.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEMMASTER")
public class ItemMasterDTO {
	
	@Id
	@Column(name="ITEM_CODE")
	private String itemCode;
	
	@Column(name="ITEM_DESC")
	private String itemDesc;
	
	@Column(name="GROUP_CODE")
	private String groupCode;
	
	@Column(name="LEGACY_ITEM_CODE")
	private String legacyItemCode;


	public String getLegacyItemCode() {
		return legacyItemCode;
	}

	public void setLegacyItemCode(String legacyItemCode) {
		this.legacyItemCode = legacyItemCode;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	
	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	
	

}
