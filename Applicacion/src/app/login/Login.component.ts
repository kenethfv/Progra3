import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './Login.component.html',
  styleUrls: ['./Login.component.scss']
})
export class LoginComponent implements OnInit {

  NombreCliente: any = {};
  loading: boolean = false;
  nombre = '';
  password = '';

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  validarDatos(){
    if(this.nombre == 'admin' && this.password == 'admin'){
      location.href = "/inicio";
    } else {
      location.href= " ";
      this.loading = true;
    }
  }
}
