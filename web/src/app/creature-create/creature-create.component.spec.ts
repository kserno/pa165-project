import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatureCreateComponent } from './creature-create.component';

describe('CreatureCreateComponent', () => {
  let component: CreatureCreateComponent;
  let fixture: ComponentFixture<CreatureCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreatureCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatureCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
