import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CarServiceService } from '../car-service.service';
import { Car } from '../class/car';

@Component({
  selector: 'app-cars-upd',
  templateUrl: './cars-upd.component.html',
  styleUrls: ['./cars-upd.component.css']
})
export class CarsUpdComponent {
  car : Car ;

  constructor(private carServ : CarServiceService,private router: Router,private route: ActivatedRoute){
    this.car = new Car();
  }
  onSubmit() {
    this.carServ.update(this.car);
    this.gotoUserList();
  }
  ngOnInit() :void {
     this.carServ.findById(this.route.snapshot.params['id']).subscribe(
      (responce) => {
        this.car = responce;
      }
     );


  }
  gotoUserList() {
    this.router.navigate(['/']);
  }
}
