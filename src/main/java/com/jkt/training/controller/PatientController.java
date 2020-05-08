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
	
	
	//working
	@GetMapping("/patients") //provides list of all patients
	public List<Patient> list(){
		return Pservice.listAll();
	}
	
	
	//working
	@GetMapping("/patients/{Pid}") //provides the details of selected patient
	public ResponseEntity<Patient> get(@PathVariable Integer Pid){
		try {
			Patient pt=Pservice.get(Pid);
			return new ResponseEntity<Patient>(pt,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = "/precord",consumes = "application/json")
	public void save(@RequestBody Patient pt) {
		Pservice.addrecord(pt);
	}
	
	@DeleteMapping(path = "/pdelete/{Pid}")
	public void deleteP(@PathVariable int Pid) {
		Pservice.delete(Pid);
	}
	
	@PutMapping(path = "/pupdate/{Pid}",consumes = "application/json")
	public void updateP(@RequestBody Patient pt,@PathVariable int Pid) {
		Pservice.update(pt,Pid);
	}
}
