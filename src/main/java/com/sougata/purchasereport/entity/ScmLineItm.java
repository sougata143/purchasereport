package com.sougata.purchasereport.entity;


import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SCM_PO_LINE_ITEM")
public class ScmLineItm implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
    
    @Id()
    @Column(name = "LINE_ITEM_NUM")
    private Long id;

    
    @Column(name = "PO_NUM")
    private String poNum;
    
   
    @Column(name = "INDENT_NO")
    private String indentNo;

    @Column(name = "VALUE_WO_TAX")
    private Long valueWoTax;

   
    @Column(name = "VALUE_WT_TAX")
    private Long valueWtTax;
    
    
    @Column(name = "DISCOUNT")
    private Long discount;
 
    private Date startdate;
    
    private Date enddate;
    
    public ScmLineItm() {
	super();
    }
    
    
    public Date getstartdate() {
    	return startdate;
    }

    public void setstartdate(Date startdate) {
    	this.startdate = startdate;
    }
    
    public Date getenddate() {
    	return enddate;
    }

    public void setenddate(Date enddate) {
    	this.enddate = enddate;
    }
    
    public Long getId() {
    	return id;
    }

    public void setId(Long id) {
    	this.id = id;
    }
    

    public String getpoNum() {
	return poNum;
    }

    public void setpoNum(String poNum) {
	this.poNum = poNum;
    }

    public String getindentNo() {
	return indentNo;
    }

    public void setvalueWoTax(Long valueWoTax) {
	this.valueWoTax = valueWoTax;
    }

    public Long getvalueWtTax() {
	return valueWtTax;
    }

    public void setvalueWtTax(Long valueWtTax) {
	this.valueWtTax = valueWtTax;
    }
    
    public Long getdiscount() {
    	return discount;
    }

    public void setdiscount(Long discount) {
    	this.discount = discount;
    }


    
    @Override
    public String toString() {
	return "ScmLineItm [id=" + id + "]";
    }

    

   

}

