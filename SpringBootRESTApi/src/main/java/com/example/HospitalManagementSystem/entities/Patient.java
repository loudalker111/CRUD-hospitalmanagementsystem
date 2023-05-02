package com.example.HospitalManagementSystem.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Patient {
	@Id
	@Column (name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String visitedDoctor;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(nullable = false)
	private Date dateOfVisit;
	
	@PrePersist
	private void onCreate() {
		dateOfVisit = new Date();
	}
	
	private String prescription;

	public Patient(Long id, String name, String visitedDoctor, Date dateOfVisit, String prescription) {
		super();
		this.id = id;
		this.name = name;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
		this.prescription = prescription;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVisitedDoctor() {
		return visitedDoctor;
	}

	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", visitedDoctor=" + visitedDoctor + ", dateOfVisit="
				+ dateOfVisit + ", prescription=" + prescription + "]";
	}
	
}
