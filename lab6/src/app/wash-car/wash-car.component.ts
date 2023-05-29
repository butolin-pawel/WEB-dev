import { Component, OnInit } from '@angular/core';
import { WashService } from '../wash.service';
import { ActivatedRoute, Router } from '@angular/router';
import { BoxService } from '../box.service';
import { Box } from '../class/box';
import { Wash } from '../class/wash';
import { CarServiceService } from '../car-service.service';
import { Car } from '../class/car';

@Component({
  selector: 'app-wash-car',
  templateUrl: './wash-car.component.html',
  styleUrls: ['./wash-car.component.css']
})
export class WashCarComponent {
  boxes! : Box[];
  wash : Wash = new Wash();
  car! : Car;
  box! : Box;
  id! : number;
  constructor(private washServ : WashService,private boxServ : BoxService,private carServ : CarServiceService,private router: Router,private route :ActivatedRoute){

  }
  ngOnInit() : void{
    this.boxServ.findAll().subscribe((data) => {
      this.boxes = data;
   });
   this.carServ.findById(this.route.snapshot.params['id']).subscribe(
    (responce) => {
      this.car = responce;
    }
   );
  }
  onSubmit() {

     this.boxServ.findById(this.id).subscribe(
      (responce) => {

        this.box = responce;
        this.wash.car = this.car;
         this.wash.place = this.box;
         this.wash.active = true;
        this.washServ.save(this.wash).subscribe(() =>{
          this.gotoUserList();
        });

      }
     )




  }

  gotoUserList() {
    this.router.navigate(['/']);
  }
}
