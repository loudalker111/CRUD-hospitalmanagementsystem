import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.css'],
})
export class CreatePatientComponent implements OnInit {
  patient: Patient = new Patient();
  doctors!: Doctor[];

  constructor(
    private doctorService: DoctorService,
    private patientService: PatientService
  ) {}

  ngOnInit(): void {
    this.doctorService.getDoctorsList().subscribe((data) => {
      this.doctors = data;
    });
  }

  savePatient() {
    this.patientService.createPatient(this.patient).subscribe({
      next: () => alert('Patient information added successfully!'),
      error: (e) => console.error(e),
    });
  }
  onSubmit() {
    this.savePatient();
  }

}
