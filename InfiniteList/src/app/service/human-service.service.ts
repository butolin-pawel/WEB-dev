import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { delay, Observable, of, retry } from 'rxjs';
import { Human } from '../model/Human';
import { tick } from '@angular/core/testing';

@Injectable({
  providedIn: 'root'
})
export class HumanService  {
  #limit: number = 150;
  responce : any;
  human:Human[] =[{
    name : 'lucy',
        cell: '049-571-97-40',
        email : 'yddy@example.com',
        picture: 'https://randomuser.me/api/portraits/med/men/75.jpg'
  } ];
  constructor(private http: HttpClient) {
    console.log("start");
    console.log(this.human);
  }

  getHumans(page: number) : Observable< Human[]>{
    for(let i = 0; i <5;i++){
    this.http.get(
      `https://randomuser.me/api/`)
      .subscribe( (response) => {
      this.responce = response;
      let humant : Human =
      {
        name : this.responce.results[0].name.first,
         cell: this.responce.results[0].cell,
           email : this.responce.results[0].email,
          picture: this.responce.results[0].picture.medium
        };
      this.human.push( humant);
    });
  }

    return of(this.human);

}
}
