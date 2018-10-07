import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableDetalleTratamientosComponent } from './table-detalle-tratamientos.component';

describe('TableDetalleTratamientosComponent', () => {
  let component: TableDetalleTratamientosComponent;
  let fixture: ComponentFixture<TableDetalleTratamientosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableDetalleTratamientosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableDetalleTratamientosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
