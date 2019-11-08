import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodPlaceDetailsComponent } from './food-place-details.component';

describe('FoodPlaceDetailsComponent', () => {
  let component: FoodPlaceDetailsComponent;
  let fixture: ComponentFixture<FoodPlaceDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FoodPlaceDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodPlaceDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
