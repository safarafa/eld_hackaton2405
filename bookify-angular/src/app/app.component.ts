import { Component, OnInit } from '@angular/core';
import { GeolocationService } from './geolocation.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [
    GeolocationService
  ]
})
export class AppComponent implements OnInit {
  city: String = '';
  price: number = 0;
  numberOfPeople: number = 2;
  numberOfRooms: number = 1;

  constructor(private geolocationService: GeolocationService) {}

  onInputNumberOfPeopleChange(event: Event): void {
    this.numberOfPeople = +event;
    this.price = (this.numberOfPeople * this.numberOfRooms) * 30;
  }

  onInputNumberOfRoomsChange(event: Event): void {
    this.numberOfRooms = +event;
    this.price = (this.numberOfPeople * this.numberOfRooms) * 30;
  }

  ngOnInit() {
    this.geolocationService.getInfoByGeolocation().subscribe(
      data => this.city = data.city
    )

    this.price = (this.numberOfPeople * this.numberOfRooms) * 30;
  }
}
