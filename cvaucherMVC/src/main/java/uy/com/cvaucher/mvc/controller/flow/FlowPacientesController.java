package uy.com.cvaucher.mvc.controller.flow;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uy.com.cvaucher.services.clases.DescCuentaFormaDePago;
import uy.com.cvaucher.services.clases.FormasDePagosDesc;
import uy.com.cvaucher.services.clases.MaxNumAsientoContable;
import uy.com.cvaucher.services.clases.SearchMaxTratPacId;
import uy.com.cvaucher.services.domain.Agenda;
import uy.com.cvaucher.services.domain.AsientoContable;
import uy.com.cvaucher.services.domain.Caja;
import uy.com.cvaucher.services.domain.Cuentas;
import uy.com.cvaucher.services.domain.Direccion;
import uy.com.cvaucher.services.domain.FormasDePagos;
import uy.com.cvaucher.services.domain.HistoriaClinica;
import uy.com.cvaucher.services.domain.MaxTratPacId;
import uy.com.cvaucher.services.domain.Pacientes;
import uy.com.cvaucher.services.domain.PagoCredito;
import uy.com.cvaucher.services.domain.PagoEfectivo;
import uy.com.cvaucher.services.domain.PagoTarjeta;
import uy.com.cvaucher.services.domain.TratByList;
import uy.com.cvaucher.services.domain.TratPacByCedula;
import uy.com.cvaucher.services.domain.Tratamiento;
import uy.com.cvaucher.services.domain.TratamientoPaciente;
import uy.com.cvaucher.services.enumerador.CuentaTipo;
import uy.com.cvaucher.services.services.AgendaService;
import uy.com.cvaucher.services.services.AsientoContableService;
import uy.com.cvaucher.services.services.CajaService;
import uy.com.cvaucher.services.services.CuentasService;
import uy.com.cvaucher.services.services.DireccionService;
import uy.com.cvaucher.services.services.FormasDePagosService;
import uy.com.cvaucher.services.services.HistoriaClinicaService;
import uy.com.cvaucher.services.services.ImpuestoService;
import uy.com.cvaucher.services.services.PacientesService;
import uy.com.cvaucher.services.services.TratamientoService;
import uy.com.cvaucher.services.services.TratamientoPacienteService;

@Controller
public class FlowPacientesController 
{
	private final PacientesService 				pacientesService;
	private final TratamientoService			tratamientoService;
	private final DireccionService				direccionService;
	private final AgendaService 				agendaService;
	private final HistoriaClinicaService		historiaClinicaService;
	private final TratamientoPacienteService	tratamientoPacienteService;
	private final FormasDePagosService			formasDePagosService;
	private final AsientoContableService		asientoContableService;
	private final CajaService					cajaService;
	private final CuentasService				cuentasService;
	private  static Pacientes 				pacientes ;
	private String 							fechaAux;
	private BigDecimal 						total = new BigDecimal("00");
	private TratamientoPaciente				tratamientoPaciente;
	private FormasDePagosDesc				formasDePagosDesc;
	
	
	@Autowired
	public FlowPacientesController(PacientesService			pacientesService, 
									DireccionService 			direccionService,
									AgendaService 				agendaService,
									TratamientoService			tratamientoService,
									HistoriaClinicaService		historiaClinicaService,
									TratamientoPacienteService 	tratamientoPacienteService,
									FormasDePagosService		formasDePagosService,
									AsientoContableService 		asientoContableService,
									CajaService					cajaService,
									CuentasService				cuentasService,
									ImpuestoService				impuestoService)
	{
		this.pacientesService			 = pacientesService;
		this.tratamientoService		 = tratamientoService;
		this.direccionService 			 = direccionService;
		this.agendaService 			 = agendaService;
		this.historiaClinicaService 	 = historiaClinicaService;
		this.tratamientoPacienteService = tratamientoPacienteService;
		this.formasDePagosService 		 = formasDePagosService;
		this.asientoContableService	 = asientoContableService;
		this.cajaService 				 = cajaService;
		this.cuentasService			 = cuentasService;
	}
	
	public void insertPacientes(Pacientes pacientes)
	{
		this.pacientesService.insertPacientes(pacientes);
		
	}
	
