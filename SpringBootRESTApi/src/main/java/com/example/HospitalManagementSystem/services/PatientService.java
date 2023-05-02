package com.example.HospitalManagementSystem.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.HospitalManagementSystem.entities.Patient;

public interface PatientService {
	public List<Patient> getPatients();

	public ResponseEntity<Patient> getPatient(Long patientId);

	public Patient addPatient(Patient patient);

	public Patient updatePatient(Long patientId, Patient patient);
}
