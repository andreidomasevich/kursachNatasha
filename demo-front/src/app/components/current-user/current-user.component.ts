import { Component, OnInit } from '@angular/core';
import {User} from '../../user';
import {Credit} from '../../credit';
import {Deposit} from '../../deposit';
import {UserService} from '../user/user.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-current-user',
  templateUrl: './current-user.component.html',
  styleUrls: ['./current-user.component.css']
})
export class CurrentUserComponent implements OnInit {

  user: User;
  credits: Credit[] = [];
  deposits: Deposit[] = [];

  constructor(private userService: UserService, private http: HttpClient) {
    this.user = this.userService.currentUser;
  }

  ngOnInit(): void {
    this.http.get('http://localhost:8080/credits/list/' + this.user.id).subscribe((data) => this.credits = data["userCredits"]);
    this.http.get('http://localhost:8080/deposits/list/' + this.user.id).subscribe((data) => this.deposits = data["userDeposits"]);
  }

}
