import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Credit} from '../../credit';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {



  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onUsersButtonClick() {
    this.router.navigateByUrl("/users");
  }

  onCreditsButtonClick() {
    this.router.navigateByUrl("/credits");
  }

  onDepositsButtonClick() {
    this.router.navigateByUrl("/deposits");
  }
}
