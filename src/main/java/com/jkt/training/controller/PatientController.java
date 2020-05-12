package com.jkt.training.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jkt.training.model.Hospital;
import com.jkt.training.model.Patient;
import com.jkt.training.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService service;
	
	//Patient records with exception handling
	@GetMapping("/patients")
	public List<Patient> getAllpatients(){
		
		return service.getAllpatients();
	}
	
	//mapping with patient with exception handling
	@GetMapping("/hospitals/{h_id}/patients")
	public List<Patient> getAllPatients(@PathVariable int h_id){
		
		return service.getAllH_Patients(h_id);
	}
		
	//Patient records using id with exception handling
	@GetMapping("/patients/{p_id}")
	public Optional<Patient> getPatientById(@PathVariable int p_id) {
		return service.getPatientById(p_id);
	}
	
	//mapping with patient with exception handling
	@GetMapping("/hospitals/{h_id}/patients/{p_id}")
	public Optional<Patient> getH_PatientById(@PathVariable int p_id) {
		return service.getPatientById(p_id);
	}
	
	//Patient records Addition with exception handling
	@PostMapping(path = "/patients",consumes = "application/json")
	public String addPatient(@RequestBody Patient patient) {
		boolean b=service.addPatient(patient);
		System.out.println("Patient"+b);
		if(b==true)
			return "Patient Record Added!";
		else
			return "Unsucessful record addition!";
	}
	
	//mapping with patient with exception handling
	@PostMapping(path = "/hospitals/{h_id}/patients",consumes = "application/json")
	public String addp_patient(@PathVariable int h_id,@RequestBody Patient patient) {
		patient.setHospital(new Hospital(h_id,"",""));
		boolean b=service.addPatient(patient);
		System.out.println("Hospital Patient"+b);
		if(b==true)
			return "Patient Record Added!";
		else
			return "Unsucessful record addition!";
	}
	
	
	@PutMapping(path = "/patients/{p_id}",consumes = "application/json")
	public String updatePatient(@RequestBody Patient patient,@PathVariable int p_id) {
		service.updatePatient(patient, p_id);
		return "Updated";
	}
	
	//mapping with patient
	@PutMapping(path = "/hospitals/{h_id}/patients/{p_id}",consumes = "application/json")
	public String updatep_patient(@RequestBody Patient patient,@PathVariable int h_id,@PathVariable int p_id) {
		patient.setHospital(new Hospital(h_id,"",""));
		service.updateH_Patient(patient,h_id,p_id);
		return "Patient Record Updated!";
	}
	
	//Patient Records deletion with exception
	@DeleteMapping("/patients/{p_id}")
	public String deletePatient(@PathVariable int p_id) {
		service.deletePatient(p_id);
		return "deleted";
	}
	
	//mapping with patient
	@DeleteMapping("/hospitals/{h_id}/patients/{p_id}")
	public String deletep_patient(@PathVariable int p_id) {
		service.deletePatient(p_id);
		return "deleted";
	}
	
}
