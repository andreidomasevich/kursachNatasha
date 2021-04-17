import { Component, OnInit } from '@angular/core';
import {UserService} from './user.service';
import {User} from '../../user';
import {HttpClient} from '@angular/common/http';
import {Credit} from '../../credit';
import {Deposit} from '../../deposit';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user: User;
  credit: Credit = new Credit();
  credits: Credit[] = [];
  deposit: Deposit = new Deposit();
  deposits: Deposit[] = [];

  inputCreditAmount = '';
  inputCreditPercent = '';
  inputCreditTerm = '';
  inputCreditPurpose = '';

  inputDepositAmount = '';
  inputDepositPercent = '';
  inputDepositTerm = '';
  inputDepositPurpose = '';


  constructor(private userService: UserService, private http: HttpClient, private router: Router) {
    this.user = this.userService.currentUser;
  }

  ngOnInit(): void {
    this.http.get('http://localhost:8080/credits/list/' + this.user.id).subscribe((data) => this.credits = data["userCredits"]);
    this.http.get('http://localhost:8080/deposits/list/' + this.user.id).subscribe((data) => this.deposits = data["userDeposits"]);
  }


  onAddCreditButtonClick() {
    this.credit.amount = this.inputCreditAmount;
    this.credit.percent = this.inputCreditPercent;
    this.credit.term = this.inputCreditTerm;
    this.credit.purpose = this.inputCreditPurpose;

    const body = {amount: this.credit.amount, percent: this.credit.percent, term: this.credit.term, purpose: this.credit.purpose, userId: this.user.id};
    this.http.post('http://localhost:8080/credits/save', body).subscribe((data: Credit) => {
      this.credits.push(data);
    });
  }

  onAddDepositButtonClick() {
    this.deposit.amount = this.inputDepositAmount;
    this.deposit.percent = this.inputDepositPercent;
    this.deposit.term = this.inputDepositTerm;
    this.deposit.purpose = this.inputDepositPurpose;

    const body = {amount: this.deposit.amount, percent: this.deposit.percent, term: this.deposit.term, purpose: this.deposit.purpose, userId: this.user.id};
    this.http.post('http://localhost:8080/deposits/save', body).subscribe((data: Deposit) => {
      this.deposits.push(data);
    });
  }

  deleteCredit(credit: Credit, $event: MouseEvent) {
    $event.stopPropagation();
    this.http.delete('http://localhost:8080/credits/delete/' + credit.id).subscribe((data: Credit) => {
      this.credits.splice(this.credits.indexOf(credit), 1);
    });
  }

  deleteDeposit(deposit: Deposit, $event: MouseEvent) {
    $event.stopPropagation();
    this.http.delete('http://localhost:8080/deposits/delete/' + deposit.id).subscribe((data: Deposit) => {
      this.deposits.splice(this.deposits.indexOf(deposit), 1);
    });
  }

  toUsersPage() {
    this.router.navigateByUrl("/users");
  }
}
