import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableDetalleHistoriaClinicaComponent } from './table-detalle-historia-clinica.component';

describe('TableDetalleHistoriaClinicaComponent', () => {
  let component: TableDetalleHistoriaClinicaComponent;
  let fixture: ComponentFixture<TableDetalleHistoriaClinicaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableDetalleHistoriaClinicaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableDetalleHistoriaClinicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
