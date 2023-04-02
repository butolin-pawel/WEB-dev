import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InMemoryDataService } from './memory.service';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { CarsComponent } from './cars/cars.component';
import { ReglogComponent } from './reglog/reglog.component';
import { FormsModule } from '@angular/forms';
import { InMemoryUsers } from './memory-us.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    CarsComponent,
    ReglogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    InMemoryWebApiModule.forRoot(InMemoryDataService, {delay: 500}),
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
  ],
  providers: [
    InMemoryDataService,
    HttpClient,
    CarsComponent,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
