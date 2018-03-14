package com.sougata.purchasereport.entity;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SCM_PO_LINE_ITEM_HIST")
public class ScmPoLineItemHist {
	
	@Id
	@Column(name="AMMENDMENT_NO")
	private long ammendmentNo;
	
	@Column(name="LINE_ITEM_NUM")
	private String lineItemNum;
	
	@Column(name="PO_NUM")
	private String poNum;
	
	@Column(name="ITEM_CODE")
	private String itemCode;
	
	@Column(name="ITEM_DESC")
	private String itemDesc;
	
	@Column(name="QUALITY")
	private String quality;
	
	@Column(name="MARKA")
	private String marka;
	
	@Column(name="QUANTITY")
	private int qnty;
	
	@Column(name="UOM")
	private String uom;
	
	@Column(name="RATE")
	private int rate;
	
	@Column(name="VALUE_WO_TAX")
	private int valueWoTax;
	
	@Column(name="VALUE_WT_TAX")
	private int valueWtTax;
	
	@Column(name="TAX_APPLIED")
	private long taxApplied;
	
	@Column(name="INDENT_NO")
	private String indentNo;
	
	@Column(name="INDENT_TYPE")
	private String indentType;
	
	@Column(name="MOD_BY")
	private String modBy;
	
	@Column(name="MOD_DATE")
	private Date modDate;
	
	@Column(name="APPROVER_LEVEL_FIRST")
	private String approverLevelFirst;
	
	@Column(name="APPROVE_LEVEL_FIRST_DATE")
	private Date approverlevelFirstDate;
	
	@Column(name="APPROVER_LEVEL_SECOND")
	private String approverLevelSecond;
	
	@Column(name="APPROVE_LEVEL_SECOND_DATE")
	private Date approverLevelSecondDate;
	
	@Column(name="ACTUAL_QUANTITY")
	private long actualQnty;
	
	@Column(name="GROUP_CODE")
	private String groupCode;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="DISCOUNT")
	private String discount;
	
	@Column(name="ALLOWABLE_MOISTURE_PERCENTAGE")
	private int allowableMoisturePercentage;

	public long getAmmendmentNo() {
		return ammendmentNo;
	}

	public void setAmmendmentNo(long ammendmentNo) {
		this.ammendmentNo = ammendmentNo;
	}

	public String getLineItemNum() {
		return lineItemNum;
	}

	public void setLineItemNum(String lineItemNum) {
		this.lineItemNum = lineItemNum;
	}

	public String getPoNum() {
		return poNum;
	}

	public void setPoNum(String poNum) {
		this.poNum = poNum;
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

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public int getQnty() {
		return qnty;
	}

	public void setQnty(int qnty) {
		this.qnty = qnty;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getValueWoTax() {
		return valueWoTax;
	}

	public void setValueWoTax(int valueWoTax) {
		this.valueWoTax = valueWoTax;
	}

	public int getValueWtTax() {
		return valueWtTax;
	}

	public void setValueWtTax(int valueWtTax) {
		this.valueWtTax = valueWtTax;
	}

	public long getTaxApplied() {
		return taxApplied;
	}

	public void setTaxApplied(long taxApplied) {
		this.taxApplied = taxApplied;
	}

	public String getIndentNo() {
		return indentNo;
	}

	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
	}

	public String getIndentType() {
		return indentType;
	}

	public void setIndentType(String indentType) {
		this.indentType = indentType;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public String getApproverLevelFirst() {
		return approverLevelFirst;
	}

	public void setApproverLevelFirst(String approverLevelFirst) {
		this.approverLevelFirst = approverLevelFirst;
	}

	public Date getApproverlevelFirstDate() {
		return approverlevelFirstDate;
	}

	public void setApproverlevelFirstDate(Date approverlevelFirstDate) {
		this.approverlevelFirstDate = approverlevelFirstDate;
	}

	public String getApproverLevelSecond() {
		return approverLevelSecond;
	}

	public void setApproverLevelSecond(String approverLevelSecond) {
		this.approverLevelSecond = approverLevelSecond;
	}

	public Date getApproverLevelSecondDate() {
		return approverLevelSecondDate;
	}

	public void setApproverLevelSecondDate(Date approverLevelSecondDate) {
		this.approverLevelSecondDate = approverLevelSecondDate;
	}

	public long getActualQnty() {
		return actualQnty;
	}

	public void setActualQnty(long actualQnty) {
		this.actualQnty = actualQnty;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public int getAllowableMoisturePercentage() {
		return allowableMoisturePercentage;
	}

	public void setAllowableMoisturePercentage(int allowableMoisturePercentage) {
		this.allowableMoisturePercentage = allowableMoisturePercentage;
	}

	public ScmPoLineItemHist() {
		super();
		
	}

	public ScmPoLineItemHist(long ammendmentNo, String lineItemNum, String poNum, String itemCode, String itemDesc,
			String quality, String marka, int qnty, String uom, int rate, int valueWoTax, int valueWtTax,
			long taxApplied, String indentNo, String indentType, String modBy, Date modDate, String approverLevelFirst,
			Date approverlevelFirstDate, String approverLevelSecond, Date approverLevelSecondDate, long actualQnty,
			String groupCode, String status, String discount, int allowableMoisturePercentage) {
		super();
		this.ammendmentNo = ammendmentNo;
		this.lineItemNum = lineItemNum;
		this.poNum = poNum;
		this.itemCode = itemCode;
		this.itemDesc = itemDesc;
		this.quality = quality;
		this.marka = marka;
		this.qnty = qnty;
		this.uom = uom;
		this.rate = rate;
		this.valueWoTax = valueWoTax;
		this.valueWtTax = valueWtTax;
		this.taxApplied = taxApplied;
		this.indentNo = indentNo;
		this.indentType = indentType;
		this.modBy = modBy;
		this.modDate = modDate;
		this.approverLevelFirst = approverLevelFirst;
		this.approverlevelFirstDate = approverlevelFirstDate;
		this.approverLevelSecond = approverLevelSecond;
		this.approverLevelSecondDate = approverLevelSecondDate;
		this.actualQnty = actualQnty;
		this.groupCode = groupCode;
		this.status = status;
		this.discount = discount;
		this.allowableMoisturePercentage = allowableMoisturePercentage;
	}

	@Override
	public String toString() {
		return "ScmPoLineItemHist [ammendmentNo=" + ammendmentNo + ", lineItemNum=" + lineItemNum + ", poNum=" + poNum
				+ ", itemCode=" + itemCode + ", itemDesc=" + itemDesc + ", quality=" + quality + ", marka=" + marka
				+ ", qnty=" + qnty + ", uom=" + uom + ", rate=" + rate + ", valueWoTax=" + valueWoTax + ", valueWtTax="
				+ valueWtTax + ", taxApplied=" + taxApplied + ", indentNo=" + indentNo + ", indentType=" + indentType
				+ ", modBy=" + modBy + ", modDate=" + modDate + ", approverLevelFirst=" + approverLevelFirst
				+ ", approverlevelFirstDate=" + approverlevelFirstDate + ", approverLevelSecond=" + approverLevelSecond
				+ ", approverLevelSecondDate=" + approverLevelSecondDate + ", actualQnty=" + actualQnty + ", groupCode="
				+ groupCode + ", status=" + status + ", discount=" + discount + ", allowableMoisturePercentage="
				+ allowableMoisturePercentage + "]";
	}
	
	

}
