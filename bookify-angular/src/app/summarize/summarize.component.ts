import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-summarize',
  templateUrl: './summarize.component.html',
  styleUrls: ['./summarize.component.css']
})
export class SummarizeComponent implements OnInit {

  rooms: number = 0;
  people: number = 0;
  price: number = 0;
  location: String = '';
  hotel: String = '';

  constructor(private router: Router,
  private route: ActivatedRoute) { }

  ngOnInit() {
    this.rooms = this.route.snapshot.params['rooms'];
    this.people = this.route.snapshot.params['people'];
    this.price = this.route.snapshot.params['price'];
    this.location = this.route.snapshot.params['location'];
    this.hotel = this.route.snapshot.params['hotel'];
  }

}
