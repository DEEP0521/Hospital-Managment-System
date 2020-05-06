package com.jkt.training.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

	private int Pid;
	private String Pname,Pdiagnosis,Paddress;
	private int Record_id,Hospital_id;
	
	
	public Patient() {
		
	}


	public Patient(int pid, String pname, String pdiagnosis, String paddress, int record_id, int hospital_id) {
		Pid = pid;
		Pname = pname;
		Pdiagnosis = pdiagnosis;
		Paddress = paddress;
		Record_id = record_id;
		Hospital_id = hospital_id;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPid() {
		return Pid;
	}


	public void setPid(int pid) {
		Pid = pid;
	}


	public String getPname() {
		return Pname;
	}


	public void setPname(String pname) {
		Pname = pname;
	}


	public String getPdiagnosis() {
		return Pdiagnosis;
	}


	public void setPdiagnosis(String pdiagnosis) {
		Pdiagnosis = pdiagnosis;
	}


	public String getPaddress() {
		return Paddress;
	}


	public void setPaddress(String paddress) {
		Paddress = paddress;
	}


	public int getRecord_id() {
		return Record_id;
	}


	public void setRecord_id(int record_id) {
		Record_id = record_id;
	}


	public int getHospital_id() {
		return Hospital_id;
	}


	public void setHospital_id(int hospital_id) {
		Hospital_id = hospital_id;
	}
	
	
}
