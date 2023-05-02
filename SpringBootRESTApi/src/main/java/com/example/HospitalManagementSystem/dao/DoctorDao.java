package com.example.HospitalManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.HospitalManagementSystem.entities.Doctor;

public interface DoctorDao extends JpaRepository<Doctor, Long>{

}
