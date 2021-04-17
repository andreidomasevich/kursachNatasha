import {Component, OnInit} from '@angular/core';
import {User} from './user';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  constructor(private http: HttpClient){}

  // tslint:disable-next-line:typedef
  ngOnInit(){
  }
}
