import {Injectable} from '@angular/core';
import {HttpClient,HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class HttpService{
  
    constructor(private http: HttpClient){ }
      
    doGet(url: string){
        return this.http.get(url);
    }

    doPost(url: string, body) {
    	return this.http.post(url,body);
    }
    
}