import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeadComponent } from './componentes/head/head.component';
import { Template1Component } from './componentes/template1/template1.component';
import { MenuPrincipalComponent } from './componentes/menu-principal/menu-principal.component';
import { FooterComponent } from './componentes/footer/footer.component';
import { PacientesComponent } from './componentes/pacientes/pacientes.component';
// tslint:disable-next-line:max-line-length
import { SearchPacientesFormComponent } from './componentes/pacientes/main_pacientes/search/search-pacientes-form/search-pacientes-form.component';
import { SarchTableComponent } from './componentes/pacientes/main_pacientes/search/sarch-table/sarch-table.component';
// tslint:disable-next-line:max-line-length
import { DetallePacientesFormComponent } from './componentes/pacientes/main_pacientes/detalle/detalle-pacientes-form/detalle-pacientes-form.component';
// tslint:disable-next-line:max-line-length
import { TableDetalleAgendaComponent } from './componentes/pacientes/main_pacientes/detalle/table-detalle-agenda/table-detalle-agenda.component';
// tslint:disable-next-line:max-line-length
import { TableDetalleDireccionComponent } from './componentes/pacientes/main_pacientes/detalle/table-detalle-direccion/table-detalle-direccion.component';
// tslint:disable-next-line:max-line-length
import { TableDetalleHistoriaClinicaComponent } from './componentes/pacientes/main_pacientes/detalle/table-detalle-historia-clinica/table-detalle-historia-clinica.component';
// tslint:disable-next-line:max-line-length
import { TableDetalleSeguimientoPacientesComponent } from './componentes/pacientes/main_pacientes/detalle/table-detalle-seguimiento-pacientes/table-detalle-seguimiento-pacientes.component';
// tslint:disable-next-line:max-line-length
import { TableDetalleSesionesComponent } from './componentes/pacientes/main_pacientes/detalle/table-detalle-sesiones/table-detalle-sesiones.component';
// tslint:disable-next-line:max-line-length
import { TableDetalleTratamientosComponent } from './componentes/pacientes/main_pacientes/detalle/table-detalle-tratamientos/table-detalle-tratamientos.component';
import { DeletePacientesComponent } from './componentes/pacientes/delete-pacientes/delete-pacientes.component';
import { DetallePacientesComponent } from './componentes/pacientes/detalle-pacientes/detalle-pacientes.component';
import { InsertPacientesComponent } from './componentes/pacientes/insert-pacientes/insert-pacientes.component';

@NgModule({
  declarations: [
    AppComponent,
    HeadComponent,
    Template1Component,
    MenuPrincipalComponent,
    FooterComponent,
    PacientesComponent,
    SearchPacientesFormComponent,
    SarchTableComponent,
    DetallePacientesFormComponent,
    TableDetalleAgendaComponent,
    TableDetalleDireccionComponent,
    TableDetalleHistoriaClinicaComponent,
    TableDetalleSeguimientoPacientesComponent,
    TableDetalleSesionesComponent,
    TableDetalleTratamientosComponent,
    DeletePacientesComponent,
    DetallePacientesComponent,
    InsertPacientesComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
