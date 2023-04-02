import { Component } from '@angular/core';
import { Car } from '../api/models';
import { Service } from '../api/services';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent {

  cars : Car[] =[];
  constructor (private serv : Service){
  }
  req(): void {
    console.log('i work');
    this.serv.getAllCar().subscribe((car) => {
      this.cars = car;
    });
    console.log(this.cars);

  }
}
