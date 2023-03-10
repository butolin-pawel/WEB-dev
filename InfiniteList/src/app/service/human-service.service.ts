
import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Human } from '../model/Human';
import { tick } from '@angular/core/testing';

@Injectable({
  providedIn: 'root'
})
export class DogService  {
  #limit: number = 150;

  constructor(private http: HttpClient) { }
  responce : any;

  human :Human
  ={
    name : 'lucy',
        cell: '049-571-97-40',
        email : 'yddy@example.com',
        picture: 'https://randomuser.me/api/portraits/med/men/75.jpg'
  } ;

  getHumans(page: number){

    this.http.get(
      `https://randomuser.me/api/`
    ).subscribe( (response) => {
      this.responce = response;

      console.log(this.responce.results[0]);
      let human : Human =
      {
        name : this.responce.results[0].name.first,
         cell: this.responce.results[0].cell,
           email : this.responce.results[0].email,
          picture: this.responce.results[0].picture.medium
        };
      console.log(human);
      this.human = human;
      console.log(this.human);
    });

      console.log(this.human);
      return this.human;


  }
}
