package com.jkt.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jkt.training.model.*;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	public List<Patient> findByHospitalId(int h_id);
}
