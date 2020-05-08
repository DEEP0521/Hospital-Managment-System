package com.jkt.training.model;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
//	@GeneratedValue
	private int Pid;
	private String Pname,Pdiagnosis,Paddress;
	
	
	public Patient() {	}


	public Patient(int pid, String pname, String pdiagnosis, String paddress) {
		Pid = pid;
		Pname = pname;
		Pdiagnosis = pdiagnosis;
		Paddress = paddress;
	}

	
	public void setPid(int pid) {
		Pid = pid;
	}


	public void setPname(String pname) {
		Pname = pname;
	}


	public void setPdiagnosis(String pdiagnosis) {
		Pdiagnosis = pdiagnosis;
	}


	public void setPaddress(String paddress) {
		Paddress = paddress;
	}


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
}
