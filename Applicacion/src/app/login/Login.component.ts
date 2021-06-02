import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './Login.component.html',
  styleUrls: ['./Login.component.scss']
})
export class LoginComponent implements OnInit {

  loading: boolean = false;
  usuario: any = {};

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  login() {
    let formulario: any = document.getElementById("login");
    let formularioValido: boolean = formulario.reportValidity();
    if (formularioValido) {
      this.loading = true;
      this.iniciarSesion
    }
  }

  iniciarSesion(resultado: any) {
    this.loading = false;
    if (resultado) {
      localStorage.setItem("usuario", JSON.stringify(resultado));

      if (resultado == "admin") {
        location.href = "/menu";
      }
    }
  }

}
