package com.jkt.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.training.model.Patient;
import com.jkt.training.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository Prepo;
	
	public List<Patient> listAll(){ 
		final List<Patient> patient=new ArrayList<>();
		Prepo.findAll().forEach(pt->patient.add(pt));
		return patient;
	}
	
	public Patient get(Integer Pid) {
		return Prepo.findById(Pid).get();
	}
	
	public void save(final Patient pt) {
		Prepo.save(pt);
	}
}
