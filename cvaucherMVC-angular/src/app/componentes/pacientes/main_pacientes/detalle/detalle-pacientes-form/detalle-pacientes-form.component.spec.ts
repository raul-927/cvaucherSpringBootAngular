import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetallePacientesFormComponent } from './detalle-pacientes-form.component';

describe('DetallePacientesFormComponent', () => {
  let component: DetallePacientesFormComponent;
  let fixture: ComponentFixture<DetallePacientesFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetallePacientesFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetallePacientesFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
