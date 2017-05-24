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

  constructor(private geolocationService: GeolocationService) {}

  ngOnInit() {
    this.geolocationService.getInfoByGeolocation().subscribe(
      data => this.city = data.city
    )
  }
}
