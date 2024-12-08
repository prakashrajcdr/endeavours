import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute) { }
  name: string;
  lastname: string;
  ngOnInit() {
    this.name = this.activatedRoute.snapshot.paramMap.get('name');
    this.activatedRoute.queryParamMap.subscribe(param =>{
      this.lastname = param.get('lastname');
    });
  }

}
