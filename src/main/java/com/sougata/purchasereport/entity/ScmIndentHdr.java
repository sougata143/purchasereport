package com.sougata.purchasereport.entity;


import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
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
@Table(name = "SCM_INDENT_HDR")
public class ScmIndentHdr implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "INDENT_NO")
    private String id;

    @Column(name = "FIN_YEAR")
    private String finYr;

    @OneToMany(cascade = {})
	@JoinColumn(name = "INDENT_NO")
    private List<ScmIndentLineItem> scmindentlineitem;
    

    @Column(name = "INDENT_TYPE")
    private String indentType;
    
    
    @Column(name = "INDENT_DATE")
    private Date indentDate;
    
    
    @Column(name = "YYMM")
    private String yymm;
    
    @Column(name = "MILL_CODE")
    private String millCode;
    
    
    @Column(name = "PRINT_TAG")
    private String printTag;
    
    
    @Column(name = "IS_ACTIVE")
    private String isActive;
    
    
    @Column(name = "USER_1")
    private String user1;
    
    
    @Column(name = "CREATE_DATE")
    private Date createDate;
    
 
    
    @Column(name = "INDENT_STATUS")
    private String indentStatus;
    
    @Column(name = "MOD_BY")
    private String  modBy;
    
    
    @Column(name = "MOD_ON")
    private Date modOn;
    
    
    @Column(name = "APPROVER_LEVEL_FIRST")
    private String approverLevelFirst;
    
    
    @Column(name = "APPROVE_LEVEL_FIRST_DATE")
    private Date approverLevelFirstDate;
    
    
    @Column(name = "APPROVER_LEVEL_SECOND")
    private String approverLevelSecond;
    
    
    @Column(name = "APPROVE_LEVEL_SECOND_DATE")
    private Date approverLevelSecondDate;
    
    @Column(name = "MUKAM")
    private String mukam;
    
    
    @Column(name = "VEHICLE_TYPE_ID")
    private Long vehicleTypId;
    
    
    @Column(name = "VEHICLE_QUANTITY")
    private Long vehicleQuantity;
    
    public ScmIndentHdr() {
	super();
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }
    
    public List<ScmIndentLineItem> getScmIndentLineItem() {
    	return scmindentlineitem;
    }

    public void setScmIndentLineItem(List<ScmIndentLineItem> scmindentlineitem) {
    	this.scmindentlineitem = scmindentlineitem;
    }

    public String getfinYr() {
	return finYr;
    }

    public void setfinYr(String finYr) {
	this.finYr = finYr;
    }

    public String getindentType() {
	return indentType;
    }

    public void setindentType(String indentType) {
	this.indentType = indentType;
    }

    
    
    public Date getindentDate() {
    	return indentDate;
    }

    public void setindentDate(Date indentDate) {
    	this.indentDate = indentDate;
    }
    
    public String getyymm() {
    	return yymm;
    }

    public void setyymm(String yymm) {
    	this.yymm = yymm;
    }
    
    
    public String getmillCode() {
    	return millCode;
    }

    public void setmillCode(String millCode) {
    	this.millCode = millCode;
    }
    
    public String getprintTag() {
    	return printTag;
    }

    public void setprintTag(String printTag) {
    	this.printTag = printTag;
    }
    
    public String getisActive() {
    	return isActive;
    }

    public void setisActive(String isActive) {
    	this.isActive = isActive;
    }
    
    
    public String getuser1() {
    	return user1;
    }

    public void setuser1(String user1) {
    	this.user1 = user1;
    }
    
    
    
    public Date getcreateDate() {
    	return createDate;
    }

    public void setcreateDate(Date createDate) {
    	this.createDate = createDate;
    }
    
    
    public String getindentStatus() {
    	return indentStatus;
    }

    public void setindentStatus(String indentStatus) {
    	this.indentStatus = indentStatus;
    }
    
    public String getmodBy() {
    	return modBy;
    }

    public void setmodBy(String modBy) {
    	this.modBy = modBy;
    }
    
    
    public Date getmodOn() {
    	return  modOn;
    }

    public void setmodOn(Date modOn) {
    	this.modOn=  modOn;
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
    
    
    public String getmukam() {
    	return mukam;
    }

    public void setmukam(String mukam) {
    	this.mukam = mukam;
    }
    
    public Long getvehicleTypId() {
    	return vehicleTypId;
    }

    public void setvehicleTypId(Long vehicleTypId) {
    	this.vehicleTypId = vehicleTypId;
    }
    
    public Long getvehicleQuantity() {
    	return vehicleQuantity;
    }

    public void setvehicleQuantity(Long vehicleQuantity) {
    	this.vehicleQuantity = vehicleQuantity;
    }
    
    @Override
    public String toString() {
	return "ScmIndentTypeMaster [id=" + id + "]";
    }

    

   

}

