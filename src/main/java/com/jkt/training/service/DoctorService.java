package com.jkt.training.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
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
	
	public List<Doctor> getDoctors()
	{
		return doctorrepo.findAll();
	}
	
	public Optional getdoctor(int d_id)
	{
		return doctorrepo.findById(d_id);
		
	}
	
	public void addDoctor(Doctor doctor) {
		 doctorrepo.save(doctor);
	}

	public void updateDoctor(Doctor doctor,int d_id)
	{
		doctor=doctorrepo.getOne(d_id);
		doctorrepo.save(doctor);
	}
	
	public void deleteDoctor(int d_id)
	{
		Doctor doctor=doctorrepo.getOne(d_id);
		doctorrepo.delete(doctor);
	}
}
