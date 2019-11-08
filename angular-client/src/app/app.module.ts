import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateFoodplaceComponent } from './create-foodplace/create-foodplace.component';
import { FoodPlaceDetailsComponent } from './food-place-details/food-place-details.component';
import { FoodPlaceListComponent } from './food-place-list/food-place-list.component';
import { UpdateFoodPlaceComponent } from './update-food-place/update-food-place.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    CreateFoodplaceComponent,
    FoodPlaceDetailsComponent,
    FoodPlaceListComponent,
    UpdateFoodPlaceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
