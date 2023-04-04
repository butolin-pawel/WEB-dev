import { InMemoryDbService, RequestInfo } from 'angular-in-memory-web-api';
import { Injectable } from '@angular/core';
import { Car,Cars, User } from './api/models';

@Injectable({
  providedIn: 'root',
})
export class InMemoryDataService implements InMemoryDbService {

  createDb() {
    const cars: Car[] = [
      {
        carid : '1',
        brand : "Audi",
        model : "RS8"
      },
      {
        carid : '2',
        brand : "BMW",
        model : "E34"
      },
      {
        carid : '3',
        brand : "TOYOTA",
        model : "MARK||"
      },
      {
        carid : '4',
        brand : "Chery",
        model : "A13"
      },
      {
        carid : '5',
        brand : "LADA",
        model : "Vesta"
      },

    ];
    const users: User[] = [
      {
        id : 1,
        name: 'Anatoly',
        login: 'ana@example.com',
        password: '123'
      },
      {
        id : 2,
        name: 'Vasya',
        login: 'vas@example.com',
        password: '123'
      },
      {
        id : 3,
        name: 'Bob',
        login: 'bob@example.com',
        password: '123'
      },
      {
        id : 4,
        name: 'Kolya',
        login: 'kolya@example.com',
        password: '123'
      },
    ];

    return { cars, users };
  }

  // genId(shoes: Shoe[]): number {
  //   return shoes.length > 0
  //     ? Math.max(...shoes.map((shoe) => shoe.id!)) + 1
  //     : 11;
  // }
}
