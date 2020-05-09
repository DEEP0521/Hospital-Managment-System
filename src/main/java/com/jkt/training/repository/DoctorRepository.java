package com.jkt.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jkt.training.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	public	List<Doctor> findByHospitalId(int hosp_id);
}
