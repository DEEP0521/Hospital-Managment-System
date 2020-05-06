package com.jkt.training.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue
	private int Pid;
	private String Pname,Pdiagnosis,Paddress;
	private int Record_id,Hospital_id;
	
	
	public Patient() {	}


	public Patient(int pid, String pname, String pdiagnosis, String paddress, int record_id, int hospital_id) {
		Pid = pid;
		Pname = pname;
		Pdiagnosis = pdiagnosis;
		Paddress = paddress;
		Record_id = record_id;
		Hospital_id = hospital_id;
	}

//Getters
	public int getPid() {
		return Pid;
	}

	public String getPname() {
		return Pname;
	}

	public String getPdiagnosis() {
		return Pdiagnosis;
	}

	public String getPaddress() {
		return Paddress;
	}

	public int getRecord_id() {
		return Record_id;
	}

	public int getHospital_id() {
		return Hospital_id;
	}

}
