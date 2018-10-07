import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertPacientesComponent } from './insert-pacientes.component';

describe('InsertPacientesComponent', () => {
  let component: InsertPacientesComponent;
  let fixture: ComponentFixture<InsertPacientesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertPacientesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertPacientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
