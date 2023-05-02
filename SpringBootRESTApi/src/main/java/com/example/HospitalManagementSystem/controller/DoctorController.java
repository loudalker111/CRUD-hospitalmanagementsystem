package com.example.HospitalManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HospitalManagementSystem.dao.DoctorDao;
import com.example.HospitalManagementSystem.entities.Doctor;
import com.example.HospitalManagementSystem.services.DoctorService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	
	@GetMapping("/doctors")
	public List<Doctor> getDoctors(){
		return this.doctorService.getDoctors();
	}
	
	@GetMapping("/doctors/{id}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable Long id) {
		return this.doctorService.getDoctor(id);
	}
	
	@PostMapping("/doctors")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		
		return this.doctorService.addDoctor(doctor);
	}
	
	@PutMapping("/doctors/{id}")
	public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
		return this.doctorService.updateDoctor(id, doctor);
	}

}
