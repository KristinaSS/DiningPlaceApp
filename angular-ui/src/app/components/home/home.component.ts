import {Component, OnInit} from '@angular/core';
import {FoodPlaceService} from '../../services/food-place.service';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  foodPlaceForm: FormGroup;
  validMessage: string = '';

  constructor(private foodPlaceService: FoodPlaceService) {
  }

  ngOnInit() {
    this.foodPlaceForm = new FormGroup({
      name: new FormControl('', Validators.required),
      address: new FormControl('', Validators.required),
      telephone: new FormControl('', Validators.minLength(0)),
      linkToWebsite: new FormControl('', Validators.minLength(0))
    });
  }

  submitRegistration() {
    if (this.foodPlaceForm.valid) {
      this.validMessage = 'Your food place registration has been submitted. Thank you!';
      this.foodPlaceService.createFoodPlace(this.foodPlaceForm.value).subscribe(
        data => {
          this.foodPlaceForm.reset();
          return true;
        },
        error => {
          return Observable.throw(error);
        }
      );
    } else {
      this.validMessage = 'Please fill out this form before submitting';
    }
  }
}
