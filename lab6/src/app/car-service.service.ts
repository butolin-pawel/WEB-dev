import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Car } from './class/car';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CarServiceService {
private URL: string;

  constructor(private http: HttpClient) {
    this.URL = 'http://localhost:8082/cars'
  }

  public findAll(): Observable<Car[]> {
    return this.http.get<Car[]>(this.URL);

  }
  public deleteCar(id : number) {
    return this.http.delete<Car>(this.URL+'/'+id);

  }
  public save(car : Car) {
    return this.http.post<Car>(this.URL,car).subscribe();

  }
  public update(car : Car){
    return this.http.put<Car>(this.URL,car).subscribe();
  }
  public findById(id : number) : Observable<Car>{
    return this.http.get<Car>(this.URL+'/'+id);

  }
}
