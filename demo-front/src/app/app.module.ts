import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { UserComponent } from './components/user/user.component';
import {RouterModule, Routes} from '@angular/router';
import { UsersComponent } from './components/users/users.component';
import { HomeComponent } from './components/home/home.component';
import { CreditsComponent } from './components/credits/credits.component';
import { DepositsComponent } from './components/deposits/deposits.component';
import { LoginComponent } from './components/login/login.component';
import { CurrentUserComponent } from './components/current-user/current-user.component';


const appRoutes: Routes = [
  { path: '', component: LoginComponent},
  { path: 'user', component: UserComponent},
  { path: 'users', component: UsersComponent},
  { path: 'credits', component: CreditsComponent},
  { path: 'deposits', component: DepositsComponent},
  { path: 'home', component: HomeComponent},
  { path: 'currentUser', component: CurrentUserComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    UsersComponent,
    HomeComponent,
    CreditsComponent,
    DepositsComponent,
    LoginComponent,
    CurrentUserComponent
  ],
    imports: [
        BrowserModule, HttpClientModule, FormsModule, RouterModule.forRoot(appRoutes)
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
