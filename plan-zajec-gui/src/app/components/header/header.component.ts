import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  aktualnyCzas: any;


  constructor() { }

  ngOnInit() {
    this.aktualnyCzas = moment(new Date).format('DD/MM/YYYY');
  }

}
