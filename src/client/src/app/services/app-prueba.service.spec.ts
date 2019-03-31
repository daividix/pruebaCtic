import { TestBed } from '@angular/core/testing';

import { AppPruebaService } from './app-prueba.service';

describe('AppPruebaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AppPruebaService = TestBed.get(AppPruebaService);
    expect(service).toBeTruthy();
  });
});
