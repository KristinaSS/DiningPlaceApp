import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FoodPlaceService {
  private baseUrl = 'http://localhost:8080/dining';

  constructor(private http: HttpClient) { }

  getFoodPlace(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createFoodPlace(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, employee);
  }

  updateFoodPlace(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteFoodPlace(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getFoodPlaceList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
