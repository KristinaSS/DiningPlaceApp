import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import {FoodPlaceService} from './services/food-place.service';
import { DiningPlacesListComponent } from './components/dining-places-list/dining-places-list.component';
import {AppRoutingModule} from './app-routing.module';
import { HomeComponent } from './components/home/home.component';
import { ViewFoodPlaceComponent } from './components/view-food-place/view-food-place.component';
import { CreateFoodPlaceComponent } from './components/create-food-place/create-food-place.component';
import { HeaderComponent } from './components/header/header.component';


@NgModule({
  declarations: [
    AppComponent,
    DiningPlacesListComponent,
    HomeComponent,
    ViewFoodPlaceComponent,
    CreateFoodPlaceComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [FoodPlaceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
