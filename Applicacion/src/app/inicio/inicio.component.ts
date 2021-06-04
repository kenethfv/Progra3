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



  constructor() { }

  ngOnInit(): void {
  }

  /*
  crear() {
    let formulario: any = document.getElementById("crear");
    let formularioValido: boolean = formulario.reportValidity();
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
      this.cliente = { correoList: [], telefonoList: [], direccionList: [], rolUsuarioIdrolUsuario: 2 };
    } else {
      alert("Error al crear el cliente.");
    }
  }

  createService() {
    var httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    return this.http.post<any>("http://localhost:3030/usuario/guardar", this.usuario, httpOptions)
  }

  regresar() {
    location.href = "/";
  }

  //TELEFONOS

  agregarTelefono() {
    this.usuario.telefonoList.push({});
  }

  borrarTelefono(telefono: any) {
    this.usuario.telefonoList.splice(this.usuario.telefonoList.indexOf(telefono), 1);
  }

  //CORREOS

  agregarCorreo() {
    this.usuario.correoList.push({});
  }

  borrarCorreo(correo: any) {
    this.usuario.correoList.splice(this.usuario.correoList.indexOf(correo), 1);
  }

  //DIRECCIONES
  agregarDireccion() {
    this.usuario.direccionList.push({});
  }

  borrarDireccion(direccion: any) {
    this.usuario.direccionList.splice(this.usuario.direccionList.indexOf(direccion), 1);
  }
*/
}
