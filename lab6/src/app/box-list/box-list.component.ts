import { Component } from '@angular/core';
import { BoxService } from '../box.service';
import { Router } from '@angular/router';
import { Box } from '../class/box';
import { AppService } from '../app.service';
import { WebsocketService } from '../websocket.service';

@Component({
  selector: 'app-box-list',
  templateUrl: './box-list.component.html',
  styleUrls: ['./box-list.component.css']
})
export class BoxListComponent {
  boxes? : Box[];
  constructor(public app: AppService,private boxServ : BoxService,private router: Router,private webSocketService: WebsocketService){
  }

  ngOnInit() :void {
    this.boxServ.findAll().subscribe(data => {
     this.boxes = data;
   });
    this.webSocketService.connectBox().subscribe((data) => {
      this.boxes = data;
      console.log(data);
    });

 }
 remove(id : number){
  console.log(id);
    this.boxServ.deleteBox(id).subscribe(() =>{this.boxServ.findAll().subscribe(data => {
      this.boxes = data;
    });});
    //this.webSocketService.delBox(id);
 }
}
