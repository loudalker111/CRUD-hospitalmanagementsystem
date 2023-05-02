import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css'],
})
export class PatientListComponent implements OnInit {
  patients!: Patient[];
  size!: number;
  searchText!: number;
  constructor(private patientService: PatientService) {}

  ngOnInit(): void {
    this.patientService.getPatientsList().subscribe((data) => {
      this.size = data.length;
      this.patients = data;
    });
  }

  onSearch() {
    this.patientService.getPatient(this.searchText).subscribe({
      next: (data) => {
        this.size = 1;
        this.patients = [data];
      },
      error: (error) => {
        if (error.status == 404 || error.status == 400) {
          this.size = 0;
        }
      },
    });
  }
}
