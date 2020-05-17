import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EffectivenessCreateComponent } from './effectiveness-create.component';

describe('EffectivenessCreateComponent', () => {
  let component: EffectivenessCreateComponent;
  let fixture: ComponentFixture<EffectivenessCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EffectivenessCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EffectivenessCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
