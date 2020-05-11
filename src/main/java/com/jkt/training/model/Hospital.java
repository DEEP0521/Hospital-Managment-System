package com.jkt.training.model;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Hospital {
 @Id
 private int hosp_id;
 private String HBranchName;
 private String HCity;
 public Hospital()
 {
	 super();
 }
 
 public Hospital(int hosp_id, String HBranchName, String HCity)
 {
	 super();
		this.Hosp_id=hosp_id;
		this.HBranchName=HBranchName;
		this.HCity=HCity;	
 }

 public int getHosp_id() {
	 return hosp_id;
  }
  
  public void setHosp_id(int hosp_id) {
	this.hosp_id = hosp_id;
  }
  
  public String getH_branch_name() {
	return h_branch_name;
  }
  
  public void setH_branch_name(String h_branch_name) {
	this.h_branch_name = h_branch_name;
  }
  
  public String getH_city() {
	return h_city;
  }
  
  public void setH_city(String h_city) {
	this.h_city = h_city;
  }
 
@Override
  public String toString() {
	 return "Hospital [hosp_id=" + hosp_id + ", h_branch_name=" + h_branch_name + ", h_city=" + h_city + "]";
  }
}
