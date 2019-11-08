import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FoodPlaceDetailsComponent } from '../food-place-details/food-place-details.component';
import { Observable } from "rxjs";
import { FoodPlaceService } from "../food-place.service";
import { FoodPlace } from "../food-place";

@Component({
  selector: 'app-food-place-list',
  templateUrl: './food-place-list.component.html',
  styleUrls: ['./food-place-list.component.scss']
})
export class FoodPlaceListComponent implements OnInit {
  foodPlaces: Observable<FoodPlace[]>;

  constructor(private foodPlaceService: FoodPlaceService,
              private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.foodPlaces = this.foodPlaceService.getFoodPlaceList();
  }

  deleteFoodPlace(id: number) {
    this.foodPlaceService.deleteFoodPlace(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  foodPlaceDetails(id: number){
    this.router.navigate(['details', id]);
  }
}
