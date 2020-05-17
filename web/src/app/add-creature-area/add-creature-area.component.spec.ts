import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCreatureAreaComponent } from './add-creature-area.component';

describe('AddCreatureAreaComponent', () => {
  let component: AddCreatureAreaComponent;
  let fixture: ComponentFixture<AddCreatureAreaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddCreatureAreaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCreatureAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
