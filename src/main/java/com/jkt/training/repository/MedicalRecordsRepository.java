package com.jkt.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jkt.training.model.MedicalRecords;

public interface MedicalRecordsRepository extends JpaRepository<MedicalRecords, Integer> {
	public List<MedicalRecords> findByPatientId(int p_id);
}
