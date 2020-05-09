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
	
	@GetMapping("/patients")
	public List<Patient> getAllpatients(){
		
		return service.getAllpatients();
	}
	
	//mapping with medical patient
	@GetMapping("/hospitals/{h_id}/patients")
	public List<Patient> getAllH_Patients(@PathVariable int h_id){
		
		return service.getAllH_Patients(h_id);
	}
	
	@GetMapping("/patients/{p_id}")
	public Optional<Patient> getPatientById(@PathVariable int p_id) {
		return service.getPatientById(p_id);
	}
	
	//mapping with medical patient
	@GetMapping("/hospitals/{h_id}/patients/{p_id}")
	public Optional<Patient> getH_PatientById(@PathVariable int p_id) {
		return service.getH_PatientById(p_id);
	}
	
	@PostMapping(path = "/patients",consumes = "application/json")
	public String addPatient(@RequestBody Patient patient) {
		service.addPatient(patient);
		return "added";
	}
	
	//mapping with medical patient
	@PostMapping(path = "/hospitals/{h_id}/patients",consumes = "application/json")
	public String addp_patient(@PathVariable int h_id,@RequestBody Patient patient) {
		patient.setHospital(new Hospital(h_id,"",""));
		service.addH_Patient(patient);
		return "added H_patient";
	}
	
	@PutMapping(path = "/patients/{p_id}",consumes = "application/json")
	public String updatePatient(@RequestBody Patient patient,@PathVariable int p_id) {
		service.updatePatient(patient, p_id);
		return "updated";
	}
	
	//mapping with medical patient
	@PutMapping(path = "/hospitals/{h_id}/patients/{p_id}",consumes = "application/json")
	public String updatep_patient(@RequestBody Patient patient,@PathVariable int p_id,@PathVariable int h_id) {
		patient.setHospital(new Hospital(h_id,"",""));
		service.updateH_Patient(patient);
		return "updated p_patient";
	}
	
	@DeleteMapping("/patients/{p_id}")
	public String deletePatient(@PathVariable int p_id) {
		service.deletePatient(p_id);
		return "deleted";
	}
	
	//mapping with medical patient
	@DeleteMapping("/hospitals/{h_id}/patients/{p_id}")
	public String deletep_patient(@PathVariable int p_id) {
		service.deleteH_Patient(p_id);
		return "deleted";
	}
}
