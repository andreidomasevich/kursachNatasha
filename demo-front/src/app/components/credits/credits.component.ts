import { Component, OnInit } from '@angular/core';
import {Credit} from '../../credit';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-credits',
  templateUrl: './credits.component.html',
  styleUrls: ['./credits.component.css']
})
export class CreditsComponent implements OnInit {

  credits: Credit[] = [];
  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.http.get('http://localhost:8080/credits/list').subscribe((data) => this.credits = data["userCredits"]);
  }

  toHomePage() {
    this.router.navigateByUrl("/home");
  }
}
