import { Component, OnInit } from '@angular/core';
import {HttpService} from '../service/http.service';
import {HttpParams} from '@angular/common/http';
import {Router} from '@angular/router';
import {UserCreds} from '../entity/userCreds';
import {Message} from '../entity/message';

@Component({
  selector: 'app-authorisation',
  templateUrl: './authorisation.component.html',
  styleUrls: ['./authorisation.component.css'],
  providers: [
  HttpService,
  ]
})
export class AuthorisationComponent implements OnInit {

	login:string;
	password:string;
	message:string;
  codeMessage: Message = new Message();
  token: string;

  constructor(private service: HttpService, private router: Router) { }

  redirectToProfile() {
  this.router.navigate(['profile']);
  }

  ngOnInit() {
  }

  getUser() :UserCreds  {
  	var user: UserCreds = new UserCreds();
  	user.login=this.login;
  	user.password=this.password;
    return user;
  }
  
  check() {
  	//const params = new HttpParams().set('login',login).set('password',pass);
    var user: UserCreds = this.getUser();
  	this.service.doPost("http://localhost:8080/webapps/login", user).subscribe((msg: Message)=>this.codeMessage=msg);
    if(this.codeMessage.code==3000) {
      this.token = this.codeMessage.token;
      this.redirectToProfile();
    } else if (this.codeMessage.code==3001) {
      this.message="wrong password";
    } else if (this.codeMessage.code=3002) {
      this.message="no such login";
    }
  }
  }

