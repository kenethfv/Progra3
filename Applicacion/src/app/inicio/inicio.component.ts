import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.scss']
})

export class InicioComponent implements OnInit {

  loading: boolean = false;

  cliente: any = {};


  constructor(private http: HttpClient) { }

  ngOnInit(): void {

  }


  crear() {
    let formulario:any = document.getElementById("crear");
    let formularioValido:boolean = formulario.reportValidity();
    if (formularioValido) {
      this.loading = true;
      this.createService().subscribe(
        data => this.confirmar(data)
      )
    }
  }


  confirmar(resultado: any) {
    this.loading = false;
    if (resultado) {
      alert("Cliente creado exitosamente")
      this.cliente = {};
    } else {
      alert("Error al crear el cliente.");
    }
  }

  createService() {
    var httpOptions = {
      headers:new HttpHeaders({
        'Content-Type':'application/json'
      })
    }
    return this.http.post<any>("http://localhost:8080/cliente/guardar", this.cliente,httpOptions);
  }

  radioSelection(event:any){
    this.cliente.sexo = event.target.value;
  }


}