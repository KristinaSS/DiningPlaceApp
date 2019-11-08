import { Component, OnInit } from '@angular/core';

import {FoodPlaceService} from '../../services/food-place.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  public foodPlaces;

  constructor(private foodPlaceService: FoodPlaceService) { }

  ngOnInit() {
    this.getFoodPlaces();
  }

  getFoodPlaces() {
    this.foodPlaceService.getAllFoodPlaces().subscribe(
      data => {this.foodPlaces = data;
      },
      error => console.error(error),
      () => console.log('Food Places Loaded')
    );
  }
}
