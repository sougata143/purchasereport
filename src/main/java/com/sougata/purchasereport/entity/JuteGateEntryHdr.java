package com.sougata.purchasereport.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="JUTE_GATE_ENTRY_HDR")
public class JuteGateEntryHdr {
	@Id
	@Column(name="REC_ID")
	private int recid;
	
	@Column(name="PO_NO")
	private String pono;
	
	@Column(name="CHALLAN_NO")
	private int challanNo;
	
	@Column(name="CHALLAN_DATE")
	private Date challanDate;
	
	@Column(name="VEHICLE_NO")
	private int vehicleNo;
	
	@Column(name="DRIVER_NAME")
	private String driverName;
	
	@Column(name="BROKER_NAME")
	private String brokerName;
	
	@Column(name="BROKER_ADDRESS")
	private String brokerAddress;
	
	@Column(name="IN_DATE")
	private Date inDate;
	
	@OneToOne(cascade = { })
	  @JoinColumn(name= "PO_NO", insertable = false, updatable = false)
	  private JuteGateEntryHdr jutegateentryhdr;
		
		
	    
	    public JuteGateEntryHdr getJutegateentryhdr() {
			return jutegateentryhdr;
		}

		public void setJutegateentryhdr(JuteGateEntryHdr jutegateentryhdr) {
			this.jutegateentryhdr = jutegateentryhdr;
		}

	public int getRecid() {
		return recid;
	}

	public void setRecid(int recid) {
		this.recid = recid;
	}

	public Date getChallanDate() {
		return challanDate;
	}

	public void setChallanDate(Date challanDate) {
		this.challanDate = challanDate;
	}

	public int getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(int vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getBrokerAddress() {
		return brokerAddress;
	}

	public void setBrokerAddress(String brokerAddress) {
		this.brokerAddress = brokerAddress;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public String getPono() {
		return pono;
	}

	public void setPono(String pono) {
		this.pono = pono;
	}

	public int getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(int challanNo) {
		this.challanNo = challanNo;
	}
	
	

}
