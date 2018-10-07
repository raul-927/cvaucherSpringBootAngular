import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableDetalleDireccionComponent } from './table-detalle-direccion.component';

describe('TableDetalleDireccionComponent', () => {
  let component: TableDetalleDireccionComponent;
  let fixture: ComponentFixture<TableDetalleDireccionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableDetalleDireccionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableDetalleDireccionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
