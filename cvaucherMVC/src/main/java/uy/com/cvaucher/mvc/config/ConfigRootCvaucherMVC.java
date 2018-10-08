package uy.com.cvaucher.mvc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.security.remoting.httpinvoker.AuthenticationSimpleHttpInvokerRequestExecutor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import uy.com.cvaucher.services.services.AgendaService;
import uy.com.cvaucher.services.services.AsientoContableService;
import uy.com.cvaucher.services.services.AuxPreciosService;
import uy.com.cvaucher.services.services.CajaService;
import uy.com.cvaucher.services.services.CuentasService;
import uy.com.cvaucher.services.services.DireccionService;
import uy.com.cvaucher.services.services.DomainUserService;
import uy.com.cvaucher.services.services.FormasDePagosService;
import uy.com.cvaucher.services.services.GrupoCuentasService;
import uy.com.cvaucher.services.services.HistoriaClinicaService;
import uy.com.cvaucher.services.services.HistorialPagosService;
import uy.com.cvaucher.services.services.ImpuestoService;
import uy.com.cvaucher.services.services.ListaPreciosService;
import uy.com.cvaucher.services.services.LoginService;
import uy.com.cvaucher.services.services.PacientesService;
import uy.com.cvaucher.services.services.PagoEfectivoService;
import uy.com.cvaucher.services.services.PagoTarjetaService;
import uy.com.cvaucher.services.services.RolesService;
import uy.com.cvaucher.services.services.SeguimientoPacientesService;
import uy.com.cvaucher.services.services.SesionesService;
import uy.com.cvaucher.services.services.TipoTratamientoService;
import uy.com.cvaucher.services.services.TratamientoPacienteService;
import uy.com.cvaucher.services.services.TratamientoService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="uy.com.cvaucher")
public class ConfigRootCvaucherMVC implements WebMvcConfigurer {
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${spring.remouting.url}")
	private String remoutingUrl;
	
	@Value("${spring.remouting.context}")
	private String remoutingContext;
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public AuthenticationSimpleHttpInvokerRequestExecutor httpInvokerRequestExecutor() {
		return new AuthenticationSimpleHttpInvokerRequestExecutor();
	}
	
	@Bean(name="dataSource")
	public DriverManagerDataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	
	@Bean(name="agendaService")
    public HttpInvokerProxyFactoryBean agendaService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.agenda");
        invoker.setServiceInterface(AgendaService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="tipoTratamientoService")
    public HttpInvokerProxyFactoryBean tipoTratamientoService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.tipotratamiento");
        invoker.setServiceInterface(TipoTratamientoService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="tratamientoService")
    public HttpInvokerProxyFactoryBean tratamientoService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.tratamiento");
        invoker.setServiceInterface(TratamientoService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="pacientesService")
    public HttpInvokerProxyFactoryBean pacientesService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.pacientes");
        invoker.setServiceInterface(PacientesService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="direccionService")
    public HttpInvokerProxyFactoryBean direccionService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.direccion");
        invoker.setServiceInterface(DireccionService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="sesionesService")
    public HttpInvokerProxyFactoryBean sesionesService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.sesiones");
        invoker.setServiceInterface(SesionesService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="seguimientoPacientesService")
    public HttpInvokerProxyFactoryBean seguimientoPacientesService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.seguimientopacientes");
        invoker.setServiceInterface(SeguimientoPacientesService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="historiaClinicaService")
    public HttpInvokerProxyFactoryBean historiaClinicaService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.historiaclinica");
        invoker.setServiceInterface(HistoriaClinicaService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="tratamientoPacienteService")
    public HttpInvokerProxyFactoryBean tratamientoPacienteService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.tratamientoPaciente");
        invoker.setServiceInterface(TratamientoPacienteService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="historialPagosService")
    public HttpInvokerProxyFactoryBean historialPagosService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.historialPagos");
        invoker.setServiceInterface(HistorialPagosService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="listaPreciosService")
    public HttpInvokerProxyFactoryBean listaPreciosService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.listaPrecios");
        invoker.setServiceInterface(ListaPreciosService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="auxPreciosService")
    public HttpInvokerProxyFactoryBean auxPreciosService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.auxPrecios");
        invoker.setServiceInterface(AuxPreciosService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="formasDePagosService")
    public HttpInvokerProxyFactoryBean formasDePagosService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.formasDePagos");
        invoker.setServiceInterface(FormasDePagosService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="cuentasService")
    public HttpInvokerProxyFactoryBean cuentasService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.cuentas");
        invoker.setServiceInterface(CuentasService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="grupoCuentasService")
    public HttpInvokerProxyFactoryBean grupoCuentasService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.grupoCuentas");
        invoker.setServiceInterface(GrupoCuentasService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	
	@Bean(name="pagoTarjetaService")
    public HttpInvokerProxyFactoryBean pagoTarjetaService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.pagoTarjeta");
        invoker.setServiceInterface(PagoTarjetaService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="pagoEfectivoService")
    public HttpInvokerProxyFactoryBean pagoEfectivoService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.pagoEfectivo");
        invoker.setServiceInterface(PagoEfectivoService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="domainUserService")
    public HttpInvokerProxyFactoryBean domainUserService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.domainUser");
        invoker.setServiceInterface(DomainUserService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="loginService")
    public HttpInvokerProxyFactoryBean loginService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.login");
        invoker.setServiceInterface(LoginService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="rolesService")
    public HttpInvokerProxyFactoryBean rolesService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.roles");
        invoker.setServiceInterface(RolesService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="cajaService")
    public HttpInvokerProxyFactoryBean cajaService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.caja");
        invoker.setServiceInterface(CajaService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="asientoContableService")
    public HttpInvokerProxyFactoryBean asientoContableService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.asientoContable");
        invoker.setServiceInterface(AsientoContableService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
	@Bean(name="impuestoService")
    public HttpInvokerProxyFactoryBean impuestoService() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(remoutingUrl+remoutingContext+"/cvaucher.impuesto");
        invoker.setServiceInterface(ImpuestoService.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor());
        
        return invoker;
    }
	
}
