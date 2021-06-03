import { Component, OnInit } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {HttpHeaders} from '@angular/common/http';
import {catchError} from 'rxjs/operators';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {


  private serviceURL = 'http://localhost:8080/cliente';
  private mybSubject: BehaviorSubject<any>;
  private actualizarTexto: any;
  public texto = 'prueba';

  clientes: any = [];
  cliente: any = {};





  constructor(private http:HttpClient) { 

    this.mybSubject = new BehaviorSubject(null);
  }

  

  ngOnInit(): void {
    this.doSubjectSubscription();
    this.doNotificationSubscription();  
  }


  public getClienteNotification(): Observable<any> {

    return Observable.create((observer: { next: (arg0: any) => void; }) => {
    const url: any = this.serviceURL+'/notification';

    const eventSource = new EventSource(url);

    eventSource.onmessage = (event) => {
      console.log('Received event: ', event);
    };

    eventSource.addEventListener('cliente-result', function (event:any){
      observer.next(event.data);
    });

    eventSource.addEventListener('heartbeat-result', function (event){
      console.log('eventSource.addEventListener: on heartbeat....');
    });

    return () => eventSource.close();
  });
}


public doNotificationSubscription(): void {
  
      this.getClienteNotification()
      .subscribe((result) => {

        console.log('Mensaje recibido:' + JSON.stringify(result));
        this.mybSubject.next(result);
      
      });
}

public doSubjectSubscription(): void {
  this.mybSubject.subscribe((result) => {
    this.actualizarTexto(result);
  });

  this.mybSubject.subscribe((result) => {
    this.texto = this.texto + JSON.stringify(result);
  });

  this.buscarClientes();

}


buscarClientes(){
  this.buscarClientesServicio().subscribe(
    (response:any)=>this.llenarClientes(response) 
  )
}

buscarClientesServicio():Observable<any>{
  return this.http.get<any>("http://localhost:8080/cliente/buscar").pipe(
    catchError(e=>"error")
  )
}


llenarClientes(clientes:any){
  this.clientes = clientes;
}



}
