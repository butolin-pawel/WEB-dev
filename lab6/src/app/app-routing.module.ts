import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarsListComponent } from './cars-list/cars-list.component';
import { AppComponent } from './app.component';
import { CarsAddComponent } from './cars-add/cars-add.component';
import { CarsUpdComponent } from './cars-upd/cars-upd.component';
import { BoxListComponent } from './box-list/box-list.component';
import { BoxAddComponent } from './box-add/box-add.component';
import { BoxUpdComponent } from './box-upd/box-upd.component';
import { WashListComponent } from './wash-list/wash-list.component';
import { WashCarComponent } from './wash-car/wash-car.component';
import { WashUpdComponent } from './wash-upd/wash-upd.component';
import { TestsocketComponent } from './testsocket/testsocket.component';

const routes: Routes = [
  {path: '',  component: CarsListComponent},
  {path: 'newcar', component: CarsAddComponent},
  {path: 'editcar/:id', component: CarsUpdComponent},
  {path: 'redirect_car', redirectTo:''},
  {path: 'boxes',  component: BoxListComponent},
  {path: 'newbox', component: BoxAddComponent},
  {path: 'editbox/:id', component: BoxUpdComponent},
  {path: 'redirect_box', redirectTo:'/boxes'},
  {path: 'redirect_wash', redirectTo:'/washes'},
  {path: 'washes',  component: WashListComponent},
  {path: 'newwash/:id', component: WashCarComponent},
  {path: 'editwash/:id', component: WashUpdComponent},
  {path: 'test', component: TestsocketComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
