import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppService } from '../app.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {
  credentials = {username: '', password: ''};
  constructor(public app: AppService, private http: HttpClient) {
  }
  login(){
    console.log("ПЫТАЮСЬ");

     this.app.authenticate(this.credentials);
     this.credentials.username = "";
     this.credentials.password = "";
  }
  logout(){
    this.app.authenticated = false;
    this.app.authAdmin = false;
  }
}
