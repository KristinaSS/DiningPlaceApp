import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {FoodPlaceService} from '../../../services/food-place.service';
import {Observable} from 'rxjs';
import {AccountServiceService} from '../../../services/account-service.service';
import {AccountTypeServiceService} from '../../../services/account-type-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {
  title: 'Create  Account';
  accountForm: FormGroup;
  accountTypeForm: FormGroup;
  validMessage: string = '';
  accountTypeID: string;
  accountTypes: AccountType[] = [
    {id: '1', name: 'admin'},
    {id: '2', name: 'guest'}
  ];

  constructor(private accountServiceService: AccountServiceService,
              private accountTypeServiceService: AccountTypeServiceService,
              private router: Router) {
  }

  ngOnInit() {
    this.accountForm = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)});
    this.accountTypeForm = new FormGroup({
      accountType: new FormControl('', Validators.required)
    });
  }

  submitRegistration() {
    if (this.accountForm.valid) {
      this.validMessage = 'Your account registration has been submitted. Thank you!';
      this.accountServiceService.createAccount(this.accountForm.value, this.accountTypeID).subscribe(
        data => {
          this.accountForm.reset();
          return true;
        },
        error => {
          return Observable.throw(error);
        }
      );
      this.router.navigate(['account/account-list']);
    } else {
      this.validMessage = 'Please fill out this form before submitting';
    }
  }
}

export interface AccountType {
  id: string;
  name: string;
}