	public void insertDireccion(Direccion direccion)
	{
		this.direccionService.insertDireccion(direccion);
	}
	
	public void insertAgenda(Agenda agenda)
	{
		this.agendaService.insertAgenda(agenda);
	}
	
	public void insertHistoriaClinica(HistoriaClinica historiaClinica)
	{
		this.historiaClinicaService.insertHistoriaClinica(historiaClinica);
	}
	
	public void insertTratamientoPaciente(TratamientoPaciente tratamientoPaciente)
	{
		this.tratamientoPaciente = tratamientoPaciente;
		this.tratamientoPacienteService.insertTratamientoPaciente(this.tratamientoPaciente);
	}
	
	public void setTratamientoPaciente(TratamientoPaciente tratamientoPaciente)
	{
		this.tratamientoPaciente = tratamientoPaciente;
		
	}
	public TratamientoPaciente getTratamientoPaciente()
	{
		return this.tratamientoPaciente;
	}
	
	public List<Direccion>findDireccionByCedula(int pacCedula)
	{
		List<Direccion> direc = this.direccionService.findDireccionByCedula(pacCedula);
		return direc;
	}
	
	public List<Agenda> findAgendaByCedula(int cedula)
	{
		List<Agenda>age = this.agendaService.findAgendaByCedula(cedula);
		return age;
	}
	
	public List<TratPacByCedula> findTratamientoPacienteByCedula(int cedula)
	{
		List<TratPacByCedula> tratPac = this.tratamientoPacienteService.findTratamientoPacienteByCedula(cedula);
		return tratPac;
	}
	
	public List<Tratamiento> findNewTratamientos()
	{
		return this.tratamientoService.findNewTratamiento();
	}
	
	public Tratamiento findTratamientoById(int tratId)
	{
		return this.tratamientoService.findTratamientoById(tratId);
	}
	
	public int findSesionesByTratamiento(int tratId)
	{
		return this.tratamientoService.findSesionesByTratamientoId(tratId);
	}
	
	public List<Tratamiento> findAllTratamientos()
	{
		List<Tratamiento> tratamiento =  this.tratamientoService.findAllTratamientos();
		return tratamiento;
	}

	public Pacientes findPacientesByCedula(int cedula)
	{
		return this.pacientesService.findPacientesByCedula(cedula);
	}
	
	@RequestMapping(value ="/detallep/detPac/{pacCedula}", params ="actualizar", method = RequestMethod.GET)
	public String showIngresarTratamientoMain(Model model, @PathVariable("pacCedula") int pacCedula)
	{
		pacientes = pacientesService.findPacientesByCedula(pacCedula);
		TratamientoPaciente tratamientoPaciente  = new TratamientoPaciente();
		tratamientoPaciente.setPacientes(pacientes);
		model.addAttribute(tratamientoPaciente);
		//model.addAttribute("tratP", tratamientoServices.findAllTratamientos());
		
		return "redirect:/tratamientos";
	}
	
	@RequestMapping(value ="/detallep/detPac/{pacCedula}/{histTratPacId}", params ="actualizar", method = RequestMethod.GET)
	public String showIngresarTratamientoEnTratamiento(Model model, @PathVariable("pacCedula") int pacCedula)
	{
		
		pacientes = pacientesService.findPacientesByCedula(pacCedula);
		
		TratamientoPaciente tratamientoPaciente  = new TratamientoPaciente();
		tratamientoPaciente.setPacientes(pacientes);
		model.addAttribute(tratamientoPaciente);
		model.addAttribute("tratP", this.tratamientoService.findAllTratamientoByActualList());
		
		return "redirect:/tratamientos";
	}
	
	public List<TratByList>findAllTratamientoByActualList()
	{
		return this.tratamientoService.findAllTratamientoByActualList();
	}
	
	public static void setPacientes(Pacientes pacientes)
	{
		FlowPacientesController.pacientes = pacientes;
	}
	
	public  static Pacientes returnPacientes()
	{
		return pacientes;
	}
	public String getFecha()
	{
		Date hoy = new Date();
		String patron = "YYYY-MM-dd";
		SimpleDateFormat formato = new SimpleDateFormat(patron);
		String salida = formato.format(hoy);
		System.out.println("Fecha: "+salida);
		return salida;
	}
	
