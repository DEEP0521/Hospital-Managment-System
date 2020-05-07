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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.jkt.training.model.Doctor;
import com.jkt.training.service.DoctorService;


@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorservice;
	
	@GetMapping("/doctors")
	public List<Doctor> getdoctors()
	{
		return doctorservice.getDoctors();
	}
	
	@GetMapping("/doctors/{d_id}")
	public Optional<Doctor> getDoctorById(@PathVariable int d_id)
	{
		return doctorservice.getdoctor(d_id);
	}
	
	@PostMapping(path="/doctors",consumes="application/json")
	public String addDoctor(@RequestBody Doctor doctor)
	{
		doctorservice.addDoctor(doctor);
		return "added";
	}
	
	
	@PutMapping(path = "/doctors/{d_id}",consumes = "application/json")
	public String updateDoctor(@RequestBody Doctor doctor,@PathVariable int d_id) {
		doctorservice.updateDoctor(doctor, d_id);
		return "updated";
	}
	
	@DeleteMapping("/doctore/{d_id}")
	public String deleteDoctor(@RequestBody int d_id)
	{
		doctorservice.deleteDoctor(d_id);
		return "deleted";
	}
	
}
