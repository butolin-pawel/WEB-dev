import { Component } from '@angular/core';
import { Car, User } from '../api/models';
import { USService } from '../api/services';
import { InMemoryUsers } from '../memory-us.service';
import { CarsComponent } from '../cars/cars.component';
import { Service } from '../api/services';
@Component({
  selector: 'app-reglog',
  templateUrl: './reglog.component.html',
  styleUrls: ['./reglog.component.css']
})
export class ReglogComponent {

  users : User[] = [];
  autorized: boolean = false;
  status : string = "Не в системе"
  constructor(private serv : USService,protected carcomp : CarsComponent, private servi: Service ){}
  ngOnInit(): void {
this.get();

  }
  get(){
    this.serv.getAllUsers().subscribe((us) => {
      this.users = us;
      console.log(us);
    });
  }
  name :string = '';
  mail :string ='';
  pas : string = '';
  reg(){
    let curr:User = {
      name :this.name,
      login : this.mail,
      password : this.pas
    };
    console.log(curr);
    this.name = '';
    this.mail ='';
    this.pas = '';
    this.serv.addUs({body:curr}).subscribe( (eee) => {console.log(eee);
    });
    this.get();
  }
  log(){
    let curr:User = {
      name :this.name,
      login : this.mail,
      password : this.pas
    };
    this.name = '';
    this.mail ='';
    this.pas = '';
    for(let i = 0; i< this.users.length;i++){
      let element = this.users[i];
      if(curr.login == element.login && curr.name == element.name && curr.password == element.password){
        this.autorized = true;
        this.status = "Вход выполнен"
        break;
       }
    }
    // this.showdata(this.autorized);
  }
  showdata(usl : boolean){
    console.log(usl);
    if(usl){
    this.req();
    }
    else{

    }
  }
  cars : Car[] =[];

  req(): void {
    console.log('i work');
    this.servi.getAllCar().subscribe((car) => {
      this.cars = car;
    });
    console.log(this.cars);

  }
  unLog():void{
    this.autorized = false;
    this.status = "Не в системе"
    this.cars = [];
  }
}