	public MaxTratPacId findMaxTratPacId(SearchMaxTratPacId searchMaxTratPacId)
	{
		MaxTratPacId aux = this.tratamientoPacienteService.findMaxTratPacId(searchMaxTratPacId);
		return aux;
	}
	
	public TratByList findTratamientoByActualListById(int tratId)
	{
		return this.tratamientoService.findTratamientoByActualListById(tratId);
	}
	
	public void setFechaAux(String fecha)
	{
		this.fechaAux = fecha;
	}
	
	public String getFechaAux()
	{
		return this.fechaAux;
	}
	
	public List<FormasDePagos> findAllFormasDePagos()
	{	
		return this.formasDePagosService.findAllFormasDePagos(null);
	}
	
	public FormasDePagosDesc findFormPagoTipoByDesc(String formPagAbreviacion)
	{
		this.formasDePagosDesc = this.formasDePagosService.findFormPagoTipoByDesc(formPagAbreviacion);
		return this.formasDePagosService.findFormPagoTipoByDesc(formPagAbreviacion);
	}
	
	public FormasDePagos findAllFormasDePagoById(FormasDePagos formasDePagos){
		return (FormasDePagos) this.formasDePagosService.findAllFormasDePagos(formasDePagos);
	}
	
	public void insertTratamientoPagoTarjeta(TratamientoPaciente tratamientoPaciente, PagoTarjeta pagoTarjeta, FormasDePagosDesc formasDePagoDesc)
	{
		
		this.insertAsientoContable(pagoTarjeta,tratamientoPaciente, formasDePagoDesc);
		
	}
	
	public void insertTratamientoPagoEfectivo(TratamientoPaciente tratamientoPaciente, PagoEfectivo pagoEfectivo,  FormasDePagosDesc formasDePagoDesc)
	{	
		
		this.insertAsientoContable(pagoEfectivo,tratamientoPaciente, formasDePagoDesc);
		
	}
	
	public void insertTratamientoPagoCredito(TratamientoPaciente tratamientoPaciente, PagoCredito pagoCredito,  FormasDePagosDesc formasDePagoDesc)
	{
		MaxNumAsientoContable pagoEfAsientoNro = this.asientoContableService.maxNumAsientoContable();
		int cuentaId = formasDePagoDesc.getFormasDePagoCuenta();
		DescCuentaFormaDePago desCuentaFormaDePago = this.formasDePagosService.cuentaFormaDePagoDesc(cuentaId);
		String pagoEfCuenta = desCuentaFormaDePago.getCuentaDesc();
		
		Caja cajaActual  = this.cajaService.cargoCajaActual();
		System.out.println("cajaActual.getCajaId() ==>> "+cajaActual.getCajaId());
		pagoCredito.setPagoCredCajaId(cajaActual.getCajaId());
		pagoCredito.setPagoCredCuenta(pagoEfCuenta);
		pagoCredito.setAsientoNro(pagoEfAsientoNro.getMaxNum());
		this.insertAsientoContable(pagoCredito, tratamientoPaciente, formasDePagoDesc);
		//this.formasDePagosService.insertTratamientoPagoCredito(tratamientoPaciente, pagoCredito, formasDePagoDesc.getFormasDePagoCuenta());
	}
	
	public FormasDePagosDesc getFormasDePagosDesc(){
		return this.formasDePagosDesc;
	}
	public Caja cargoCajaActual(){
		Caja caja = this.cajaService.cargoCajaActual();
		return caja;
	}
	public MaxNumAsientoContable maxNumAsientoContable(){
		return this.asientoContableService.maxNumAsientoContable();
	}
	
	private void insertAsientoContable(Object formaDePago,TratamientoPaciente tratamientoPaciente, FormasDePagosDesc formasDePagoDesc){
		this.asientoContableService.ingresarAsientoContable(formaDePago, tratamientoPaciente, formasDePagoDesc);
	}
	
	public void procesoAsientoContable(){
		Caja caja = this.cajaService.cargoCajaActual();
		
	}
}
