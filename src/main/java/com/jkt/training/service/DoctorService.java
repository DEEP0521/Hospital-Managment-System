package com.jkt.training.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jkt.training.ExceptionHandler.RecordNotFoundException;
import com.jkt.training.advice.ServiceException;
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
	public List<Doctor> getAllDoctorsRec(int Id)
	{
		List<Doctor> doctor=new ArrayList<>();
		doctorrepo.findByHospitalId(Id).forEach(doctor::add);
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
	
	public Optional<Doctor> getdoctor(int d_id) throws ServiceException
	{
		
		Optional<Doctor> doctor= doctorrepo.findById(d_id);
		if(!doctor.isPresent())
		{
			throw new ServiceException("Doctor not found: " +d_id, HttpStatus.BAD_REQUEST.value());
		}
		else
			return doctor;
		
	}
	
	public void addDoctor(Doctor doctor) throws ServiceException{
		
		int check=doctor.getD_id();
		if(doctorrepo.existsById(check)==false)
		{
			if(doctor.getD_id()==0||doctor.getDname()==null||doctor.getDname().isEmpty()||doctor.getQualification()==null||doctor.getSalary()==0)
				throw new ServiceException("Fields should not be empty or null", HttpStatus.BAD_REQUEST.value());
			else
				doctorrepo.save(doctor);
		}
		else
			throw new org.hibernate.service.spi.ServiceException("Doctor Already Exists!");
	}
	
	public void updateDoctor(Doctor doctor,int d_id)
	{
		if(doctorrepo.existsById(d_id))
		{
			doctorrepo.save(doctor);
		}
		else
			throw new RecordNotFoundException();
	}	
	
	public void deleteDoctor(int d_id)
	{
		if(doctorrepo.existsById(d_id))
		{
			Doctor doctor=doctorrepo.getOne(d_id);
			doctorrepo.delete(doctor);
		}
		else
			throw new RecordNotFoundException();
		
	}
	
}
