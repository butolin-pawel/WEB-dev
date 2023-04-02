import { Component } from '@angular/core';
import { Car } from './api/models';
import { Service } from './api/services';
import { CarsComponent } from './cars/cars.component';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'cars';
}
