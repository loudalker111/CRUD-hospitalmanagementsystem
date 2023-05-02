import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-create-doctor',
  templateUrl: './create-doctor.component.html',
  styleUrls: ['./create-doctor.component.css'],
})
export class CreateDoctorComponent implements OnInit {
  doctor: Doctor = new Doctor();
  constructor(private doctorService: DoctorService) {}

  ngOnInit(): void {}
  saveDoctor() {
    this.doctorService.createDoctor(this.doctor).subscribe({
      next: () => alert('Doctor information added successfully!'),
      error: (e) => console.error(e),
    });
  }
  onSubmit() {
    this.saveDoctor();
  }
}
