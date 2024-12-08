import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MyService } from 'src/app/services/MyService';
import { CarType } from 'src/app/Types/CarType';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  message = 'my-angular';
  brand: string;
  model: string;
  cars : CarType[] = [{brand: 'Suzuki', model: 'Swift'}];

  constructor(private myService: MyService, private route: Router, private activatedRoute: ActivatedRoute) {
    this.message = myService.getMessage();
  }

  addCar(){
    let car = {brand : this.brand, model: this.model}
    this.cars.push(car);
    console.log('cars : ', this.cars);
  }
  duplicateCar(car: CarType){
    this.brand = car.brand;
    this.model = car.model;
  }

  goUser(){
    this.route.navigate(['home/user', 'Prakash'], 
      {
        queryParams: {lastname: 'Raj'}, 
        relativeTo: this.activatedRoute
      });
  }
}
