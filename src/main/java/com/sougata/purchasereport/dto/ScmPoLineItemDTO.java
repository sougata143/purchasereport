package com.sougata.purchasereport.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sougata.purchasereport.entity.JuteGateEntryHdr;


@Entity
@Table(name = "SCM_PO_LINE_ITEM")
public class ScmPoLineItemDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "LINE_ITEM_NUM")
    private Long id;

    @Column(name = "INDENT_NO")
    private String indentNo;
    
    @Column(name="UOM")
    private String uom;
    
    @Column(name="RATE")
    private int rate;
    
	@Column(name = "PO_NUM")
    private String poNum;
    
    @Column(name="PO_TYPE")
    private String poType;
    
    @Column(name="ITEM_CODE")
    private String itemCode;
    
    @Column(name="VALUE_WO_TAX")
    private int poValueWoTax;
    
    @Column(name="VALUE_Wt_TAX")
    private int poValueWtTax;
    
    @Column(name="TAX_APPLIED")
    private int taxApplied;
    
    @Column(name="ACTUAL_QUANTITY")
    private int actualQuantity;
    
    @Column(name="DISCOUNT")
    private int discount;
    
    @OneToOne(cascade = { })
    @JoinColumn(name= "PO_NO", insertable = false, updatable = false)
    private JuteGateEntryHdr jutegateentryhdr;
	
	
    
    public JuteGateEntryHdr getJutegateentryhdr() {
		return jutegateentryhdr;
	}

	public void setJutegateentryhdr(JuteGateEntryHdr jutegateentryhdr) {
		this.jutegateentryhdr = jutegateentryhdr;
	}
    
    private String itemDesc;
    private int challanno;
    private Date startdate;
    private Date enddate;
    private Long indentQty;
    private Long cancelQty;
    private String remarks;
    private String suppType;
    
    public String getSuppType() {
		return suppType;
	}

	public void setSuppType(String suppType) {
		this.suppType = suppType;
	}

	public Long getIndentQty() {
		return indentQty;
	}

	public void setIndentQty(Long indentQty) {
		this.indentQty = indentQty;
	}

	public Long getCancelQty() {
		return cancelQty;
	}

	public void setCancelQty(Long cancelQty) {
		this.cancelQty = cancelQty;
	}

	

	public String getIndentNo() {
		return indentNo;
	}

	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
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
	
	
    public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public int getChallanno() {
		return challanno;
	}

	public void setChallanno(int challanno) {
		this.challanno = challanno;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemCode() {
		return itemCode;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getPoValueWoTax() {
		return poValueWoTax;
	}

	public void setPoValueWoTax(int poValueWoTax) {
		this.poValueWoTax = poValueWoTax;
	}

	public int getPoValueWtTax() {
		return poValueWtTax;
	}

	public void setPoValueWtTax(int poValueWtTax) {
		this.poValueWtTax = poValueWtTax;
	}

	public int getTaxApplied() {
		return taxApplied;
	}

	public void setTaxApplied(int taxApplied) {
		this.taxApplied = taxApplied;
	}

	public int getActualQuantity() {
		return actualQuantity;
	}

	public void setActualQuantity(int actualQuantity) {
		this.actualQuantity = actualQuantity;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	
    @OneToOne(cascade ={})
    @JoinColumn(name = "ITEM_CODE",insertable = false, updatable = false)
    private ItemMasterDTO ItemMaster;
    public ScmPoLineItemDTO() {
	super();
    }

    public ItemMasterDTO getItemMaster() {
		return ItemMaster;
	}

	public void setItemMaster(ItemMasterDTO itemMaster) {
		ItemMaster = itemMaster;
	}

	public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }
    
   
    @Override
    public String toString() {
	return "ScmPoLineItem [id=" + id + "]";
    }

	public String getPoType() {
		return poType;
	}

	public void setPoType(String poType) {
		this.poType = poType;
	}


	public String getPoNum() {
		return poNum;
	}

	public void setPoNum(String poNum) {
		this.poNum = poNum;
	}

    

   

}


