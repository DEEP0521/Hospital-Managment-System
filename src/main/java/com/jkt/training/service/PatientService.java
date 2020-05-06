package com.jkt.training.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.training.model.Patient;
import com.jkt.training.repository.PatientRepository;

@Service
@Transactional
public class PatientService {

	@Autowired
	private PatientRepository Prepo;
	
	public List<Patient> listAll(){
		return Prepo.findAll();
	}
	
	public Patient get(Integer Pid) {
		return Prepo.findById(Pid).get();
	}
	
	
}
