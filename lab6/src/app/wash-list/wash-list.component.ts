import { Component, OnInit } from '@angular/core';
import { WashService } from '../wash.service';
import { Router } from '@angular/router';
import { Wash } from '../class/wash';
import * as moment from 'moment';
import { AppService } from '../app.service';
@Component({
  selector: 'app-wash-list',
  templateUrl: './wash-list.component.html',
  styleUrls: ['./wash-list.component.css']
})
export class WashListComponent implements OnInit{
  washes? : Wash[];
  constructor(public app: AppService,private washServ : WashService,private router: Router){
  }

  ngOnInit() :void {
   this.washServ.findAll().subscribe(data => {
     this.washes = data;
   });
 }
 remove(id : number){
   this.washServ.deleteWash(id).subscribe(() =>{
     this.router.navigate(['/redirect_wash']);
     this.ngOnInit();
   }
     );

 }
 retDate(date : Date){
  return moment(date).format('DD MMMM YYYY');;
 }
}
