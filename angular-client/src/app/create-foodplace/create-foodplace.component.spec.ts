import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFoodplaceComponent } from './create-foodplace.component';

describe('CreateFoodplaceComponent', () => {
  let component: CreateFoodplaceComponent;
  let fixture: ComponentFixture<CreateFoodplaceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateFoodplaceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateFoodplaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
