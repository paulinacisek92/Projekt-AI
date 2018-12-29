import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-group-schedule',
  templateUrl: './group-schedule.component.html',
  styleUrls: ['./group-schedule.component.css']
})
export class GroupScheduleComponent implements OnInit {

  listaGrup: any;
  listaZajec: any;
  kolumny: string[] = ["Nr bloku", "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela"]

  bloki: any[] = [{numerBloku:1,godzinaRozpoczecia:"8:00",godzinaZakonczenia:"9:35"},
                  {numerBloku:2,godzinaRozpoczecia:"9:50",godzinaZakonczenia:"11:25"},
                  {numerBloku:3,godzinaRozpoczecia:"11:40",godzinaZakonczenia:"13:15"},
                  {numerBloku:4,godzinaRozpoczecia:"13:30",godzinaZakonczenia:"15:05"},
                  {numerBloku:5,godzinaRozpoczecia:"15:45",godzinaZakonczenia:"17:20"},
                  {numerBloku:6,godzinaRozpoczecia:"17:35",godzinaZakonczenia:"19:10"},
                  {numerBloku:7,godzinaRozpoczecia:"19:25",godzinaZakonczenia:"21:00"}];
  
  nrTygodnia: number;
  tydzienZajec: number;
  pierwszyDzien: any;
  ostatniDzien: any;
  wybranaWartosc: any;

  poprzedni(): void {
    if(this.tydzienZajec > this.nrTygodnia ) {
      this.tydzienZajec -=1;
      this.pierwszyDzien = moment().day("Monday").week(this.tydzienZajec);
      this.ostatniDzien = moment(this.pierwszyDzien).add(6, 'days').format("DD/MM/YYYY");
      this.pierwszyDzien = this.pierwszyDzien.format("DD/MM/YYYY");}
  }

  kolejny(): void {
    if(this.tydzienZajec ) {
      this.tydzienZajec +=1; 
      this.pierwszyDzien = moment().day("Monday").week(this.tydzienZajec);
      this.ostatniDzien = moment(this.pierwszyDzien).add(6, 'days').format("DD/MM/YYYY");
      this.pierwszyDzien = this.pierwszyDzien.format("DD/MM/YYYY");}
  }

  obslugaGrupyPrzyciskow(event: any) {
    this.wybranaWartosc = event.target.value;
  }


  pobierzListeGrup(): void {
    this.httpClient.get(`http://localhost:8080/api/grupy`)
      .subscribe(
        (data: any) => {
          this.listaGrup = data;
        }
      );
  }

  pobierzListeZajec(): void {
    this.httpClient.get(`http://localhost:8080/api/zajecia/grupa/`+this.wybranaWartosc+`/`+this.tydzienZajec)
      .subscribe(
        (data: any) => {
          this.listaZajec = data;
        }
      );
  }


  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
   this.nrTygodnia =   moment(new Date, "MMDDYYYY").week();
   this.tydzienZajec = this.nrTygodnia;
   this.pierwszyDzien = moment().day("Monday").week(this.nrTygodnia);
   this.ostatniDzien = moment(this.pierwszyDzien).add(6, 'days').format("DD/MM/YYYY");
   this.pierwszyDzien = this.pierwszyDzien.format("DD/MM/YYYY");
   this.pobierzListeGrup();
  }

}
