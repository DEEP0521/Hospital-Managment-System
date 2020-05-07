package com.jkt.training.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue
	private int Pid;
	private String Pname,Pdiagnosis,Paddress;
	private MedicalRecords records;
	private Hospital hospital;
	
	public Patient() {	}

public Patient(int pid, String pname, String pdiagnosis, String paddress, MedicalRecords records,
			Hospital hospital) {
		super();
		Pid = pid;
		Pname = pname;
		Pdiagnosis = pdiagnosis;
		Paddress = paddress;
		this.records = records;
		this.hospital = hospital;
	}


public Patient(int pid, String pname, String pdiagnosis, String paddress) {
		super();
		Pid = pid;
		Pname = pname;
		Pdiagnosis = pdiagnosis;
		Paddress = paddress;
	}

public MedicalRecords getRecords() {
	return records;
}


public void setRecords(MedicalRecords records) {
	this.records = records;
}


public Hospital getHospital() {
	return hospital;
}


public void setHospital(Hospital hospital) {
	this.hospital = hospital;
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
	
	@Override
	public String toString() {
		return "Patient [Pid=" + Pid + ", Pname=" + Pname + ", Pdiagnosis=" + Pdiagnosis + ", Paddress=" + Paddress
			+ "]";
	}

}