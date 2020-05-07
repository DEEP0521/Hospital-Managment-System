package com.jkt.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicalRecords {
	
	@Id
	private int r_id;
	private String problem;
	private String date_of_examination;
	//private Patient patient;
	
	public MedicalRecords() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicalRecords(int r_id, String problem, String date_of_examination) {
		super();
		this.r_id = r_id;
		this.problem = problem;
		this.date_of_examination = date_of_examination;
	}

//	public MedicalRecords(int r_id, String problem, String date_of_examination, Patient patient) {
//		super();
//		this.r_id = r_id;
//		this.problem = problem;
//		this.date_of_examination = date_of_examination;
//		this.patient = patient;
//	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getDate_of_examination() {
		return date_of_examination;
	}

	public void setDate_of_examination(String date_of_examination) {
		this.date_of_examination = date_of_examination;
	}

//	public Patient getPatient() {
//		return patient;
//	}
//
//	public void setPatient(Patient patient) {
//		this.patient = patient;
//	}

	@Override
	public String toString() {
		return "MedicalRecords [r_id=" + r_id + ", problem=" + problem + ", date_of_examination=" + date_of_examination
				+ "]";
	}
	
}
