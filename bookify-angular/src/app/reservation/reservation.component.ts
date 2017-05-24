import { Component, OnInit } from '@angular/core';
import { GeolocationService } from '../geolocation.service';
import { APIService } from '../api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css'],
  providers: [
    GeolocationService,
    APIService
  ]
})
export class ReservationComponent implements OnInit {

  city: String = '';
  price: number = 0;
  numberOfPeople: number = 2;
  numberOfRooms: number = 1;

  constructor(private geolocationService: GeolocationService,
  private apiService: APIService,
  private router: Router) {}
  
  onInputNumberOfPeopleChange(event: Event): void {
    this.numberOfPeople = +event;
    this.price = (this.numberOfPeople * this.numberOfRooms) * 30;
  }

  onInputNumberOfRoomsChange(event: Event): void {
    this.numberOfRooms = +event;
    this.price = (this.numberOfPeople * this.numberOfRooms) * 30;
  }

  redirectToRooms() {
    this.router.navigate(['./rooms', this.numberOfRooms,this.numberOfPeople,
      this.price, this.city
    ]);
  }

  ngOnInit() {
    this.geolocationService.getInfoByGeolocation().subscribe(
      data => this.city = data.city
    )

    this.price = (this.numberOfPeople * this.numberOfRooms) * 30;
  }

}
