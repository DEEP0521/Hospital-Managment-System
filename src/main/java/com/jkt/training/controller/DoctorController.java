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

import com.jkt.training.advice.ServiceException;
import com.jkt.training.model.Doctor;
import com.jkt.training.model.Hospital;
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
	
	//mapping with hospital
	@GetMapping("hospitals/{hosp_id}/doctors")
	public List<Doctor> getAllDoctorByHID(@PathVariable int hosp_id)
	{
		return doctorservice.getAllDoctorsRec(hosp_id);
	}
	
	@GetMapping("/doctors/{d_id}")
	public Optional<Doctor> getDoctorById(@PathVariable int d_id) throws ServiceException
	{
		return doctorservice.getdoctor(d_id);
	}
	
	//mapping
	@GetMapping("hospitals/{hosp_id}/doctors/{d_id}")
	public Optional<Doctor> getH_RecordById(@PathVariable int d_id)
	{
		return doctorservice.getH_recordById(d_id);
	}
	
	@PostMapping(path="/doctors",consumes="application/json")
	public String addDoctor(@RequestBody Doctor doctor) throws ServiceException
	{
		doctorservice.addDoctor(doctor);
		return "Sucessfull Record Addition";
	}
	
	//mapping
	@PostMapping(path = "/hospitals/{hosp_id}/doctors",consumes = "application/json")
	public String addh_Record(@PathVariable int hosp_id,@RequestBody Doctor doctor) throws ServiceException
	{
		doctor.setHospital(new Hospital(hosp_id,"",""));
		doctorservice.addDoctor(doctor);
		return "Sucessfull Record Addition";
	}
	
	
	@PutMapping(path = "/doctors/{d_id}",consumes = "application/json")
	public String updateDoctor(@RequestBody Doctor doctor,@PathVariable int d_id) {
		
		doctorservice.updateDoctor(doctor, d_id);
		return "Updated Doctor Record!";
	}
	
	//converting json format into java objeect(@RB Doctor doctor)
	//mapping
	@PutMapping(path = "/hospitals/{hosp_id}/doctors/{d_id}",consumes = "application/json")
	public String updateh_Record(@RequestBody Doctor doctor,@PathVariable int hosp_id,@PathVariable int d_id) {
		doctor.setHospital(new Hospital(hosp_id,"",""));
		doctorservice.updateDoctor(doctor, d_id);
		return "Updated Doctor Record!";
	}
	
	
	@DeleteMapping("/doctors/{d_id}")
	public String deleteDoctor(@PathVariable int d_id) 
	{
		doctorservice.deleteDoctor(d_id);
		return "Doctor Record deleted!";
	}
	
	//mapping
	@DeleteMapping("/hospitals/{hosp_id}/doctors/{d_id}")
	public String deleteH_Record(@PathVariable int d_id)
	{
		doctorservice.deleteDoctor(d_id);
		return "Doctor Record deleted!";		
	}
	
}