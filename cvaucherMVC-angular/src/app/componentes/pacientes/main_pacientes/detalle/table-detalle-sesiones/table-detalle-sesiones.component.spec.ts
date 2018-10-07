import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableDetalleSesionesComponent } from './table-detalle-sesiones.component';

describe('TableDetalleSesionesComponent', () => {
  let component: TableDetalleSesionesComponent;
  let fixture: ComponentFixture<TableDetalleSesionesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableDetalleSesionesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableDetalleSesionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
