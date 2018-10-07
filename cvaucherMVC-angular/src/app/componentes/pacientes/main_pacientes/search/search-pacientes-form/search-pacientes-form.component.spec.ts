import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchPacientesFormComponent } from './search-pacientes-form.component';

describe('SearchPacientesFormComponent', () => {
  let component: SearchPacientesFormComponent;
  let fixture: ComponentFixture<SearchPacientesFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchPacientesFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchPacientesFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
