import { TestBed } from '@angular/core/testing';

import { CreatureService } from './creature.service';

describe('CreatureService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CreatureService = TestBed.get(CreatureService);
    expect(service).toBeTruthy();
  });
});
