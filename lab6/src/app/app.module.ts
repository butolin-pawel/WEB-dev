import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { CarsListComponent } from './cars-list/cars-list.component';
import {HttpClientModule} from "@angular/common/http";
import { CarsAddComponent } from './cars-add/cars-add.component';
import { FormsModule } from '@angular/forms';
import { CarsUpdComponent } from './cars-upd/cars-upd.component';
import { BoxListComponent } from './box-list/box-list.component';
import { BoxAddComponent } from './box-add/box-add.component';
import { BoxUpdComponent } from './box-upd/box-upd.component';
import { WashUpdComponent } from './wash-upd/wash-upd.component';
import { WashCarComponent } from './wash-car/wash-car.component';
import { WashListComponent } from './wash-list/wash-list.component';
import { TestsocketComponent } from './testsocket/testsocket.component';
@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    CarsListComponent,
    CarsAddComponent,
    CarsUpdComponent,
    BoxListComponent,
    BoxAddComponent,
    BoxUpdComponent,
    WashUpdComponent,
    WashCarComponent,
    WashListComponent,
    TestsocketComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
