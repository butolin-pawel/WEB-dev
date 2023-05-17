import { Component } from '@angular/core';
import { BoxService } from '../box.service';
import { Router } from '@angular/router';
import { Box } from '../class/box';

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
    this.boxServ.save(this.box);
    this.gotoUserList();
  }

  gotoUserList() {
    this.router.navigate(['/redirect_box']);
  }
}
