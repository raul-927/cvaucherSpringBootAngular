import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletePacientesComponent } from './delete-pacientes.component';

describe('DeletePacientesComponent', () => {
  let component: DeletePacientesComponent;
  let fixture: ComponentFixture<DeletePacientesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeletePacientesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletePacientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
