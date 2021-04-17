import { Component, OnInit } from '@angular/core';
import {User} from '../../user';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {UserService} from '../user/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users: User[] = [];
  user: User = new User();
  inputName = '';
  inputLastname = '';
  inputSurname = '';
  inputDayOfBirth = '';
  inputPassportNumber = '';
  inputAddress = '';
  inputLogin = '';
  inputEmail = '';
  inputPassword = '';

  constructor(private http: HttpClient, private router: Router, private userService: UserService) {
  }

  ngOnInit(): void {
    this.http.get('http://localhost:8080/users/findAll').subscribe((data) => this.users = data["userList"]);

  }

  // tslint:disable-next-line:typedef

  onAddButtonClick() {
    this.user.name = this.inputName;
    this.user.login = this.inputLogin;
    this.user.email = this.inputEmail;
    this.user.lastname = this.inputLastname;
    this.user.surname = this.inputSurname;
    this.user.dayOfBirth = this.inputDayOfBirth;
    this.user.passportNumber = this.inputPassportNumber;
    this.user.address = this.inputAddress;
    this.user.password = this.inputPassword;

    const body = {name: this.user.name, login: this.user.login, email: this.user.email, lastname: this.user.lastname, surname: this.user.surname, dayOfBirth: this.user.dayOfBirth, passportNumber: this.user.passportNumber, address: this.user.address, password: this.user.password};
    this.http.post('http://localhost:8080/users/save', body).subscribe((data: User) => {
      this.users.push(data);
    });
  }

  onUserClick(user) {
    this.router.navigateByUrl("/user");
    this.userService.currentUser = user;

  }

  deleteUser(user: User, $event: MouseEvent) {
    $event.stopPropagation();
    this.http.delete('http://localhost:8080/users/delete/' + user.id).subscribe((data: User) => {
      this.users.splice(this.users.indexOf(user), 1);
    });
  }

  toHomePage() {
    this.router.navigateByUrl("/home");
  }
}
