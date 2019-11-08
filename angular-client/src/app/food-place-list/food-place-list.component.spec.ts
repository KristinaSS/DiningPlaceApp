import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodPlaceListComponent } from './food-place-list.component';

describe('FoodPlaceListComponent', () => {
  let component: FoodPlaceListComponent;
  let fixture: ComponentFixture<FoodPlaceListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FoodPlaceListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodPlaceListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
