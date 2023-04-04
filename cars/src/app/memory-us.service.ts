import { Injectable } from '@angular/core';
import { InMemoryDbService, RequestInfo } from 'angular-in-memory-web-api';
import { User } from './api/models';

@Injectable({
  providedIn: 'root',
})
export class InMemoryUsers implements InMemoryDbService {

  createDb() {
    const users: User[] = [
      // {
      //   name: 'Anatoly',
      //   login: 'anaexample.com',
      //   password: '123'
      // },
      // {
      //   name: 'Vasya',
      //   login: 'vasexample.com',
      //   password: '123'
      // },
      // {
      //   name: 'Bob',
      //   login: 'bobexample.com',
      //   password: '123'
      // },
      // {
      //   name: 'Kolya',
      //   login: 'kolyaexample.com',
      //   password: '123'
      // },
    ];


    return { users };
  }
}
