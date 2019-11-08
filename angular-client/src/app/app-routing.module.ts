import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FoodPlaceDetailsComponent} from './food-place-details/food-place-details.component'
import {CreateFoodplaceComponent} from './create-foodplace/create-foodplace.component'
import { FoodPlaceListComponent } from './food-place-list/food-place-list.component';
import { UpdateFoodPlaceComponent } from './update-food-place/update-food-place.component';





const routes: Routes = [
  { path: '', redirectTo: 'diningPlace', pathMatch: 'full' },
  { path: 'diningPlaces', component: FoodPlaceListComponent },
  { path: 'add', component: CreateFoodplaceComponent },
  { path: 'update/:id', component: UpdateFoodPlaceComponent },
  { path: 'details/:id', component: FoodPlaceDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
