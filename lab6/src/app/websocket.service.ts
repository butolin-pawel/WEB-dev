import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stomp, Client, StompSubscription, IMessage} from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
@Injectable({
  providedIn: 'root'
})
export class WebsocketService {
  private stompClient;

  constructor() {
     const socket = new SockJS('http://localhost:8082/websocket');
    this.stompClient = Stomp.over(socket);
    this.stompClient.activate();
  }
connectBox(): Observable<any> {
    return new Observable(observer => {
      this.stompClient.connect({}, () => {
        this.stompClient.subscribe('/topic/boxes', (message: IMessage) => {
          observer.next(JSON.parse(message.body));
      });
  });
    });

  }
  connectCar(): Observable<any> {
    return new Observable(observer => {
      this.stompClient.connect({}, () => {
        this.stompClient.subscribe('/topic/cars', (message: IMessage) => {
          observer.next(JSON.parse(message.body));
      });
  });
    });

  }
  connectWash(): Observable<any> {
    return new Observable(observer => {
      this.stompClient.connect({}, () => {
        this.stompClient.subscribe('/topic/washes', (message: IMessage) => {
          observer.next(JSON.parse(message.body));
      });
  });
    });

  }
}
