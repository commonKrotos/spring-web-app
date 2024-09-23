import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  authenticated = false;

  constructor(private http: HttpClient) {
  }



  authenticate(username: string, password: string): Observable<any> {

    const headers = new HttpHeaders({
      authorization: 'Basic ' + btoa(username + ':' + password)
    });

    return this.http.get(
      'user',
      {headers: headers});

  }

  logout(): Observable<any> {
    return  this.http.post(
      'logout',
      {});
  }
}
