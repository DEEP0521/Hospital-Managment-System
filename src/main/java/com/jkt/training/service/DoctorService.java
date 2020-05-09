package com.jkt.training.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.training.model.Doctor;
import com.jkt.training.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository doctorrepo;
	
	@PostConstruct
	public void initdoctors()
	{
		doctorrepo.saveAll(Stream.of(new Doctor(101,"DR Awasthi","MBBS",50000),new Doctor(102,"DR Kabir","BDS",40000)).collect(Collectors.toList()));
	}
	
	//doctor-hospital mapping
	public List<Doctor> getAllDoctorsRec(int hosp_id)
	{
		List<Doctor> doctor=new ArrayList<>();
		doctorrepo.findByHospitalId(hosp_id).forEach(doctor::add);
		return doctor;
	}
	
	//mapping
	public Optional<Doctor> getH_recordById(int d_id)
	{
		return doctorrepo.findById(d_id);
	}
	
	
	
	
	public List<Doctor> getDoctors()
	{
		return doctorrepo.findAll();
	}
	
	public Optional<Doctor> getdoctor(int d_id)
	{
		return doctorrepo.findById(d_id);
		
	}
	
	public void addDoctor(Doctor doctor) {
		 doctorrepo.save(doctor);
	}
	
	
	//mapping
	public void addH_Record(Doctor doctor)
	{
		doctorrepo.save(doctor);
	}

	public void updateDoctor(Doctor doctor,int d_id)
	{
		
		doctorrepo.save(doctor);
	}
	
	
	//mapping
	public void updateH_Record(Doctor doctor)
	{
		doctorrepo.save(doctor);
	}
	
	
	public void deleteDoctor(int d_id)
	{
	Doctor	doctor=doctorrepo.getOne(d_id);
		doctorrepo.delete(doctor);
	}
	
	//mapping
	public void deleteH_Record(int d_id)
	{
		Doctor doctor=doctorrepo.getOne(d_id);
		doctorrepo.delete(doctor);
	}
}
