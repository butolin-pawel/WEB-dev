import { Component } from '@angular/core';
import { BoxService } from '../box.service';
import { Router } from '@angular/router';
import { Box } from '../class/box';
import { WebsocketService } from '../websocket.service';

@Component({
  selector: 'app-box-add',
  templateUrl: './box-add.component.html',
  styleUrls: ['./box-add.component.css']
})
export class BoxAddComponent {
  box : Box = new Box();
  constructor(private boxServ : BoxService,private router: Router){

  }
  onSubmit() {
    this.boxServ.save(this.box).subscribe(()=>{this.router.navigate(['/redirect_box']);});


  }

}
