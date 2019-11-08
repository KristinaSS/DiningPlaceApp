import { Component, OnInit } from '@angular/core';
import { FoodPlaceService } from "../food-place.service";
import { FoodPlace } from "../food-place";
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-foodplace',
  templateUrl: './create-foodplace.component.html',
  styleUrls: ['./create-foodplace.component.scss']
})
export class CreateFoodplaceComponent implements OnInit {

  foodPlace: FoodPlace = new FoodPlace();
  submitted = false;

  constructor(private foodPlaceService: FoodPlaceService,
              private router: Router) { }

  ngOnInit() {
  }

  newEmployee(): void {
    this.submitted = false;
    this.foodPlace = new FoodPlace();
  }

  save() {
    this.foodPlaceService.createFoodPlace(this.foodPlace)
      .subscribe(data => console.log(data), error => console.log(error));
    this.foodPlace = new FoodPlace();
    this.foodPlace.foodRating = 0;
    this.foodPlace.valueRating= 0;
    this.foodPlace.overallRating = 0;
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/createDiningPlace']);
  }

}
