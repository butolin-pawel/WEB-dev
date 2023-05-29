import { Component, OnInit } from '@angular/core';
import { WashService } from '../wash.service';
import { Router } from '@angular/router';
import { Wash } from '../class/wash';
import * as moment from 'moment';
import { AppService } from '../app.service';
import { WebsocketService } from '../websocket.service';
@Component({
  selector: 'app-wash-list',
  templateUrl: './wash-list.component.html',
  styleUrls: ['./wash-list.component.css']
})
export class WashListComponent implements OnInit{
  washes? : Wash[];
  constructor(public app: AppService,private washServ : WashService,private router: Router,private webSocketService: WebsocketService){
  }

  ngOnInit() :void {
   this.washServ.findAll().subscribe(data => {
     this.washes = data;
   });
   this.webSocketService.connectWash().subscribe((data) => {
    this.washes = data;
  });
 }
 remove(id : number){
   this.washServ.deleteWash(id).subscribe(() =>{
    this.washServ.findAll().subscribe(data => {
      this.washes = data;
    });
   }
     );

 }
 retDate(date : Date){
  return moment(date).format('DD MMMM YYYY');;
 }
}
