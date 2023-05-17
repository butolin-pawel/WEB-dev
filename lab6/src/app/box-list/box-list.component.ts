import { Component } from '@angular/core';
import { BoxService } from '../box.service';
import { Router } from '@angular/router';
import { Box } from '../class/box';
import { AppService } from '../app.service';

@Component({
  selector: 'app-box-list',
  templateUrl: './box-list.component.html',
  styleUrls: ['./box-list.component.css']
})
export class BoxListComponent {
  boxes? : Box[];
  constructor(public app: AppService,private boxServ : BoxService,private router: Router){
  }

  ngOnInit() :void {
   this.boxServ.findAll().subscribe(data => {
     this.boxes = data;
   });
 }
 remove(id : number){
   this.boxServ.deleteBox(id).subscribe(() =>{
     this.router.navigate(['/redirect_box']);
   }
     );

 }
}
