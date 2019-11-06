import { Component, OnInit } from '@angular/core';
import { DiningPlace } from '../model/dining-place';
import { DinningPlaceService } from '../service/dinning-place.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './all-dining.component.html',
  styleUrls: ['./all-dining.component.css']
})
export class AllDiningComponent implements OnInit {

  diningPlaces: DiningPlace[];

  constructor(private dinningPlaceService: DinningPlaceService) {
  }

  ngOnInit() {
    this.dinningPlaceService.findAll().subscribe(data => {
      this.diningPlaces = data;
    });
  }
}
