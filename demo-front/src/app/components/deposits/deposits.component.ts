import { Component, OnInit } from '@angular/core';
import {Credit} from '../../credit';
import {HttpClient} from '@angular/common/http';
import {Deposit} from '../../deposit';
import {Router} from '@angular/router';

@Component({
  selector: 'app-deposits',
  templateUrl: './deposits.component.html',
  styleUrls: ['./deposits.component.css']
})
export class DepositsComponent implements OnInit {

  deposits: Deposit[] = [];
  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.http.get('http://localhost:8080/deposits/list').subscribe((data) => this.deposits = data["userDeposits"]);
  }

  toHomePage() {
    this.router.navigateByUrl("/");
  }
}
