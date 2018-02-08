import { Component, OnInit } from '@angular/core';
import { GlobalService } from '../global.service';
import { Router } from '@angular/router';

@Component({
  selector: 'sign-up',
  templateUrl: './sign-up-component.component.html',
  styleUrls: ['./sign-up-component.component.css']
})
export class SignUpComponent implements OnInit {

  private employee = new Object();
  empDataUrl = 'http://10.31.100.163:8080/register/signUp'
  constructor(private globalService: GlobalService,private router: Router) { }
  signUpresponse:any;
  ngOnInit() {
  }

  // sign up
  signUp()
  {

    if((Object.keys(this.employee).length != 0))
    {
      this.globalService.postRequest(this.empDataUrl, this.employee)
        .subscribe(
        data =>  {
          if(data && data['success']){
            alert(data['success']);
            this.router.navigateByUrl('/login');
          }else{
            alert(data['error']);
          }
        }, // success path
        error => {
          alert('Error occured while signing up');
        }// error path
      );
    }
    else{alert('All fields are mandatory to SignUp');}
  }

  

}
