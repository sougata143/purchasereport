package com.sougata.purchasereport.entity;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SCM_PO_HDR")
public class ScmPoHdr implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
    
    @Id()
    @Column(name = "PO_NUM")
    private String id;
    
    @Column(name = "PO_TYPE")
    private String poType;
    
    public String getPoType() {
		return poType;
	}

	public void setPoType(String poType) {
		this.poType = poType;
	}

	@Column(name="FIN_YEAR")
    private String finYear;

    @Column(name = "PO_STATUS")
    private String poStatus;

    @Column(name = "SUPP_CODE")
    private String suppCode;
    
    @Column(name="PO_VAL_WO_TAX")
    private int poValWoTax;
    
    @Column(name="PO_VAL_WT_TAX")
    private int poValWtTax;
    
    @Column(name="MOD_ON")
    private Date modOn;
    
    @Column(name="MOD_BY")
    private String modBy;
    
    @Column(name="CREDIT_TERM")
    private String creditTerm;
    
    @Column(name="DELIVERY_TIMELINE")
    private String deliveryTimeline;
    
    @Column(name="DISCOUNT")
    private int discount;
    
    @Column(name="PO_DATE")
    private Date poDate;
    
    @Column(name="FOOTER_NOTE")
    private String footerNote;
    
    @Column(name="USER_1")
    private String user1;
    
    @Column(name="DATE_1")
    private Date date1;
    
    @Column(name="REMARKS")
    private String remarks;
    
    @Column(name="FRIEGHT_CHARGE")
    private String frieghtCharge;
    
    @OneToOne(cascade ={})
    @JoinColumn(name = "SUPP_CODE",insertable = false, updatable = false)
    private SupplierMaster suppliermaster;
    
    @Column(name="TAX")
    private long tax;
    
    @OneToMany(cascade = {})
    @JoinColumn(name = "PO_NUM", insertable = false, updatable = false)
    private List<ScmPoLineItem> scmpolineitem;
    
    
   
    public List<ScmPoLineItem> getScmpolineitem() {
		return scmpolineitem;
	}

	public void setScmpolineitem(ScmPoLineItem scmpolineitem) {
		this.scmpolineitem = (List<ScmPoLineItem>) scmpolineitem;
	}

	public long getTax() {
		return tax;
	}

	public void setTax(long tax) {
		this.tax = tax;
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
	
    public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public String getFooterNote() {
		return footerNote;
	}

	public void setFooterNote(String footerNote) {
		this.footerNote = footerNote;
	}

	
    public String getFinYear() {
		return finYear;
	}

	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}

	public String getFrieghtCharge() {
		return frieghtCharge;
	}

	public void setFrieghtCharge(String frieghtCharge) {
		this.frieghtCharge = frieghtCharge;
	}

	public ScmPoHdr() {
	super();
    }
    
    public String getId() {
    	return id;
    }

    public void setId(String id) {
    	this.id = id;
    }
 
    

    public String getpoStatus() {
	return poStatus;
    }

    public void setpoStatus(String poStatus) {
	this.poStatus = poStatus;
    }

    public String getsuppCode() {
	return suppCode;
    }

    public void setsuppCode(String suppCode) {
	this.suppCode = suppCode;
    }

    
   

	public String getPoStatus() {
		return poStatus;
	}

	public void setPoStatus(String poStatus) {
		this.poStatus = poStatus;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public int getPoValWoTax() {
		return poValWoTax;
	}

	public void setPoValWoTax(int poValWoTax) {
		this.poValWoTax = poValWoTax;
	}

	public int getPoValueWtTax() {
		return poValWtTax;
	}

	public void setPoValWtTax(int poValWtTax) {
		this.poValWtTax = poValWtTax;
	}

	public Date getModOn() {
		return modOn;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public String getCreditTerm() {
		return creditTerm;
	}

	public void setCreditTerm(String creditTerm) {
		this.creditTerm = creditTerm;
	}

	public String getDeliveryTimeline() {
		return deliveryTimeline;
	}

	public void setDeliveryTimeline(String deliveryTimeline) {
		this.deliveryTimeline = deliveryTimeline;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	
	public SupplierMaster getSuppliermaster() {
		return suppliermaster;
	}

	public void setSuppliermaster(SupplierMaster suppliermaster) {
		this.suppliermaster = suppliermaster;
	}

	 @Override
	    public String toString() {
		return "ScmPoHdr [id=" + id + "]";
	    }

		

   

}

