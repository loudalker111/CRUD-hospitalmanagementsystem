package com.example.HospitalManagementSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Doctor {
	
	@Id
	@Column (name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int age;
	private String gender;
	private String specialistFields;
	
	public Doctor(Long id, String name, int age, String gender, String specialistFields) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialistFields = specialistFields;
	}
	public Doctor() {
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpecialistFields() {
		return specialistFields;
	}
	public void setSpecialistFields(String specialistFields) {
		this.specialistFields = specialistFields;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", specialistFields="
				+ specialistFields + "]";
	}
	
	
	
}
