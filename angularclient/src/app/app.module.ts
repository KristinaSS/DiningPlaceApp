import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {RouterModule} from "@angular/router";
import { DiningPlaceFormComponent } from './dining-place-form/dining-place-form.component';


@NgModule({
  declarations: [
    AppComponent,
    DiningPlaceFormComponent
  ],
  imports: [
    BrowserModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
