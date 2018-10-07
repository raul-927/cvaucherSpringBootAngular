import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableDetalleSeguimientoPacientesComponent } from './table-detalle-seguimiento-pacientes.component';

describe('TableDetalleSeguimientoPacientesComponent', () => {
  let component: TableDetalleSeguimientoPacientesComponent;
  let fixture: ComponentFixture<TableDetalleSeguimientoPacientesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableDetalleSeguimientoPacientesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableDetalleSeguimientoPacientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
