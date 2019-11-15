import { Component, OnInit } from '@angular/core';

import {AccountServiceService} from '../../../services/account-service.service';

@Component({
  selector: 'app-acount-list',
  templateUrl: './acount-list.component.html',
  styleUrls: ['./acount-list.component.css']
})
export class AcountListComponent implements OnInit {
  public accounts;
  title = 'All Accounts';

  constructor(private accountService: AccountServiceService) { }

  ngOnInit() {
    this.getAllAccounts();
  }

  getAllAccounts(){
    this.accountService.getAllAccounts().subscribe(
      data => {this.accounts = data;
      },
      error => console.error(error),
      () => console.log('Accounts Loaded')
    );
  }
}
