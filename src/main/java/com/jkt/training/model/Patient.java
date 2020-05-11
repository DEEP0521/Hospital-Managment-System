package com.jkt.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Patient {

	@Id
	private int pid;
	private String p_name,p_diagnosis,p_address;
	
	@ManyToOne
	private Hospital hospital;
	
	public Patient() {
		super();
	}
	
	public Patient(int pid, String p_name, String p_diagnosis, String p_address, int h_pid) {
		super();
		this.pid = pid;
		this.p_name = p_name;
		this.p_diagnosis = p_diagnosis;
		this.p_address = p_address;
		this.hospital = new Hospital(h_pid,"","");
	}
	public Patient(int pid, String p_name, String p_diagnosis, String p_address) {
		super();
		this.pid = pid;
		this.p_name = p_name;
		this.p_diagnosis = p_diagnosis;
		this.p_address = p_address;
	}
	
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	public int getpid() {
		return pid;
	}
	public void setpid(int pid) {
		this.pid = pid;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_diagnosis() {
		return p_diagnosis;
	}
	public void setP_diagnosis(String p_diagnosis) {
		this.p_diagnosis = p_diagnosis;
	}
	public String getP_address() {
		return p_address;
	}
	public void setP_address(String p_address) {
		this.p_address = p_address;
	}
	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", p_name=" + p_name + ", p_diagnosis=" + p_diagnosis + ", p_address=" + p_address
				+ ", hospital=" + hospital + "]";
	}

}
