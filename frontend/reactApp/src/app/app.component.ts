import {Component} from '@angular/core';
import {AuthenticationService} from "./authentication/authentication.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private app: AuthenticationService, private http: HttpClient, private router: Router) {
    this.app.authenticate("", "");
  }


  public logout(): void {

    this.app.logout().subscribe((resp: any) => {
      alert(resp + "newWay");
    })
    this.app.authenticated = false;
    this.router.navigateByUrl('/login');
  }

}
