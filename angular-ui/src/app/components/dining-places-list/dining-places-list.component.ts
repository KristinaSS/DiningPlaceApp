import { Component, OnInit } from '@angular/core';

import {FoodPlaceService} from '../../services/food-place.service';

@Component({
  selector: 'app-admin',
  templateUrl: './dining-places-list.component.html',
  styleUrls: ['./dining-places-list.component.css']
})
export class DiningPlacesListComponent implements OnInit {
  public foodPlaces;
  title = 'All Dining Places';

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
