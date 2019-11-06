import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DiningPlace } from '../model/dining-place';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class DinningPlaceService {

  private foodPlaceUrl: string;

  constructor(private http: HttpClient) {
    this.foodPlaceUrl = 'http://localhost:8080/diningPlaces';
  }

  public findAll(): Observable<DiningPlace[]> {
    return this.http.get<DiningPlace[]>(this.foodPlaceUrl);
  }

  public save(diningPlace: DiningPlace) {
    return this.http.post<DiningPlace>(this.foodPlaceUrl, diningPlace);
  }
}
