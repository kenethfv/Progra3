import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './Login.component.html',
  styleUrls: ['./Login.component.scss']
})
export class LoginComponent implements OnInit {

  errorInicio: boolean = false;
  NombreCliente: any = {};
  loading: boolean = false;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  login() {
    let formulario: any = document.getElementById("login");
    let formularioValido: boolean = formulario.reportValidity();
    if (formularioValido) {
      this.loading = true;
      this.loginService().subscribe(
        data => this.iniciarSesion(data)
      )
    }
  }
  iniciarSesion(resultado: any) {
    this.loading = false;
    if (resultado) {

      localStorage.setItem("NombreCliente", JSON.stringify(resultado));
      if (resultado.idCliente == 1) {
        location.href = "/inicio";
      }
      else {
        location.href = "/inicio";
      }
    }
    else {
      this.errorInicio = true;
    }
  }

  loginService() {
    var httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    return this.http.post<any>("http://localhost:8080/cliente/login", this.NombreCliente, httpOptions);

  }
}
