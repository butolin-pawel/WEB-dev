import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Wash } from './class/wash';

@Injectable({
  providedIn: 'root'
})
export class WashService {
  private URL: string;

  constructor(private http: HttpClient) {
    this.URL = 'http://localhost:8082/washes'
  }

  public findAll(): Observable<Wash[]> {
    return this.http.get<Wash[]>(this.URL);

  }
  public deleteWash(id : number) {
    return this.http.delete<Wash>(this.URL+'/'+id);

  }
  public save(wash : Wash) {

    return this.http.post<Wash>(this.URL,wash);

  }
  public update(wash : Wash){
    return this.http.put<Wash>(this.URL,wash).subscribe();
  }
  public findById(id : number) : Observable<Wash>{
    return this.http.get<Wash>(this.URL+'/'+id);

  }
}
