import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateDoctorComponent } from './create-doctor/create-doctor.component';
import { CreatePatientComponent } from './create-patient/create-patient.component';
import { DoctorListComponent } from './doctor-list/doctor-list.component';
import { HomeComponent } from './home/home.component';
import { PatientListComponent } from './patient-list/patient-list.component';


const routes: Routes = [
  { path: 'doctors', component: DoctorListComponent },
  { path: 'patients', component: PatientListComponent },
  { path: '', component: HomeComponent },
  { path: 'createDoctor', component: CreateDoctorComponent },
  { path: 'createPatient', component: CreatePatientComponent },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }