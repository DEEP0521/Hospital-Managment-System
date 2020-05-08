package com.jkt.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jkt.training.model.Patient;
import com.jkt.training.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService Pservice;
	
	//--provides list of all patients
	@GetMapping("/patients") 
	public List<Patient> list(){
		return Pservice.listAll();
	}
	
	//--provides the details of selected patient
	@GetMapping("/patients/{p_id}") 
	public ResponseEntity<Patient> PatientId(@PathVariable Integer p_id){
		try {
			Patient pt=Pservice.get(p_id);
			return new ResponseEntity<Patient>(pt,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
	}
	
	//--Adds Patient Records
	@PostMapping(path = "/patients",consumes = "application/json") 
	public String addPatient(@RequestBody Patient pt) {
		Pservice.addrecord(pt);
		return "Patient Record Added!";
	}
	
	//--Deletes Patient's Record by ID
	@DeleteMapping(path = "/patients/{p_id}") 
	public String delPatient(@PathVariable int p_id) {
		Pservice.deletePatient(p_id);
		return "Patient Record deleted!";
	}
	
	@PutMapping(path = "/patients/{p_id}",consumes = "application/json")
	public String updPatient(@RequestBody Patient pt,@PathVariable int p_id) {
		Pservice.updatePatient(pt, p_id);
		return "Patient Record Updated!";
	}
}
