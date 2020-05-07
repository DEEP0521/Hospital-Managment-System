package com.jkt.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jkt.training.model.Patient;
import com.jkt.training.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService Pservice;
	
	@GetMapping("/patients") //provides list of all patients
	public List<Patient> list(){
		return Pservice.listAll();
	}
	
	@GetMapping("/patients/{Pid}") //provides the details of selected patient
	public ResponseEntity<Patient> get(@PathVariable Integer Pid){
		try {
			Patient pt=Pservice.get(Pid);
			return new ResponseEntity<Patient>(pt,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "/patient/save")
	public int save(final @RequestBody @Valid Patient pt) {
		Pservice.save(pt);
		return pt.getPid();
	}
}
