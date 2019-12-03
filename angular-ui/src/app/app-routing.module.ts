import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {DiningPlacesListComponent} from './components/dining-places/dining-places-list/dining-places-list.component';
import {HomeComponent} from './components/home/home.component';
import {ViewFoodPlaceComponent} from './components/dining-places/view-food-place/view-food-place.component';
import {AppComponent} from './app.component';
import {CreateFoodPlaceComponent} from './components/dining-places/create-food-place/create-food-place.component';
import {AcountListComponent} from './components/account/acount-list/acount-list.component';
import {AccountViewComponent} from './components/account/account-view/account-view.component';
import {CreateAccountComponent} from './components/account/create-account/create-account.component';
import {RegisterViewComponent} from './register-view/register-view.component';

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
  },
  {
    path: 'dining-place/create',
    component: CreateFoodPlaceComponent
  },
  {
    path: 'account/account-list',
    component: AcountListComponent
  },
  {
    path: 'account/create',
    component: CreateAccountComponent
  },
  {
    path: 'account/:id',
    component: AccountViewComponent
  },
  {
  path: 'register',
    component: RegisterViewComponent
  }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
