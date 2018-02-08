import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { AppComponent } from './app.component';
import { SignUpComponent } from './sign-up-component/sign-up-component.component';
import {  Routes } from '@angular/router';

export const ROUTES: Routes = [
    { path: 'login',
      component: LoginComponent,
      children:[
        {path:'',component:LoginComponent}]
    },
    {path:'signup',component:SignUpComponent},
    {path:'dashboard',component:DashboardComponent},
    { path:'',redirectTo: '/login',pathMatch: 'full'},
    { path:'**',redirectTo: '/login',pathMatch: 'full'}
  ];