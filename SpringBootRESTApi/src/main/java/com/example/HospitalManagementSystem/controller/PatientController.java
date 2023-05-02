package com.example.HospitalManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HospitalManagementSystem.entities.Patient;
import com.example.HospitalManagementSystem.services.PatientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class PatientController {
	
	@Autowired
	private PatientService patientService;

	
	@GetMapping("/patients")
	public List<Patient> getPatients(){
		return this.patientService.getPatients();
	}
	
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
		return this.patientService.getPatient(id);
	}
	
	@PostMapping("/patients")
	public Patient addPatient(@RequestBody Patient patient) {
		
		return this.patientService.addPatient(patient);
	}
	
	@PutMapping("/patients/{id}")
	public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
		return this.patientService.updatePatient(id, patient);
	}

}
