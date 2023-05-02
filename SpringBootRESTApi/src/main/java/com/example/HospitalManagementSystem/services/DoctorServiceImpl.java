package com.example.HospitalManagementSystem.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.HospitalManagementSystem.dao.DoctorDao;
import com.example.HospitalManagementSystem.entities.Doctor;
import com.example.HospitalManagementSystem.exception.ResourceNotFoundException;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorDao doctorDao;
	
	@Override
	public List<Doctor> getDoctors() {
		return doctorDao.findAll();
	}
	
	@Override
	public ResponseEntity< Doctor> getDoctor(Long doctorId) {
		Doctor doctor =  doctorDao.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id:" + doctorId));		
		return ResponseEntity.ok(doctor);
	}
	
	@Override
	public Doctor addDoctor(Doctor doctor) {
		doctorDao.save(doctor);
		return doctor;
	}
	
	@Override
	public Doctor updateDoctor(Long doctorId, Doctor doctor) {
		Doctor updatedDoctor = doctorDao.findById(doctorId).get();
		updatedDoctor.setName(doctor.getName());
		doctorDao.save(updatedDoctor);

		return updatedDoctor;
	}

}
