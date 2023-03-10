import {Component, OnInit} from '@angular/core';
import {DogService} from "../../service/human-service.service";
import {Human} from "../../model/Human";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'InfiniteList';
  gridColumns = 5;
  page = 1;
  humans: Human[] = []

  constructor(private dogService: DogService) {}
  ngOnInit(): void {
    this.humans.push(
    this.dogService
      .getHumans(this.page));
  }
  onScroll(): void {
    this.humans.push(
      this.dogService
        .getHumans(this.page++));
  }
}
