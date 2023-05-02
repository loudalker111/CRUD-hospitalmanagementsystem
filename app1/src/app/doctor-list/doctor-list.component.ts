import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';
@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css'],
})
export class DoctorListComponent implements OnInit {
  doctors!: Doctor[];
  results!: Doctor[];
  size!: number;
  selectId!: number;
  constructor(private doctorService: DoctorService) {}

  ngOnInit(): void {
    this.doctorService.getDoctorsList().subscribe(data =>{
      this.size = data.length;
      this.doctors = data;
      this.results = data;
    })
  }
  onSelect() {
    this.doctorService.getDoctor(this.selectId).subscribe({
      next: (data) => {
        this.results = [data];
      },
      error: (error) => {
        if (error.status == 404 || error.status == 400) {
          console.log(error)
        }
      },
    });
  }
    
}
