import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { GlobalService } from '../global.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  private employess;
  private empAllDataurl = 'http://10.31.100.163:8080/employee/getAllEmployee';

  

  constructor(private router: Router,private globalService: GlobalService) {
    // this.employess = [{'empid':1, 'empNo':456789, 'empName':'Nimit Saxena', 'designation': 'Senior Consultant','serviceLine':'SI','role':'Developer'},
    // {'empid':2, 'empNo':456799, 'empName':'Nikita Agrawal', 'designation': 'BTA','serviceLine':'AIM','role':'Developer'},
    // {'empid':3, 'empNo':456779, 'empName':'Deepak Sahoo', 'designation': 'Consultant','serviceLine':'SI','role':'Developer'}, 
    // {'empid':4, 'empNo':456769, 'empName':'Kritika Jain', 'designation': 'BTA','serviceLine':'SI','role':'Developer'} ]
   }

  ngOnInit() {
    // to get all employee data
    this.globalService.getRequest(this.empAllDataurl)
    .subscribe(
      data =>  {
        if(data){
          this.employess = data;
        }else{
          alert(data['error']);
        }
       }, // success path
      error => {
        alert('Error occured while getting Data');
      }// error path
    );
  }
  // sign out
  signOut()
  {
    this.router.navigateByUrl('/login');
  }
}
