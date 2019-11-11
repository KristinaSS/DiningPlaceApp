import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {AdminComponent} from './components/admin/admin.component';
import {HomeComponent} from './components/home/home.component';
import {ViewFoodPlaceComponent} from './components/view-food-place/view-food-place.component';
import {AppComponent} from './app.component';

const routes: Routes = [
  {
    path: '',
    component: AppComponent
  },
  {
    path: 'admin/view-food-place/:id',
    component: ViewFoodPlaceComponent
  },
  {
    path: 'admin',
    component: AdminComponent
  }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
