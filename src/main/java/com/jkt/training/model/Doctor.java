package com.jkt.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

@Entity
public class Doctor {

	@Id
    private int id;
	private String dname;
	private String qualification;
	private int salary;
	
	@ManyToOne
	private Hospital hospital;
	
	
	
	public Doctor(int id, String dname, String qualification, int salary, int hosp_id) {
		super();
		this.id = id;
		this.dname = dname;
		this.qualification = qualification;
		this.salary = salary;
		this.hospital = new Hospital(hosp_id,"","");
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(int id, String dname, String qualification, int salary) {
		super();
		this.id = id;
		this.dname = dname;
		this.qualification = qualification;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", dname=" + dname + ", qualification=" + qualification + ", salary=" + salary
				+ "]";
	}
}
