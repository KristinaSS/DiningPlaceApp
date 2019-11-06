import { TestBed, inject } from '@angular/core/testing';

import { DinningPlaceServiceService } from './dinning-place.service';

describe('DinningPlaceServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DinningPlaceServiceService]
    });
  });

  it('should be created', inject([DinningPlaceServiceService], (service: DinningPlaceServiceService) => {
    expect(service).toBeTruthy();
  }));
});
