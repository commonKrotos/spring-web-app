import {Component, OnInit} from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {AuthenticationService} from "../authentication.service";

@Component({
  templateUrl: './login.component.html'
})
export class LoginComponent {

  username: string = "";
  password: string = "";


  constructor(private app: AuthenticationService, private http: HttpClient, private router: Router) {
  }

  public login(): void {
    this.router.navigateByUrl('/');
    this.app.authenticate(this.username, this.password).subscribe((resp: any) => {
      alert(resp + "newWay");
    })
  }
}
