import {Component, OnInit} from '@angular/core';
import {HumanService} from "../../service/human-service.service";
import {Human} from "../../model/Human";
import { delay } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'InfiniteList';
  gridColumns = 5;
  page = 1;
  humans: Human[] =[ ];
  constructor(private humService: HumanService) {}
  ngOnInit(): void {
    // this.humans.push(...
    // this.dogService
    //   .getHumans(this.page));
    this.humService.getHumans(this.page).subscribe((humant : Human[] ) => this.humans.push(...humant));
  }

    onScroll(): void {
    // this.humans.push(...
    //   this.dogService
    //     .getHumans(this.page++));
      console.log("SCROOOOOOL")
    this.humService.getHumans(this.page++).subscribe((humant : Human[]) => this.humans.push(...humant));
}

}
