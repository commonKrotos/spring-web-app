import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import {HomeService} from "./home.service";
import {AuthenticationService} from "../authentication/authentication.service";

@Component({
  templateUrl: './home.component.html'
})
export class HomeComponent {

  result: any;

  title = 'Demo';


  constructor(private app: HomeService,private auth: AuthenticationService, private http: HttpClient) {
  }

  authenticated() { return this.auth.authenticated; }

  public createTestUser(): void {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        alert(this.responseText);
      }
    };
    xhttp.open("GET", "http://localhost:8080/rty/createTestUser", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
  }

  public createTestUserNew(): void {
    this.app.createTestUser().subscribe((resp: any) => {
      this.result = resp;
      alert(this.result + "newWay");
    });
  }

}
