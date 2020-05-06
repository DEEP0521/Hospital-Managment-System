package com.jkt.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jkt.training.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
