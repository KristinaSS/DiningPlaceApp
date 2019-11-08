import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import {FoodPlaceService} from './services/food-place.service';
import { AdminComponent } from './components/admin/admin.component';
import {AppRoutingModule} from './app-routing.module';
import { HomeComponent } from './components/home/home.component';


@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [FoodPlaceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
