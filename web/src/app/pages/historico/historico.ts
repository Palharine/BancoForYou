import { Component } from '@angular/core';
import { DefaultLoginLayout } from '../../components/default-login-layout/default-login-layout';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-historico',
  imports: [
    DefaultLoginLayout
  ],
  templateUrl: './historico.html',
  styleUrl: './historico.scss',
})

@Injectable({
  provideIn: 'root'
})


export class Historico {

  private baseUrl = 'http://localhost:8080/usuarios';

  constructor(private http: HttpClient){}

  findAll(): Observable<any[]>{
    return this.http.get<any[]>(this.baseUrl);
  }
}
