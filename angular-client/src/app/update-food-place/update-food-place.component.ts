import { Component, OnInit } from '@angular/core';
import { FoodPlaceService } from "../food-place.service";
import { FoodPlace } from "../food-place";
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-food-place',
  templateUrl: './update-food-place.component.html',
  styleUrls: ['./update-food-place.component.scss']
})
export class UpdateFoodPlaceComponent implements OnInit {
  id: number;
  foodPlace: FoodPlace;

  constructor(private route: ActivatedRoute,private router: Router,
              private foodPlaceService: FoodPlaceService) { }

  ngOnInit() {
    this.foodPlace = new FoodPlace();

    this.id = this.route.snapshot.params['id'];

    this.foodPlaceService.getFoodPlace(this.id)
      .subscribe(data => {
        console.log(data)
        this.foodPlace = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.foodPlaceService.updateFoodPlace(this.id, this.foodPlace)
      .subscribe(data => console.log(data), error => console.log(error));
    this.foodPlace = new FoodPlace();
    this.gotoList();
  }

  onSubmit() {
    this.updateEmployee();
  }

  gotoList() {
    this.router.navigate(['/edit-diningPlace-{fpID}']);
  }
}
