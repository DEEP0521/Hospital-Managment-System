package com.jkt.training.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private int Hosp_id;
 private String HName;
 private String HAddress;
 
 public Hospital(int hosp_id, String haddress, String hname)
    {
		Hosp_id=hosp_id;
		HAddress=haddress;
		HName=hname;
	
    }

 
 public int getHosp_id() {
		return Hosp_id;
	}

	public void setHosp_id(int hosp_id) {
		Hosp_id = hosp_id;
	}

	public String getHAddress() {
		return HAddress;
	}

	public void setHAddress(String hAddress) {
		HAddress = hAddress;
	}

	public String getHName() {
		return HName;
	}

	public void setHName(String hName) {
		HName = hName;
	}
	
}
