package com.sougata.purchasereport.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEMMASTER")
public class ItemMaster {

	@Id
	@Column(name="ITEM_CODE")
	private String itemCode;
	
	@Column(name="ITEM_DESC")
	private String itemDesc;
	
	@Column(name="GROUP_CODE")
	private String groupCode;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="UOM_CODE")
	private String uomCode;
	
	@Column(name="MULTI_FACT")
	private int multiFact;

	@Column(name="CENTRAL_STOCK")
	private int generalStock;
	
	@Column(name="DIRECT_INDIRECT_TAG")
	private String directIndirectTag;
	
	@Column(name="SPL_ITEM_TAG")
	private String splItemTag;
	
	@Column(name="ISSUABLE_TAG")
	private String issuableTag;
	
	@Column(name="USER_1")
	private String user1;
	
	@Column(name="DATE_1")
	private Date date1;
	
	@Column(name="USER_2")
	private String user2;
	
	@Column(name="DATE_2")
	private Date date2;
	
	@Column(name="USER_3")
	private String user3;
	
	@Column(name="DATE_3")
	private Date date3;
	
	@Column(name="USER_4")
	private String user4;
	
	@Column(name="DATE_4")
	private Date date4;
	
	@Column(name="ACTIVE_FLAG")
	private String activeFlag;
	
	@Column(name="DTL_ITEM_DESC1")
	private String dtlItemDesc1;
	
	@Column(name="DTL_ITEM_DESC2")
	private String dtlItemDesc2;
	
	@Column(name="MAKE")
	private String make;
	
	@Column(name="HSN_CODE")
	private String hsnCode;
	
	@Column(name="MOD_BY")
	private String modBy;
	
	@Column(name="MOD_ON")
	private Date modOn;
	
	@Column(name="LEGACY_ITEM_CODE")
	private String legacyItemCode;
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUomCode() {
		return uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public int getMultiFact() {
		return multiFact;
	}

	public void setMultiFact(int multiFact) {
		this.multiFact = multiFact;
	}

	public int getGeneralStock() {
		return generalStock;
	}

	public void setGeneralStock(int generalStock) {
		this.generalStock = generalStock;
	}

	public String getDirectIndirectTag() {
		return directIndirectTag;
	}

	public void setDirectIndirectTag(String directIndirectTag) {
		this.directIndirectTag = directIndirectTag;
	}

	public String getSplItemTag() {
		return splItemTag;
	}

	public void setSplItemTag(String splItemTag) {
		this.splItemTag = splItemTag;
	}

	public String getIssuableTag() {
		return issuableTag;
	}

	public void setIssuableTag(String issuableTag) {
		this.issuableTag = issuableTag;
	}

	public String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		this.user1 = user1;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public String getUser2() {
		return user2;
	}

	public void setUser2(String user2) {
		this.user2 = user2;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public String getUser3() {
		return user3;
	}

	public void setUser3(String user3) {
		this.user3 = user3;
	}

	public Date getDate3() {
		return date3;
	}

	public void setDate3(Date date3) {
		this.date3 = date3;
	}

	public String getUser4() {
		return user4;
	}

	public void setUser4(String user4) {
		this.user4 = user4;
	}

	public Date getDate4() {
		return date4;
	}

	public void setDate4(Date date4) {
		this.date4 = date4;
	}

	public String getDtlItemDesc1() {
		return dtlItemDesc1;
	}

	public void setDtlItemDesc1(String dtlItemDesc1) {
		this.dtlItemDesc1 = dtlItemDesc1;
	}

	public String getDtlItemDesc2() {
		return dtlItemDesc2;
	}

	public void setDtlItemDesc2(String dtlItemDesc2) {
		this.dtlItemDesc2 = dtlItemDesc2;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public Date getModOn() {
		return modOn;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}

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
