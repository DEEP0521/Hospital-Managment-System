package com.jkt.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jkt.training.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    public List findByDrId(int d_Id);
}
