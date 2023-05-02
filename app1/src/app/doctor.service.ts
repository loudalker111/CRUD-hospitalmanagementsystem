import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { observableToBeFn } from 'rxjs/internal/testing/TestScheduler';
import { Doctor } from './doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private baseURL = "http://localhost:8080/api";

  constructor(private httpClient:HttpClient) { }

  getDoctorsList():Observable<Doctor[]>{
    return this.httpClient.get<Doctor[]>(`${this.baseURL}/${"doctors"}`);
  }

  createDoctor(doctor:Doctor): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/${"doctors"}`, doctor);
  }

  getDoctor(id : number):Observable<Doctor>{
    return this.httpClient.get<Doctor>(`${this.baseURL}/${"doctors"}/${id}`);
  }
}
