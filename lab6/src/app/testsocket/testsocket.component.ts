import { Component, OnInit } from '@angular/core';
import { WebsocketService } from '../websocket.service';

@Component({
  selector: 'app-testsocket',
  templateUrl: './testsocket.component.html',
  styleUrls: ['./testsocket.component.css']
})
export class TestsocketComponent {
  // addnum! : string;
  // constructor(private webSocketService: WebsocketService) {}
  // data : string[] = [];
  // ngOnInit(): void {
  //   this.webSocketService.connect().subscribe((data) => {
  //     this.data = data;
  //     console.log(data);
  //   });

  // }

  // sendDataToServer(): void {
  //   if(this.addnum != null)
  //   this.webSocketService.sendData(this.addnum);
  // }
}
