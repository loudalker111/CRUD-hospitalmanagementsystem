package com.example.HospitalManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HospitalManagementSystem.entities.Patient;

public interface PatientDao extends JpaRepository<Patient, Long>{

}
