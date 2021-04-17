import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../../user';
import {Router} from '@angular/router';
import {UserService} from '../user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  inputLogin = '';
  inputPassword = '';
  user: User = new User();

  constructor(private http: HttpClient, private router: Router, private userService: UserService) { }

  ngOnInit(): void {
  }

  onSignClick(login, password) {
    if(login === "admin" && password === "admin"){
      this.router.navigateByUrl("/users");
      this.userService.currentUser = this.user;
      return;
    }

    this.http.get('http://localhost:8080/users/findByLogin/?login=' + login).subscribe((data: User) => {
      this.user.id = data.id;
      this.user.password = data.password;
      this.user.login = data.login;
      this.user.email = data.email;
      this.user.address = data.address;
      this.user.passportNumber = data.passportNumber;
      this.user.dayOfBirth = data.dayOfBirth;
      this.user.lastname = data.lastname;
      this.user.surname = data.surname;
      this.user.name = data.name;
      if(login === this.user.login && password === this.user.password){

        this.userService.currentUser = this.user;
        this.router.navigateByUrl("/currentUser");
      }
    });

  }
}
