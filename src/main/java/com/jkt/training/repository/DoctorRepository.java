package com.jkt.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jkt.training.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
