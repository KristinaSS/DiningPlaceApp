import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiningPlaceFormComponent } from './dining-place-form.component';

describe('DiningPlaceFormComponent', () => {
  let component: DiningPlaceFormComponent;
  let fixture: ComponentFixture<DiningPlaceFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiningPlaceFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiningPlaceFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
