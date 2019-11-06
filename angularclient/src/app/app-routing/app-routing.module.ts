import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AllDiningComponent } from '../diningplaces/all-dining.component';


const routes: Routes = [
  { path: 'users', component: AllDiningComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
