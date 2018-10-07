import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableDetalleAgendaComponent } from './table-detalle-agenda.component';

describe('TableDetalleAgendaComponent', () => {
  let component: TableDetalleAgendaComponent;
  let fixture: ComponentFixture<TableDetalleAgendaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableDetalleAgendaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableDetalleAgendaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
