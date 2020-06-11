package com.jkt.training.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Patient {

	@Id
	private int id;
	private String p_name,p_diagnosis,p_address;
	
	@ManyToOne
	private Hospital hospital;
	
	@OneToMany(mappedBy = "patient" ,cascade = CascadeType.ALL)
	private List<MedicalRecords> medicalRecords;
	
	public List<MedicalRecords> getMedicalRecords() {
		return medicalRecords;
	}
	public void setMedicalRecords(List<MedicalRecords> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}
	public Patient(int id, String p_name, String p_diagnosis, String p_address, int h_id) {
		super();
		this.id = id;
		this.p_name = p_name;
		this.p_diagnosis = p_diagnosis;
		this.p_address = p_address;
		this.hospital = new Hospital(h_id,"","");
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Patient(int id, String p_name, String p_diagnosis, String p_address) {
		super();
		this.id = id;
		this.p_name = p_name;
		this.p_diagnosis = p_diagnosis;
		this.p_address = p_address;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", p_name=" + p_name + ", p_diagnosis=" + p_diagnosis + ", p_address=" + p_address
				+ ", hospital=" + hospital + "]";
	}

}
