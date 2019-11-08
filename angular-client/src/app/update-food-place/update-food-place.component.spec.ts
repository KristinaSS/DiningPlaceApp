import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateFoodPlaceComponent } from './update-food-place.component';

describe('UpdateFoodPlaceComponent', () => {
  let component: UpdateFoodPlaceComponent;
  let fixture: ComponentFixture<UpdateFoodPlaceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateFoodPlaceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateFoodPlaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
