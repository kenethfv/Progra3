import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './Login.component.html',
  styleUrls: ['./Login.component.scss']
})
export class LoginComponent implements OnInit {

  usuario: String = "admin";
  pass: String = "admin";
  loading: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  login() {
    this.loading = true;

    if (this.usuario == "admin" && this.pass == "admin") {
      location.href = "/menu";

    } else {
      location.href = "/login";
    }

  }


}
