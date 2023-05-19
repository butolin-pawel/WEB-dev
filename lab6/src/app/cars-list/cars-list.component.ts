import { Component, OnInit } from '@angular/core';
import { CarServiceService } from '../car-service.service';
import { Car } from '../class/car';
import { Router } from '@angular/router';
import { delay } from 'rxjs';
import { AppService } from '../app.service';

@Component({
  selector: 'app-cars-list',
  templateUrl: './cars-list.component.html',
  styleUrls: ['./cars-list.component.css']
})
export class CarsListComponent implements OnInit{
 cars? : Car[];
 constructor(public app: AppService,  private carServiceServise : CarServiceService,private router: Router){
 }

 ngOnInit() :void {
  this.carServiceServise.findAll().subscribe(data => {
    this.cars = data;
  });
}
remove(id : number){
  this.carServiceServise.deleteCar(id).subscribe(() =>{
    this.router.navigate(['/redirect_car']);
    this.ngOnInit();
  }
    );

}
}
