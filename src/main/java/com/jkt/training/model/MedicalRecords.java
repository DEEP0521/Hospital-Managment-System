package com.jkt.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MedicalRecords {
	
	@Id
	private int id;
	private String problem;
	private String date_of_examination;
	
	@ManyToOne
	@JoinColumn(name = "pat_id")
	private Patient patient;
	
	public MedicalRecords() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicalRecords(int id, String problem, String date_of_examination) {
		super();
		this.id = id;
		this.problem = problem;
		this.date_of_examination = date_of_examination;
	}

	public MedicalRecords(int id, String problem, String date_of_examination, int p_id) {
		super();
		this.id = id;
		this.problem = problem;
		this.date_of_examination = date_of_examination;
		this.patient = new Patient(p_id,"","","");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "MedicalRecords [id=" + id + ", problem=" + problem + ", date_of_examination=" + date_of_examination
				+ "]";
	}
	
}
