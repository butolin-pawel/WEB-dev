import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Box } from './class/box';

@Injectable({
  providedIn: 'root'
})
export class BoxService {
  private URL: string;

  constructor(private http: HttpClient) {
    this.URL = 'http://localhost:8082/boxes'
  }

  public findAll(): Observable<Box[]> {
    return this.http.get<Box[]>(this.URL);

  }
  public deleteBox(id : number) {
    return this.http.delete<Box>(this.URL+'/'+id);

  }
  public save(box : Box) {

    return this.http.post<Box>(this.URL,box);

  }
  public update(box : Box){
    return this.http.put<Box>(this.URL,box);
  }
  public findById(id : number) : Observable<Box>{
    return this.http.get<Box>(this.URL+'/'+id);

  }
}
