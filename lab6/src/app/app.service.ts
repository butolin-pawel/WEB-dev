import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppService {
 public authenticated = false;
 public authAdmin = false;
 response : any;
  constructor(private http: HttpClient) {
        // this.authenticated = Boolean(localStorage.getItem('auth'));
        // this.authAdmin = Boolean(localStorage.getItem('role'));
        this.authenticated = localStorage.getItem('auth')==='1'?true:false ;
        this.authAdmin =     localStorage.getItem('role')==='1'?true:false;
  }

  authenticate(credentials: { username: string; password: string; }) {
        console.log(credentials);

        this.http.post('http://localhost:8082/vhod',credentials).subscribe(response => {
            this.response = response;

            if (this.response['role']) {
              this.authAdmin = true;
              localStorage.setItem('role', String(1));
          } else {
            localStorage.setItem('role', String(0));
              this.authAdmin = false;
          }
            if (this.response['auth']) {
              localStorage.setItem('auth', String(1));
                this.authenticated = true;
            } else {
              localStorage.setItem('auth', String(0));
                this.authenticated = false;
            }
            console.log(this.authenticated + ' '+this.authAdmin);

        });

    }
}
