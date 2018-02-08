import { HttpClient,HttpHeaders } from "@angular/common/http";
import { Injectable } from '@angular/core';

@Injectable()
export class GlobalService {
  constructor(private httpClient: HttpClient) { }
  configUrl =  'assets/config.json';

  getRequest(geturl:string) {
    return this.httpClient.get(geturl);
  }

  postRequest(postUrl:string, postBody:any)
  {
    return this.httpClient.post(postUrl, postBody,{headers : new HttpHeaders().set('Content-Type', 'application/json')})
  }

  postRequestWithString(postUrl:string, empNo:string, password:string)
  {
    //console.log(empNo,password)
    let data = "empNo="+empNo+"&password="+password
    return this.httpClient.
    post(postUrl,data,{headers : new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')})
           
  }

}
