package com.sougata.purchasereport.dto;

import java.sql.Date;

public class IndentDateDTO {
  private Date startDate;
    
  private Date endDate;
    
    public IndentDateDTO() {
    	super();
        }
        
        public Date getstartdate() {
        	return startDate;
        }

        public void setstartdate(Date startDate) {
    	 this.startDate = startDate;
        }
        
        
        public Date getenddate() {
        	return endDate;
        }

        public void setenddate(Date endDate) {
    	 this.endDate = startDate;
        }
        
        
    
   

}
