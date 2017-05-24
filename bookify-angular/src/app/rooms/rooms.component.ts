import { Component, OnInit } from '@angular/core';
import { Room } from '../room';

@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrls: ['./rooms.component.css']
})
export class RoomsComponent implements OnInit {

  rooms: Room[] = [new Room(4, 2, 50, 'Lublin', 'Victoria')];

  constructor() { }

  ngOnInit() {
    this.rooms.push(
      new Room(4, 2, 50, 'Lublin', 'Victoria')
    );
    console.log('ok');
  }

}
