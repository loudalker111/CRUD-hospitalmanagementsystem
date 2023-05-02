package com.example.HospitalManagementSystem.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.HospitalManagementSystem.entities.Doctor;

public interface DoctorService {
	public List<Doctor> getDoctors();
	public ResponseEntity<Doctor> getDoctor(Long doctorId);
	public Doctor addDoctor(Doctor doctor);
	public Doctor updateDoctor(Long doctorId, Doctor doctor);}
