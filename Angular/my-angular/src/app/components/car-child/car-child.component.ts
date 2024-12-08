import { Component, EventEmitter, Input, Output } from "@angular/core";
import { CarType } from "src/app/Types/CarType";

@Component({
    selector: 'car-child',
    templateUrl: './car-child.component.html',
    styleUrls: ['./car-child.component.css']
})
export class CarChildComponent {

    @Input('element') element: CarType;
    @Output('duplicateCar') duplicateCar = new EventEmitter<CarType>();

    duplicate(){
        this.duplicateCar.emit(this.element);
    }
}