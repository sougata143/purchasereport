package com.sougata.purchasereport.entity;


import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "SCM_INDENT_LINE_ITEM")
public class ScmIndentLineItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "INDENT_SRL_NO")
    private int id;

    @Column(name = "FIN_YEAR")
    private String finYr;
    
    @OneToOne(cascade = { })
    @JoinColumn(name = "INDENT_NO",insertable = false, updatable = false)
    private ScmIndentHdr scmindenthdr;

   
    @Column(name = "INDENT_NO")
    private String indentNo;
    
    @Column(name = "INDENT_TYPE")
    private String indentType;
    
    @Column(name = "GROUP_CODE")
    private String groupCode;
    
    
    @Column(name = "ITEM_CODE")
    private String itemCode;
    
    @Column(name = "DTL_ITEM_DESC")
    private String dtlItemDsc;
    
    
    @Column(name = "UOM_CODE")
    private String uomCode;
    
    
    @Column(name = "INDENT_QTY")
    private Long indentQty;
    
    @Column(name = "CANCEL_QTY")
    private Long cancelQty;
    
    @Column(name = "DEPT_CODE")
    private String deptCode;
    
    
    @Column(name = "DEL_TERM")
    private String delTerm;
    
    
    @Column(name = "DEL_NO")
    private int delNo;
    
    
    
    @Column(name = "REMARK")
    private String remark;
    
    
    @Column(name = "PO_QTY")
    private Long poQty;
    
    @Column(name = "JOB_NO")
    private String jobNo;
    
    
    @Column(name = "JOB_DATE")
    private Date jobDate;
    
    @Column(name = "ENQUIRY_TAG")
    private String enquiryTag;
    
    
    @Column(name = "IS_ACTIVE")
    private String isActive;
    
    @Column(name = "STOCK_IN_HAND")
    private Long stockInHand;
    
    
    @Column(name = "INDENT_STATUS")
    private String indentStatus;
    
    @Column(name = "APPROVER_LEVEL_FIRST")
    private String approverLevelFirst;
    
    
    @Column(name = "APPROVE_LEVEL_FIRST_DATE")
    private Date approverLevelFirstDate;
    
    @Column(name = "APPROVER_LEVEL_SECOND")
    private String approverLevelSecond;
    
    
    @Column(name = "APPROVE_LEVEL_SECOND_DATE")
    private Date approverLevelSecondDate;
    
    @Column(name = "QUALITY")
    private String quality;
    
    
    @Column(name = "MARKA")
    private String marka;
    
    @Column(name = "ADDITIONAL_REQUIREMENT")
    private String additionalRequirement;
    
    
    
    
    public ScmIndentLineItem() {
	super();
    }

    public int getId() {
	 return id;
    }

    public void setId(int id) {
	 this.id = id;
    }
    
   
    public ScmIndentHdr getScmIndentHdr() {
        return scmindenthdr;
    }

    public void setScmIndentHdr(ScmIndentHdr scmindenthdr) {
        this.scmindenthdr = scmindenthdr;
    }

    public String getfinYr() {
	 return finYr;
    }

    public void setfinYr(String finYr) {
	  this.finYr = finYr;
    }

    public String getindentNo() {
	 return indentNo;
    }

    public void setindentNo(String indentNo) {
	this.indentNo = indentNo;
    }
    
    public String getindentType() {
    	return indentType;
    }

    public void setindentType(String indentType) {
    	this.indentType = indentType;
    }

    public String getgroupCode() {
    	return groupCode;
    }

    public void setgroupCode(String groupCode) {
    	this.groupCode = groupCode;
    }
    
    public String getitemCode() {
	 return itemCode;
    }

    public void setitemCode(String itemCode) {
	 this.itemCode = itemCode;
    }
    
    public String getdtlItemDsc() {
    	return dtlItemDsc;
    }

    public void setdtlItemDsc(String dtlItemDsc) {
    	this.dtlItemDsc = dtlItemDsc;
    }

    public String getuomCode() {
    	return uomCode;
    }

    public void setuomCode(String uomCode) {
    	this.uomCode= uomCode;
    }
    
    public Long getindentQty() {
	 return indentQty;
    }

    public void setindentQty(Long indentQty) {
	 this.indentQty = indentQty;
    }
    
    public Long getcancelQty() {
    	return cancelQty;
    }

    public void setcancelQty(Long cancelQty) {
    	this.cancelQty = cancelQty;
    }

    public String getdeptCode() {
    	return deptCode;
    }

    public void setdeptCode(String deptCode) {
    	this.deptCode = deptCode;
    }

    
    ////////////////////////////////
    
    public String getdelTerm() {
   	 return delTerm;
    }

    public void setdelTerm(String delTerm) {
   	 this.delTerm = delTerm;
    }
       
       public int getdelNo() {
       	return delNo;
       }

       public void setdelNo(int delNo) {
       	this.delNo = delNo;
       }

       public String getremark() {
       	return remark;
       }

       public void setremark(String remark) {
       	this.remark = remark;
       }

  ///////////////////////////////////// 
       
       
   public Long getpoQty() {
	   	 return poQty;
    }

  public void setpoQty(Long poQty) {
   	 this.poQty = poQty;
    }
       
   public String getisActive() {
   	return isActive;
   }

   public void setisActive(String isActive) {
   	this.isActive = isActive;
   }

   public Date getjobDate() {
   	return jobDate;
   }

   public void setjobDate(Date jobDate) {
   	this.jobDate = jobDate;
   }
////////////////////////////////////////
   
   
   public String getenquiryTag() {
	   	 return enquiryTag;
   }

   public void setenquiryTag(String enquiryTag) {
 	 this.enquiryTag = enquiryTag;
   }
     
 public String getjobNo() {
 	return jobNo;
 }

 public void setjobNo(String jobNo) {
 	this.jobNo = jobNo;
 }

 public Long getstockInHand() {
 	return stockInHand;
 }

 public void setstockInHand(Long stockInHand) {
 	this.stockInHand = stockInHand;
 }
 
 
 ////////////////////////////////////////////////////
 
 public String getindentStatus() {
   	 return indentStatus;
}

public void setindentStatus(String indentStatus) {
	 this.indentStatus = indentStatus;
}
 
public String getapproverLevelFirst() {
	return approverLevelFirst;
}

public void setapproverLevelFirst(String approverLevelFirst) {
	this.approverLevelFirst = approverLevelFirst;
}

public Date getapproverLevelFirstDate() {
	return approverLevelFirstDate;
}

public void setapproverLevelFirstDate(Date approverLevelFirstDate) {
	this.approverLevelFirstDate = approverLevelFirstDate;
}


////////////////////////////////////////////////////////

public String getapproverLevelSecond() {
  	 return approverLevelSecond;
}

public void setapproverLevelSecond(String approverLevelSecond) {
	 this.approverLevelSecond = approverLevelSecond;
}

public Date getapproverLevelSecondDate() {
	return approverLevelSecondDate;
}

public void setapproverLevelSecondDate(Date approverLevelSecondDate) {
	this.approverLevelSecondDate = approverLevelSecondDate;
}

public String getquality() {
	return quality;
}

public void setquality(String quality) {
	this.quality = quality;
}


public String getmarka() {
	return marka;
}

public void setmarka(String marka) {
	this.marka = marka;
}

public String getadditionalRequirement() {
	return additionalRequirement;
}

public void setadditionalRequirement(String additionalRequirement) {
	this.additionalRequirement = additionalRequirement;
}


    
    @Override
    public String toString() {
	return "ScmIndentTypeMaster [id=" + id + "]";
    }

    

   

}

