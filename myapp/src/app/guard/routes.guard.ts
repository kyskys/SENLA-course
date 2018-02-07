import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from "@angular/router";
import {Observable} from "rxjs/Rx";
import {Injectable} from '@angular/core';
import {AuthService} from '../service/auth.service';
 
 @Injectable()
export class RoutesGuard implements CanActivate{

	constructor(private auth: AuthService, private router : Router) {

	}
 
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) : Observable<boolean> | boolean{
        if (this.auth.getToken()!= '') {
        	return true;
        } else {
        	this.router.navigate(['']);
        	return false;
        }
    }
}