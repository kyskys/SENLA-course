import { Component, OnInit } from '@angular/core';
import {UserDetails} from '../entity/userDetails';
import {HttpService} from '../service/http.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
   providers: [
  HttpService,
  ]
})
export class ProfileComponent implements OnInit {

	name: string;
	email: string;
	details: UserDetails = new UserDetails();
  
  constructor(private service: HttpService) { }

  ngOnInit() {
  }

  getDetails() {
  this.service.doGet("http://localhost:8080/webapps/api/profile?id="+1).subscribe(
    (msg:UserDetails)=> {
      this.details=msg;
      this.name=this.details.name;
      this.email=this.details.email;
    },error => {
    this.name=error;
    }
  );
}
}
