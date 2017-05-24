import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class GeolocationService {

  constructor(private http: Http) { }

  getInfoByGeolocation() {
    return this.http.get('http://ipinfo.io/').map((res: Response) => res.json());
  }
}
