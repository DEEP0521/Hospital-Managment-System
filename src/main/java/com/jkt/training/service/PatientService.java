package com.jkt.training.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.training.model.Patient;
import com.jkt.training.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repository;
	
	@PostConstruct
	public void initPatients() {
		repository.saveAll(new ArrayList<Patient>(Arrays.asList(new Patient(113,"Katie Taylor","Back Pain","London"),
															   new Patient(111,"Katie singh","Flu","UAE"),
															   new Patient(112,"Peter Smith","Heah Ache","UK"))));
	}
	//mapping
	public List<Patient> getAllH_Patients(int p_id){
		List<Patient> patients=new ArrayList<Patient>();
		repository.findByHospitalId(p_id)
		.forEach(patients::add);
		return patients;
	}
	
	public List<Patient> getAllpatients(){
		return repository.findAll(); 
	}
	
	//mapping
	public Optional<Patient> getH_PatientById(int p_id) {
		return repository.findById(p_id);
	}
	
	public Optional<Patient> getPatientById(int p_id) {
		return repository.findById(p_id);
	}
	
	public void addPatient(Patient patient) {
		 repository.save(patient);
	}
	
	//mapping
	public void addH_Patient(Patient patient) {
		 repository.save(patient);
	}
	
	public void deletePatient(int p_id) {
		Patient patient=repository.getOne(p_id);
		repository.delete(patient);
	}
	
	//mapping
	public void deleteH_Patient(int p_id) {
		Patient patient=repository.getOne(p_id);
		repository.delete(patient);
	}
	
	public void updatePatient(Patient patient,int p_id) {
		repository.save(patient);
	}
	
	//mapping
	public void updateH_Patient(Patient patient) {
		repository.save(patient);
	}

}
