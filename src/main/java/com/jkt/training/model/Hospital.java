package com.jkt.training.model;
import javax.persistence.Id;

import javax.persistence.Entity;

@Entity
public class Hospital {
 @Id
 private int id;
 private String HBranchName;
 private String HCity;
 
 
 
 public Hospital() {
		super();
	}
 
 public Hospital(int id, String hBranchName, String hCity) {
		super();
		this.id = id;
		HBranchName = hBranchName;
		HCity = hCity;
 }

 public int getId() {
	return id;
}

 public void setId(int id) {
	this.id = id;
}

 public String getHBranchName() {
	return HBranchName;
}

 public void setHBranchName(String hBranchName) {
	HBranchName = hBranchName;
}

 public String getHCity() {
	return HCity;
}

 public void setHCity(String hCity) {
	HCity = hCity;
}


@Override
public String toString() {
	return "Hospital [id=" + id + ", HBranchName=" + HBranchName + ", HCity=" + HCity + "]";
}	
	
}

 
