import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetallePacientesComponent } from './detalle-pacientes.component';

describe('DetallePacientesComponent', () => {
  let component: DetallePacientesComponent;
  let fixture: ComponentFixture<DetallePacientesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetallePacientesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetallePacientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
