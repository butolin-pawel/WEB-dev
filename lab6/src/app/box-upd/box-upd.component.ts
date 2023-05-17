import { Component } from '@angular/core';
import { BoxService } from '../box.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Box } from '../class/box';

@Component({
  selector: 'app-box-upd',
  templateUrl: './box-upd.component.html',
  styleUrls: ['./box-upd.component.css']
})
export class BoxUpdComponent {
  box : Box ;

  constructor(private boxServ : BoxService,private router: Router,private route: ActivatedRoute){
    this.box = new Box();
  }
  onSubmit() {
    this.boxServ.update(this.box);
    this.gotoUserList();
  }
  ngOnInit() :void {
     this.boxServ.findById(this.route.snapshot.params['id']).subscribe(
      (responce) => {
        this.box = responce;
      }
     );


  }
  gotoUserList() {
    this.router.navigate(['/boxes']);
  }
}
