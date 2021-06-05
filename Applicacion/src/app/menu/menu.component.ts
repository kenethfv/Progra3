import { Component, OnInit } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Subject } from 'rxjs';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  private serviceURL = 'http://localhost:8080/cliente';
  private mybSubject: BehaviorSubject<any>;
  private actualizarTexto: any;
  public texto2 = 'nuevo dato ingresado: ';
  private refresh = new Subject<void>();

  clientes: any = [];
  cliente: any = {};

  constructor(private http: HttpClient) {

    this.mybSubject = new BehaviorSubject(null);
  }

  ngOnInit(): void {
    this.buscarClientes();
  }


  buscarClientes() {
    this.buscarClientesServicio().subscribe(
      (response: any) => this.llenarClientes(response)
    )
  }

  buscarClientesServicio(): Observable<any> {
    return this.http.get<any>("http://localhost:8080/cliente/buscar").pipe(
      catchError(e => "error")
    )
  }

  llenarClientes(clientes: any) {
    this.clientes = clientes;
  }

}
