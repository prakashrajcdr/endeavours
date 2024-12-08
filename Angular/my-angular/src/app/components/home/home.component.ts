import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";


@Component({
    selector : 'home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent {

    constructor(activatedRoute: ActivatedRoute){

    }
}
