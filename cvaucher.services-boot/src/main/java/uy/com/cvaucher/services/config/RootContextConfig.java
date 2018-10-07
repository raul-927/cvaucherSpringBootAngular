package uy.com.cvaucher.services.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import uy.com.cvaucher.services.services.AgendaService;
import uy.com.cvaucher.services.services.DireccionService;
import uy.com.cvaucher.services.services.HistoriaClinicaService;
import uy.com.cvaucher.services.services.PacientesService;
import uy.com.cvaucher.services.services.SeguimientoPacientesService;
import uy.com.cvaucher.services.services.TipoTratamientoService;
import uy.com.cvaucher.services.services.SesionRealizadaService;
import uy.com.cvaucher.services.services.TipoAgendaService;
import uy.com.cvaucher.services.services.TratamientoService;
import uy.com.cvaucher.services.services.TratamientoPacienteService;
import uy.com.cvaucher.services.services.HistorialPagosService;
import uy.com.cvaucher.services.services.ListaPreciosService;
import uy.com.cvaucher.services.services.AuxPreciosService;
import uy.com.cvaucher.services.services.FormasDePagosService;
import uy.com.cvaucher.services.services.CuentasService;
import uy.com.cvaucher.services.services.PagoTarjetaService;
import uy.com.cvaucher.services.services.PagoEfectivoService;
import uy.com.cvaucher.services.services.DomainUserService;
import uy.com.cvaucher.services.services.LoginService;
import uy.com.cvaucher.services.services.RolesService;
import uy.com.cvaucher.services.services.CajaService;
import uy.com.cvaucher.services.services.GrupoCuentasService;
import uy.com.cvaucher.services.services.AsientoContableService;
import uy.com.cvaucher.services.services.ImpuestoService;
/*
import javax.sql.DataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
*/
/**
 * @author Raul Hernandez
 *
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("uy.com.cvaucher.services")
public class RootContextConfig {
	
	@Autowired
	private TipoTratamientoService tipoTratamientoService;
	
	@Autowired
	private AgendaService agendaService;
	
	@Autowired
	private DireccionService direccionService;
	
	@Autowired
	private HistoriaClinicaService historiaClinicaService;
	
	@Autowired
	private PacientesService pacientesService;
	
	@Autowired
	private SeguimientoPacientesService seguimientoPacientesService;
	
	@Autowired
	private SesionRealizadaService sesionRealizadaService;
	
	@Autowired
	private TipoAgendaService tipoAgendaService;
	
	@Autowired
	private TratamientoService tratamientoService;
	
	@Autowired
	private TratamientoPacienteService tratamientoPacienteService;
	
	@Autowired
	private HistorialPagosService historialPagosService;
	
	@Autowired
	private ListaPreciosService listaPreciosService;
	
	@Autowired
	private AuxPreciosService auxPreciosService;
	
	@Autowired
	private FormasDePagosService formasDePagosService;
	
	@Autowired
	private CuentasService cuentasService;
	
	@Autowired
	private PagoTarjetaService pagoTarjetaService;
	
	@Autowired
	private PagoEfectivoService pagoEfectivoService;
	
	@Autowired
	private DomainUserService domainUserService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private RolesService rolesService;
	
	@Autowired
	private CajaService cajaService;
	
	@Autowired
	private GrupoCuentasService grupoCuentasService;
	
	@Autowired
	private AsientoContableService asientoContableService;
	
	@Autowired
	private ImpuestoService impuestoService;
	
	@Bean(name="/cvaucher.impuesto")
	public HttpInvokerServiceExporter httpImpuestoService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(impuestoService);
		httpInvokerServiceExporter.setServiceInterface(ImpuestoService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.asientoContable")
	public HttpInvokerServiceExporter httpAsientoContableService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(asientoContableService);
		httpInvokerServiceExporter.setServiceInterface(AsientoContableService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.grupoCuentas")
	public HttpInvokerServiceExporter httpGrupoCuentasService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(grupoCuentasService);
		httpInvokerServiceExporter.setServiceInterface(GrupoCuentasService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.caja")
	public HttpInvokerServiceExporter httpCajaService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(cajaService);
		httpInvokerServiceExporter.setServiceInterface(CajaService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.roles")
	public HttpInvokerServiceExporter httpRolesService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(rolesService);
		httpInvokerServiceExporter.setServiceInterface(RolesService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.login")
	public HttpInvokerServiceExporter httpLoginService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(loginService);
		httpInvokerServiceExporter.setServiceInterface(LoginService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.domainUser")
	public HttpInvokerServiceExporter httpDomainUserService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(domainUserService);
		httpInvokerServiceExporter.setServiceInterface(DomainUserService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.pagoEfectivo")
	public HttpInvokerServiceExporter httpPagoEfectivoService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(pagoEfectivoService);
		httpInvokerServiceExporter.setServiceInterface(PagoEfectivoService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.pagoTarjeta")
	public HttpInvokerServiceExporter httpPagoTarjetaService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(pagoTarjetaService);
		httpInvokerServiceExporter.setServiceInterface(PagoTarjetaService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.cuentas")
	public HttpInvokerServiceExporter httpCuentasService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(cuentasService);
		httpInvokerServiceExporter.setServiceInterface(CuentasService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.formasDePagos")
	public HttpInvokerServiceExporter httpFormasDePagosService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(formasDePagosService);
		httpInvokerServiceExporter.setServiceInterface(FormasDePagosService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.auxPrecios")
	public HttpInvokerServiceExporter httpAuxPreciosService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(auxPreciosService);
		httpInvokerServiceExporter.setServiceInterface(AuxPreciosService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.listaPrecios")
	public HttpInvokerServiceExporter httpListaPreciosService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(listaPreciosService);
		httpInvokerServiceExporter.setServiceInterface(ListaPreciosService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.historialPagos")
	public HttpInvokerServiceExporter httpHistorialPagosService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(historialPagosService);
		httpInvokerServiceExporter.setServiceInterface(HistorialPagosService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.tratamientoPaciente")
	public HttpInvokerServiceExporter httpTratamientoPacienteService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(tratamientoPacienteService);
		httpInvokerServiceExporter.setServiceInterface(TratamientoPacienteService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.tratamiento")
	public HttpInvokerServiceExporter httpTratamientoService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(tratamientoService);
		httpInvokerServiceExporter.setServiceInterface(TratamientoService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.tipoAgenda")
	public HttpInvokerServiceExporter httpTipoAgendaService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(tipoAgendaService);
		httpInvokerServiceExporter.setServiceInterface(TipoAgendaService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.sesionRealizada")
	public HttpInvokerServiceExporter httpSesionRealizadaService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(sesionRealizadaService);
		httpInvokerServiceExporter.setServiceInterface(SesionRealizadaService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.pacientes")
	public HttpInvokerServiceExporter httpPacientesService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(pacientesService);
		httpInvokerServiceExporter.setServiceInterface(PacientesService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.seguimientopacientes")
	public HttpInvokerServiceExporter httpSeguimientoPacientesService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(seguimientoPacientesService);
		httpInvokerServiceExporter.setServiceInterface(SeguimientoPacientesService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.tipotratamiento")
	public HttpInvokerServiceExporter httpTipoTratamientoService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		
		httpInvokerServiceExporter.setService(tipoTratamientoService);
		httpInvokerServiceExporter.setServiceInterface(TipoTratamientoService.class);
		
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.agenda")
	public HttpInvokerServiceExporter httpAgendaService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter= new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(agendaService);
		httpInvokerServiceExporter.setServiceInterface(AgendaService.class);
		
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.direccion")
	public HttpInvokerServiceExporter httpDireccionService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter= new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(direccionService);
		httpInvokerServiceExporter.setServiceInterface(DireccionService.class);
		
		return httpInvokerServiceExporter;
	}
	
	@Bean(name="/cvaucher.historiaclinica")
	public HttpInvokerServiceExporter httpHistoriaClinicaService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter= new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(historiaClinicaService);
		httpInvokerServiceExporter.setServiceInterface(HistoriaClinicaService.class);
		
		return httpInvokerServiceExporter;
	}
	
}
