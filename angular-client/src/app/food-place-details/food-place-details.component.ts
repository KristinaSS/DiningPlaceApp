import { Component, OnInit, Input } from '@angular/core';
import { FoodPlaceService } from "../food-place.service";
import { FoodPlace } from "../food-place";
import { FoodPlaceListComponent } from '../food-place-list/food-place-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-food-place-details',
  templateUrl: './food-place-details.component.html',
  styleUrls: ['./food-place-details.component.scss']
})
export class FoodPlaceDetailsComponent implements OnInit {
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

  list(){
    this.router.navigate(['/get-diningPlace-{ID}']);
  }
}
