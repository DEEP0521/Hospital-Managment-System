package com.jkt.training.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.training.ExceptionHandler.InternalServer;
import com.jkt.training.ExceptionHandler.NotFoundException;
import com.jkt.training.ExceptionHandler.RecordNotFoundException;
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
	
	//mapping for hospital
	public List<Patient> getAllH_Patients(int p_id){
		List<Patient> patients=new ArrayList<Patient>();
		if(!patients.isEmpty())
		{
			repository.findByHospitalId(p_id).forEach(patients::add);
			return patients;
		}
		else
			throw new RecordNotFoundException();
		
	}
	
	//Patient records with exception
	public List<Patient> getAllpatients(){
		if(repository.findAll().isEmpty())
			throw new RecordNotFoundException();
		else
			return repository.findAll(); 
	}
	
	
	
	//mapping for hospital with exception
	public Optional<Patient> getH_PatientById(int p_id) {
		Optional<Patient> patient=repository.findById(p_id);
		if(!patient.isPresent())
			throw new RecordNotFoundException();
		else
			return repository.findById(p_id);
	}
	
	//Patient records by id with exception
	public Optional<Patient> getPatientById(int p_id) {
		Optional<Patient> patient=repository.findById(p_id);
		if(!patient.isPresent())
			throw new RecordNotFoundException();
		else
			return repository.findById(p_id);
	}
	
	//Patient records addition with exception
	public boolean addPatient(Patient patient) {
		String pid=String.valueOf(patient.getpid());
		 if((!patient.getP_name().equals(null))&&(!patient.getP_address().equals(null))&&(!patient
				 .getP_diagnosis().equals(null))&&(patient.getpid()!=0)&&(!pid.equals(null)))
		 {
			 repository.save(patient);
			 return true;
		 }
		 else
			 return false;
	}
	
	//mapping
	public boolean addH_Patient(Patient patient) {
		String pid=String.valueOf(patient.getpid());
		 if((!patient.getP_name().equals(null))&&(!patient.getP_address().equals(null))&&(!patient
				 .getP_diagnosis().equals(null))&&(patient.getpid()!=0)&&(!pid.equals(null)))
			 {
			 repository.save(patient);
			 return true;
			 }
		 else
			 return false;
	}
	
	public void deletePatient(int p_id) {
		Patient patient=repository.getOne(p_id);
		if(!patient.equals(null))
		{
			repository.delete(patient);
		}
		else
			throw new RecordNotFoundException();
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
	public boolean updateH_Patient(Patient patient) {
		String pid=String.valueOf(patient.getpid());
		 if((!patient.getP_name().equals(null))||(!patient.getP_address().equals(null))||(!patient
				 .getP_diagnosis().equals(null))||(patient.getpid()!=0)||(!pid.equals(null)))
		 {
			 repository.save(patient);
			 return true;
		 }
		 else
			 return false;
	}
	
}
