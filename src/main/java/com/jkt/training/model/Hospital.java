package com.jkt.training.model;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Hospital {
 
 @Id
 private int id;
 private String h_branch_name;
 private String h_city;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getH_branch_name() {
	return h_branch_name;
}
public void setH_branch_name(String h_branch_name) {
	this.h_branch_name = h_branch_name;
}
public String getH_city() {
	return h_city;
}
public void setH_city(String h_city) {
	this.h_city = h_city;
}
public Hospital(int id, String h_branch_name, String h_city) {
	super();
	this.id = id;
	this.h_branch_name = h_branch_name;
	this.h_city = h_city;
}
public Hospital() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Hospital [id=" + id + ", h_branch_name=" + h_branch_name + ", h_city=" + h_city + "]";
}
 
}
 
 
