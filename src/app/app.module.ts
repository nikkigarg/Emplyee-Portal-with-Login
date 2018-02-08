import { RouterModule } from '@angular/router';
import { ROUTES } from './app.route';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms'
import { AppComponent } from './app.component';
import { SignUpComponent } from './sign-up-component/sign-up-component.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HttpClientModule } from '@angular/common/http';
import { GlobalService } from './global.service';
// import {CommonModule} from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    LoginComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    // SharedModule,
    // CommonModule,
    RouterModule.forRoot(ROUTES),
    HttpClientModule,
    // BrowserAnimationsModule,
    // GrowlModule,
    // CalendarModule
  ],
  providers: [GlobalService],
  bootstrap: [AppComponent]
})
export class AppModule { }

