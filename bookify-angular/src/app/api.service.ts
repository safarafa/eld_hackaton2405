import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class APIService {

  constructor(private http: Http) { }

  getAllRooms() {
    return this.http.get('http://192.168.130.226:8080/rooms/all').map((res: Response) => res.json());
  }

  getAllCustomers() {
    return this.http.get('http://192.168.130.226:8080/customers/all').map((res: Response) => res.json());
  }

}
