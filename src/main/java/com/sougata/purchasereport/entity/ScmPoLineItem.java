package com.sougata.purchasereport.entity;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name = "SCM_PO_LINE_ITEM")
public class ScmPoLineItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "LINE_ITEM_NUM")
    private Long id;

    @Column(name = "INDENT_NO")
    private String indentNo;
    
    @Column(name="PO_NUM")
    private String poNum;
    

    @OneToOne(cascade = { })
    @JoinColumn(name = "INDENT_NO",insertable = false, updatable = false)
    private ScmIndentHdr scmindenthdr;
    
    
    
    public String getPoNum() {
		return poNum;
	}

	public void setPoNum(String poNum) {
		this.poNum = poNum;
	}

	@OneToOne(cascade = { })
    @JoinColumn(name= "PO_NUM", insertable = false, updatable = false)
    private ScmPoHdr scmPoHdr;
	
	/*@OneToOne(cascade = { })
  @JoinColumn(name= "PO_NO", insertable = false, updatable = false)
  private JuteGateEntryHdr jutegateentryhdr;
	
	
    
    public JuteGateEntryHdr getJutegateentryhdr() {
		return jutegateentryhdr;
	}

	public void setJutegateentryhdr(JuteGateEntryHdr jutegateentryhdr) {
		this.jutegateentryhdr = jutegateentryhdr;
	}*/

	@OneToOne(cascade ={})
    @JoinColumn(name = "ITEM_CODE",insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private ItemMaster ItemMaster;
    
//    @Column(name="ITEM_DESC")
//    private String itemDesc;
    
    @Column(name="QUALITY")
    private String quality;
    
    @Column(name="MARKA")
    private String marka;
    
    @Column(name="QUANTITY")
    private Long quantity;
    
    @Column(name="UOM")
    private String uom;
    
    @Column(name="RATE")
    private int rate;
    
    @Column(name="VALUE_WO_TAX")
    private int poValWoTax;
    
    @Column(name="TAX_APPLIED")
    private int taxApplied;
    
    @Column(name="VALUE_WT_TAX")
    private int poValWtTax;
    
    @Column(name="MOD_BY")
    private String modBy;
    
    @Column(name="MOD_DATE")
    private Date modDate;
    
    @Column(name="APPROVER_LEVEL_FIRST")
    private String approverLevelFirst;
    
    @Column(name="APPROVE_LEVEL_FIRST_DATE")
    private Date approveLevelFirstDate;
    
    @Column(name="APPROVE_LEVEL_SECOND_DATE")
    private Date approveLevelSecondDate;
    
    @Column(name="ACTUAL_QUANTITY")
    private int actualQuantity;
    
    @Column(name="GROUP_CODE")
    private String groupCode;
    
    @Column(name="STATUS")
    private String status;
    
    @Column(name="DISCOUNT")
    private int discount;
    
    @Column(name="ITEM_CODE")
    private String itemCode;
    
    @Column(name="INDENT_TYPE")
    private String indentType;
    
    public ScmPoLineItem() {
	super();
    }

    public Long getId() {
	return id;
    }


	public ItemMaster getItemMaster() {
		return ItemMaster;
	}

	public void setItemMaster(ItemMaster itemMaster) {
		ItemMaster = itemMaster;
	}

	public void setId(Long id) {
	this.id = id;
    }
    
    
    public String getIndentType() {
		return indentType;
	}

	public void setIndentType(String indentType) {
		this.indentType = indentType;
	}

	public ScmIndentHdr getScmIndentHdr() {
        return scmindenthdr;
    }

    public void setScmIndentHdr(ScmIndentHdr scmindenthdr) {
        this.scmindenthdr = scmindenthdr;
    }

    public String getindentNo() {
	return indentNo;
    }

    public void setindentNo(String indentNo) {
	this.indentNo = indentNo;
    }

    
   
    @Override
    public String toString() {
	return "ScmPoLineItem [id=" + id + "]";
    }

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

//	public String getItemDesc() {
//		return itemDesc;
//	}
//
//	public void setItemDesc(String itemDesc) {
//		this.itemDesc = itemDesc;
//	}

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

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
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

	
	public int getTaxApplied() {
		return taxApplied;
	}

	public void setTaxApplied(int taxApplied) {
		this.taxApplied = taxApplied;
	}

	

	public int getPoValWoTax() {
		return poValWoTax;
	}

	public void setPoValueWoTax(int poValWoTax) {
		this.poValWoTax = poValWoTax;
	}

	public int getPoValueWtTax() {
		return poValWtTax;
	}

	public void setPoValWtTax(int poValWtTax) {
		this.poValWtTax = poValWtTax;
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

	public Date getApproveLevelFirstDate() {
		return approveLevelFirstDate;
	}

	public void setApproveLevelFirstDate(Date approveLevelFirstDate) {
		this.approveLevelFirstDate = approveLevelFirstDate;
	}

	public Date getApproveLevelSecondDate() {
		return approveLevelSecondDate;
	}

	public void setApproveLevelSecondDate(Date approveLevelSecondDate) {
		this.approveLevelSecondDate = approveLevelSecondDate;
	}

	public int getActualQuantity() {
		return actualQuantity;
	}

	public void setActualQuantity(int actualQuantity) {
		this.actualQuantity = actualQuantity;
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

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public ScmPoHdr getScmPoHdr() {
		return scmPoHdr;
	}

	public void setScmPoHdr(ScmPoHdr scmPoHdr) {
		this.scmPoHdr = scmPoHdr;
	}

    

   

}

