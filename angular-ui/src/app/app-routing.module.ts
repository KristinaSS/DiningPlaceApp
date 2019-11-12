import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {DiningPlacesListComponent} from './components/dining-places-list/dining-places-list.component';
import {HomeComponent} from './components/home/home.component';
import {ViewFoodPlaceComponent} from './components/view-food-place/view-food-place.component';
import {AppComponent} from './app.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'dining-places-list/view-food-place/:id',
    component: ViewFoodPlaceComponent
  },
  {
    path: 'dining-places-list/dining-places',
    component: DiningPlacesListComponent
  }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
