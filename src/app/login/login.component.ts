import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GlobalService } from '../global.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router,private globalService:GlobalService) { }

  private loginData = new Object();
  private loginResponse: {};
  private loginUrl = 'http://10.31.100.163:8080/register/signIn';
  value: Date;
  ngOnInit() {
  }
  // to login 
  login()
  {
    if(this.loginData['empNo'] && this.loginData['password'])
    {
        // this.router.navigateByUrl('/dashboard');
      this.globalService.postRequestWithString(this.loginUrl, this.loginData['empNo'], this.loginData['password'])
      .subscribe(
        data =>  {
          if(data && data['success']){
            alert(data['success']);
            this.router.navigateByUrl('/dashboard');
          }else{
            alert(data['error']);
          }
         }, // success path
        error => {
          alert('Error occured while signing up');
        }// error path
      );
    }
    else{alert('Please provide username and Password');}
  }

}
