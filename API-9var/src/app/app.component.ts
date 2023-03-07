import { Component } from '@angular/core';

import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private http :HttpClient){
    this.search();
  }
  title = 'Ваше аниме на сегодня';
  responce : any;
  fotourl : any = 'http://cf.ppt-online.org/files/slide/n/Ncw71DHnRrBi5ulXo2OSPYKb3AmUIWFQz4dM6q/slide-61.jpg';
  search() {
    this.http.get('https://animechan.vercel.app/api/random').
    subscribe(
        (response) => {
      this.responce = response;
      console.log(this.responce);
    });

  }

}
