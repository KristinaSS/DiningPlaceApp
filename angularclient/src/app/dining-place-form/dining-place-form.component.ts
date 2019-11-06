import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DinningPlaceService } from '../service/dinning-place.service';
import { DiningPlace } from '../model/dining-place';

@Component({
  selector: 'app-dining-place-form',
  templateUrl: './dining-place-form.component.html',
  styleUrls: ['./dining-place-form.component.css']
})
export class DiningPlaceFormComponent {
  diningPlace: DiningPlace;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private dinningPlaceService: DinningPlaceService) {
    this.diningPlace = new DiningPlace();
  }

  onSubmit() {
    this.dinningPlaceService.save(this.diningPlace).subscribe(result => this.gotoDiningPlacesList());
  }

  gotoDiningPlacesList() {
    this.router.navigate(['/diningPlaces']);
  }
}
