import { Component, OnInit } from '@angular/core';
import { Room } from '../room';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrls: ['./rooms.component.css']
})
export class RoomsComponent implements OnInit {
  drooms: number = 0;
  people: number = 0;
  price: number = 0;
  location: String = '';

  rooms: Room[] = [];

  constructor(private router: Router,
  private route: ActivatedRoute) { }

  redirectToSummarize(room) {
    this.router.navigate(['./summarize', room.numberOfRooms, room.numberOfPeople,
      room.price, room.location, room.hotel
    ]);
  }

  ngOnInit() {
    this.drooms = this.route.snapshot.params['rooms'];
    this.people = this.route.snapshot.params['people'];
    this.price = this.route.snapshot.params['price'];
    this.location = this.route.snapshot.params['location'];
    this.rooms.push(
      new Room(this.drooms, this.people, this.price, this.location, 'Victoria'),
      new Room(this.drooms, this.people, this.price, this.location, 'Merkury'),
      new Room(this.drooms, this.people, this.price, this.location, 'Las Palmas'),
      new Room(this.drooms, this.people, this.price, this.location, 'Astoria'),
      new Room(this.drooms, this.people, this.price, this.location, 'Bristol'),
    );
  }

}
