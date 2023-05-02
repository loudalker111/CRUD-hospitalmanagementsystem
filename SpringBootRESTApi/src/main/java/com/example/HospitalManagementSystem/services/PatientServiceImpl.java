package com.example.HospitalManagementSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.HospitalManagementSystem.dao.PatientDao;
import com.example.HospitalManagementSystem.entities.Patient;
import com.example.HospitalManagementSystem.exception.ResourceNotFoundException;

@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
	private PatientDao patientDao;
	
	@Override
	public List<Patient> getPatients() {
		return patientDao.findAll();
	}

	@Override
	public ResponseEntity<Patient> getPatient(Long patientId) {
		Patient patient =  patientDao.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id:" + patientId));		
		return ResponseEntity.ok(patient);
	}
	@Override
	public Patient addPatient(Patient patient) {
		patientDao.save(patient);
		return patient;
	}

	@Override
	public Patient updatePatient(Long patientId, Patient patient) {
		Patient updatedPatient = patientDao.findById(patientId).get();
		updatedPatient.setPrescription(patient.getPrescription());
		patientDao.save(updatedPatient);
		return updatedPatient;
	}

}
