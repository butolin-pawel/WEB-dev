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

  constructor(private http: HttpClient) { }
  responce : any;
  human:Human
  =
    {
    name : 'lucy',
        cell: '049-571-97-40',
        email : 'yddy@example.com',
        picture: 'https://randomuser.me/api/portraits/med/men/75.jpg'
  } ;
  getHumans(page: number) : Observable< Human>{
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
      this.human = humant;
    });

    // return this.human as unknown as Observable<Human>;
    return of(this.human);

}
}
