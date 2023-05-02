import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { Patient } from './patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  private baseURL = "http://localhost:8080/api";

  constructor(private httpClient:HttpClient) { }

  getPatientsList():Observable<Patient[]>{
    return this.httpClient.get<Patient[]>(`${this.baseURL}/${"patients"}`);
  }

  createPatient(patient : Patient):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/${"patients"}`, patient);
  }

  getPatient(id : number):Observable<Patient>{
    return this.httpClient.get<Patient>(`${this.baseURL}/${"patients"}/${id}`);
  }
}
