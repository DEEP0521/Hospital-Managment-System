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
	@GetMapping("/patients/{Pid}") 
	public ResponseEntity<Patient> PatientId(@PathVariable Integer Pid){
		try {
			Patient pt=Pservice.get(Pid);
			return new ResponseEntity<Patient>(pt,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
	}
	
	//--Adds Patient Records
	@PostMapping(path = "/precord",consumes = "application/json") 
	public String addPatient(@RequestBody Patient pt) {
		Pservice.addrecord(pt);
		return "Patient Record Added!";
	}
	
	//--Deletes Patient's Record by ID
	@DeleteMapping(path = "/pdelete/{Pid}") 
	public String delPatient(@PathVariable int Pid) {
		Pservice.deletePatient(Pid);
		return "Patient Record deleted!";
	}
	
	@PutMapping(path = "/pupdate/{Pid}",consumes = "application/json")
	public String updPatient(@RequestBody Patient pt,@PathVariable int Pid) {
		Pservice.updatePatient(pt, Pid);
		return "Patient Record Updated!";
	}
}
