package com.sougata.purchasereport.dto;

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
public class ScmPoHdrDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;
   
    @Id()
    @Column(name = "PO_NUM")
    private String id;

    @Column(name = "PO_TYPE")
    private String poType;

    @Column(name = "PO_STATUS")
    private String poStatus;

    @Column(name = "SUPP_CODE")
    private String suppCode;
    
   
	@Column(name="PO_VAL_WO_TAX")
    private int poValWoTax;
    
    @Column(name="PO_VAL_WT_TAX")
    private int poValWtTax;
    
    @Column(name="USER_1")
    private String user1;
    
    @Column(name="DATE_1")
    private Date date1;
    
    @Column(name="CREDIT_TERM")
    private String creditTerm;
    
    @Column(name="DELIVERY_TIMELINE")
    private String deliveryTimeline;
    
    @Column(name="DISCOUNT")
    private int discount;
    
    @Column(name="TAX")
    private long tax;
    
    @Column(name="PO_DATE")
    private Date poDate;
    
    @Column(name="REMARKS")
    private String remarks;
   
    
    @OneToOne(cascade ={})
    @JoinColumn(name = "SUPP_CODE",insertable = false, updatable = false)
    private SupplierMasterDTO suppliermaster;
    
    @Column(name="MOD_BY")
    private String modBy;
    
    @Column(name="MOD_ON")
    private Date modOn;
    
    @Column(name="FRIEGHT_CHARGE")
    private String frieghtCharge; 
    
    @OneToMany(cascade = {})
    @JoinColumn(name = "PO_NUM", insertable = false, updatable = false)
    private List<ScmPoLineItemDTO> scmpolineitem;
   
    private Date startDate;
    private Date endDate;
    private String suppName;
    private String ponumlineitem;
    private String indentnolineitem;
    private long valuewotaxlineitem;
    private long valuewttaxlineitem;
    private int discountlineitem;
    private String itemCode;
    private String groupCode;
    private String indentno;
    private String itemdesc;
    private String suppaddress;
    private int totalindent;
    private int approvedindent;
    private int rejectedindent;
    private String suppType;
    private int challanNo;
    private long ammendmentno;
    private Date ammendmentdate;
     
    
    
   
    public long getAmmendmentno() {
		return ammendmentno;
	}

	public void setAmmendmentno(long ammendmentno) {
		this.ammendmentno = ammendmentno;
	}

	public Date getAmmendmentdate() {
		return ammendmentdate;
	}

	public void setAmmendmentdate(Date ammendmentdate) {
		this.ammendmentdate = ammendmentdate;
	}

	public int getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(int challanNo) {
		this.challanNo = challanNo;
	}

	public String getSuppType() {
		return suppType;
	}

	public void setSuppType(String suppType) {
		this.suppType = suppType;
	}

	public int getTotalindent() {
		return totalindent;
	}

	public void setTotalindent(int totalindent) {
		this.totalindent = totalindent;
	}

	public int getApprovedindent() {
		return approvedindent;
	}

	public void setApprovedindent(int approvedindent) {
		this.approvedindent = approvedindent;
	}

	public int getRejectedindent() {
		return rejectedindent;
	}

	public void setRejectedindent(int rejectedindent) {
		this.rejectedindent = rejectedindent;
	}

	public String getFrieghtCharge() {
		return frieghtCharge;
	}

	public void setFrieghtCharge(String frieghtCharge) {
		this.frieghtCharge = frieghtCharge;
	}

	public List<ScmPoLineItemDTO> getScmpolineitem() {
		return scmpolineitem;
	}

	public void setScmpolineitem(List<ScmPoLineItemDTO> scmpolineitemDtoList) {
		this.scmpolineitem = scmpolineitemDtoList;
	}
    
    
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public long getTax() {
		return tax;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getIndentno() {
		return indentno;
	}

	public void setIndentno(String indentno) {
		this.indentno = indentno;
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
   
	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
    
    public String getItemdesc() {
		return itemdesc;
	}

	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}

	public ScmPoHdrDTO() {
	super();
    }
    
    public String getId() {
    	return id;
    }

    public void setId(String id) {
    	this.id = id;
    }
    
    
    public String getSuppaddress() {
		return suppaddress;
	}

	public void setSuppaddress(String suppaddress) {
		this.suppaddress = suppaddress;
	}

	public SupplierMasterDTO getSupplierMaster() {
        return suppliermaster;
    }

    public void setSupplierMaster(SupplierMasterDTO suppliermaster) {
        this.suppliermaster = suppliermaster;
    }
    
    
   
    public String getpoType() {
	return poType;
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

	public void setpoType(String poType) {
	this.poType = poType;
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
    
    
    
    public String getPonumlineitem() {
		return ponumlineitem;
	}

	public void setPonumlineitem(String ponumlineitem) {
		this.ponumlineitem = ponumlineitem;
	}

	public String getIndentnolineitem() {
		return indentnolineitem;
	}

	public void setIndentnolineitem(String indentnolineitem) {
		this.indentnolineitem = indentnolineitem;
	}

	public long getValuewotaxlineitem() {
		return valuewotaxlineitem;
	}

	public void setValuewotaxlineitem(long valuewotaxlineitem) {
		this.valuewotaxlineitem = valuewotaxlineitem;
	}

	public long getValuewttaxlineitem() {
		return valuewttaxlineitem;
	}

	public void setValuewttaxlineitem(long valuewttaxlineitem) {
		this.valuewttaxlineitem = valuewttaxlineitem;
	}

	public int getDiscountlineitem() {
		return discountlineitem;
	}

	public void setDiscountlineitem(int discountlineitem) {
		this.discountlineitem = discountlineitem;
	}

	@Override
    public String toString() {
	return "ScmPoHdr [id=" + id + "]";
    }

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public int getPoValWoTax() {
		return poValWoTax;
	}

	public void setPoValWoTax(int poValWoTax) {
		this.poValWoTax = poValWoTax;
	}

	public int getPoValWtTax() {
		return poValWtTax;
	}

	public void setPoValueWtTax(int poValWtTax) {
		this.poValWtTax = poValWtTax;
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



}

