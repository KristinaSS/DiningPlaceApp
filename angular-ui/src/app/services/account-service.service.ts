import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AccountServiceService {

  constructor(private http: HttpClient) { }

  getAllAccounts() {
    return this.http.get('server/account');
  }
  getAccount(id: number) {
    return this.http.get('server/account-' + id);
  }
  createAccount(foodPlace, accountTypeId: number) {
    let body = JSON.stringify(foodPlace);
    return this.http.post('server/account/' + accountTypeId, body, httpOptions);
  }
}
