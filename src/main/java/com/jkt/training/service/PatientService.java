package com.jkt.training.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.training.model.Patient;
import com.jkt.training.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository Prepo;
	
	@PostConstruct
	public void SetRecords() {
		Prepo.saveAll(Stream.of(new Patient(112,"Peter Smith","Heah Ache","UK"),
				new Patient(113,"Katie Taylor","Back Pain","London")).collect(Collectors.toList()));
	}
	
	//--Presents All records
	public List<Patient> listAll(){ 
		final List<Patient> patient=new ArrayList<>();
		Prepo.findAll().forEach(pt->patient.add(pt));
		return patient;
	}
	
	//--Presents record by specified id
	public Patient get(Integer Pid) {
		return Prepo.findById(Pid).get();
	}
	
	//--Adds new Patient Record
	public void addrecord(Patient pt) {
		Prepo.save(pt);
	}
	
	//--Deletes Record
	public void deletePatient(int Pid) {
		Prepo.deleteById(Pid);  //For CrudRepository
	}
	
	//--Update Record
	public void updatePatient(Patient pt,Integer Pid) {
		Prepo.save(pt);
	}
}
