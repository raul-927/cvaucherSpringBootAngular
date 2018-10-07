import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SarchTableComponent } from './sarch-table.component';

describe('SarchTableComponent', () => {
  let component: SarchTableComponent;
  let fixture: ComponentFixture<SarchTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SarchTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SarchTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
