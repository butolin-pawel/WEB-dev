import { Component } from '@angular/core';
import { Car } from '../class/car';
import { CarServiceService } from '../car-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cars-add',
  templateUrl: './cars-add.component.html',
  styleUrls: ['./cars-add.component.css']
})
export class CarsAddComponent {
  car : Car = new Car();
  constructor(private carServ : CarServiceService,private router: Router){

  }
  onSubmit() {
    this.carServ.save(this.car);
    this.gotoUserList();
  }

  gotoUserList() {
    this.router.navigate(['/redirect_car']);
  }
}
