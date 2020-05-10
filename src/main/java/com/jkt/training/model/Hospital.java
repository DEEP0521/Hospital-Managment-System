package com.jkt.training.model;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Hospital {
 @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private int hosp_id;
 private String HBranchName;
 private String HCity;
	@OneToMany
 private Doctor doctor;
// private Patient patient;
 public Hospital()
 {
	 super();
 }
 
 public Hospital(int hosp_id, String HBranchName, String HCity,int d_id)
	{
	 super();
		this.hosp_id=hosp_id;
		this.HBranchName=HBranchName;
		this.HCity=HCity;	
		this.doctor=new Doctor(d_id,"","",0);
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
public String getHName() {
	return HName;
}
public void setHName(String hName) {
	HName = hName;
}
public String getHAddress() {
	return HAddress;
}
public void setHAddress(String hAddress) {
	HAddress = hAddress;
}
  public Doctor getDoctor() {
	return doctor;
}

public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}

/*public Patient getPatient() {
	return patient;
}

public void setPatient(Patient patient) {
	this.patient = patient;
}*/
@Override
public String toString() {
	return "Hospital [hosp_id=" + hosp_id + ", HName=" + HName + ", HAddress=" + HAddress
			+ "]";
}
}
