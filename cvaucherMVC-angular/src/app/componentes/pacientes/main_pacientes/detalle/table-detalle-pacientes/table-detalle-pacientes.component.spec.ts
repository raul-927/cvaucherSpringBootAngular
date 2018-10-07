import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableDetallePacientesComponent } from './table-detalle-pacientes.component';

describe('TableDetallePacientesComponent', () => {
  let component: TableDetallePacientesComponent;
  let fixture: ComponentFixture<TableDetallePacientesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableDetallePacientesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableDetallePacientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
