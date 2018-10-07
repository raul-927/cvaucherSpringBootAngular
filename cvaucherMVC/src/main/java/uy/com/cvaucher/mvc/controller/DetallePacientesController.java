package uy.com.cvaucher.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uy.com.cvaucher.services.services.DireccionService;
import uy.com.cvaucher.services.services.HistoriaClinicaService;
import uy.com.cvaucher.services.services.PacientesService;
import uy.com.cvaucher.services.services.PagoEfectivoService;
import uy.com.cvaucher.services.services.SeguimientoPacientesService;
import uy.com.cvaucher.services.services.SesionesService;
import uy.com.cvaucher.services.services.TratamientoService;
import uy.com.cvaucher.services.services.AgendaService;
import uy.com.cvaucher.services.services.CajaService;
import uy.com.cvaucher.services.services.TratamientoPacienteService;
import uy.com.cvaucher.services.services.HistorialPagosService;
import uy.com.cvaucher.services.domain.Caja;
import uy.com.cvaucher.services.domain.HistorialPagos;
import uy.com.cvaucher.services.domain.Pacientes;
import uy.com.cvaucher.services.domain.PagoEfectivo;
import uy.com.cvaucher.services.domain.TratamientoPaciente;
import uy.com.cvaucher.services.domain.SeguimientoPacientes;



@Controller
@RequestMapping("/detallep")
public class DetallePacientesController 
{
	
	private final PacientesService 			pacientesServices;
	private final DireccionService 				direccionServices;
	private final HistoriaClinicaService 		historiaClinicaServices;
	private final AgendaService					agendaService;
	private final TratamientoPacienteService	tratamientoPacienteServices;
	private final HistorialPagosService			historialPagosServices;
	private final SeguimientoPacientesService	seguimientoPacientesServices;
	private final PagoEfectivoService			pagoEfectivoServices;
	private final CajaService					cajaServices;
	@Autowired
	public DetallePacientesController(PacientesService				pacientesServices, 
									  DireccionService 				direccionServices, 
									  SesionesService 				sesionesServices,
									  HistoriaClinicaService 		historiaClinicaServices, 
									  TratamientoService 			tratamientoServices,
									  AgendaService 				agendaService,
									  TratamientoPacienteService	tratamientoPacienteServices,
									  HistorialPagosService			historialPagosServices,
									  SeguimientoPacientesService	seguimientoPacientesServices,
									  PagoEfectivoService			pagoEfectivoServices,
									  CajaService					cajaServices){
		
		this.pacientesServices 				= pacientesServices;
		this.direccionServices 				= direccionServices;
		this.historiaClinicaServices 		= historiaClinicaServices;
		this.agendaService					= agendaService;
		this.tratamientoPacienteServices	= tratamientoPacienteServices;
		this.historialPagosServices			= historialPagosServices;
		this.seguimientoPacientesServices	= seguimientoPacientesServices;
		this.pagoEfectivoServices			= pagoEfectivoServices;
		this.cajaServices					= cajaServices;
	}
	
	@RequestMapping(value ="/detPac/{pacCedula}", method = RequestMethod.GET)
	public String showDetallePacientes(Model model,  @PathVariable("pacCedula") int pacCedula)
	{
	
		Pacientes pacientes = 			this.pacientesServices.findPacientesByCedula(pacCedula);
		
		model.addAttribute("pacien",	this.pacientesServices.findPacientesByCedula(pacientes.getCedula()));
		model.addAttribute("direc", 	this.direccionServices.findDireccionByCedula(pacientes.getCedula()));
		model.addAttribute("ag", 		this.agendaService.findAgendaById(pacientes.getCedula()));
		model.addAttribute("historiaC", this.historiaClinicaServices.findHistoriaClinicaByCedula(pacientes.getCedula()));
		model.addAttribute("tratPac", 	this.tratamientoPacienteServices.findTratamientoPacienteByCedula(pacientes.getCedula()));
		
		return "pacientes/detallePacientes";
	}
	
	@RequestMapping(value ="/detPac/{pacCedula}/{histTratPacId}", method = RequestMethod.GET)
	public String showPacienteTratamientoPago(Model model, @PathVariable("pacCedula")	int pacCedula, 
															  @PathVariable("histTratPacId")int histTratPacId)
	{
		Date hoy = new Date();
		String patron = "YYYY-MM-dd";
		SimpleDateFormat formato = new SimpleDateFormat(patron);
		String salida = formato.format(hoy);
		
		model.addAttribute(new HistorialPagos());
		model.addAttribute(new SeguimientoPacientes());
		model.addAttribute("histPagosByTratPacId", this.historialPagosServices.findHistorialPagoByHistTratPacId(histTratPacId));
		model.addAttribute("segP", this.seguimientoPacientesServices.findSeguimientoPacientesByTratPacId(histTratPacId));
		model.addAttribute("salida", salida);
		return "tratamientoPaciente/tratamientoPacienteDetalle";
	}
	
	@RequestMapping(value ="/detPac/{pacCedula}/{histTratPacId}",params = "pagos", method = RequestMethod.POST)
	public String insertPacienteTratamientoPago(Model model, @PathVariable("pacCedula")	int pacCedula, 
			  @PathVariable("histTratPacId")int histTratPacId, @Valid HistorialPagos historialPagos, BindingResult bindingResult)
	{
		Date hoy = new Date();
		String patron = "YYYY-MM-dd";
		SimpleDateFormat formato = new SimpleDateFormat(patron);
		String salida = formato.format(hoy);
		if(bindingResult.hasErrors())
		{
			System.out.println("Error en insertPacienteTratamientoPago");
			model.addAttribute(new HistorialPagos());
			model.addAttribute(new SeguimientoPacientes());
			model.addAttribute("histPagosByTratPacId", this.historialPagosServices.findHistorialPagoByHistTratPacId(histTratPacId));
			model.addAttribute("segP", this.seguimientoPacientesServices.findSeguimientoPacientesByTratPacId(histTratPacId));
			model.addAttribute("salida", salida);
			return "tratamientoPaciente/tratamientoPacienteDetalle";
		}
		
		Caja caja = this.cajaServices.cargoCajaActual();
		historialPagos.setHistPagosCajaId(caja.getCajaId());
		historialPagos.setHistTratPacId(histTratPacId);
		if(historialPagos.getHistPagosMonto()!= 0)
		{
			String tipoPago = "CRED";
			historialPagos.setHistPagosTipo(tipoPago);
			PagoEfectivo pagoEfectivo = new PagoEfectivo();
			pagoEfectivo.setPagoEfCedula(pacCedula);
			pagoEfectivo.setPagoEfDesc(tipoPago);
			pagoEfectivo.setPagoEfId(histTratPacId);
			pagoEfectivo.setPagoEfImporte(historialPagos.getHistPagosMonto());
			this.historialPagosServices.insertHistorialPago(historialPagos);
			this.pagoEfectivoServices.insertPagoEfectivo(pagoEfectivo);
			
		}
		
		int tratPacId = histTratPacId;
		TratamientoPaciente tratamientoPaciente  = new TratamientoPaciente();
		SeguimientoPacientes seguimientoPacientes = new SeguimientoPacientes();
		seguimientoPacientes.setTratPacId(tratPacId);
		tratamientoPaciente.setTratPacId(tratPacId);
		tratamientoPaciente.setImportePagado(historialPagos.getHistPagosMonto());
		this.tratamientoPacienteServices.updateTratamientoPacienteImporte(tratamientoPaciente);
		
		model.addAttribute(new HistorialPagos());
		model.addAttribute(new SeguimientoPacientes());
		model.addAttribute("histPagosByTratPacId", this.historialPagosServices.findHistorialPagoByHistTratPacId(histTratPacId));
		model.addAttribute("segP", this.seguimientoPacientesServices.findSeguimientoPacientesByTratPacId(histTratPacId));
		model.addAttribute("salida", salida);
		return "tratamientoPaciente/tratamientoPacienteDetalle";
	}
	
	@RequestMapping(value ="/detPac/{pacCedula}/{histTratPacId}",params = "seg", method = RequestMethod.POST)
	public String insertPacienteTratamientoSeguimiento(Model model, @PathVariable("pacCedula")	int pacCedula, 
			  @PathVariable("histTratPacId")int histTratPacId, @Valid SeguimientoPacientes seguimientoPacientes, BindingResult bindingResult)
	{
		Date hoy = new Date();
		String patron = "YYYY-MM-dd";
		SimpleDateFormat formato = new SimpleDateFormat(patron);
		String salida = formato.format(hoy);
		seguimientoPacientes.setTratPacId(histTratPacId);
		if(bindingResult.hasErrors())
		{
			System.out.println("Error en insertPacienteTratamientoSeguimientoPaciente");
			model.addAttribute(new HistorialPagos());
			model.addAttribute(new SeguimientoPacientes());
			model.addAttribute("histPagosByTratPacId", this.historialPagosServices.findHistorialPagoByHistTratPacId(histTratPacId));
			model.addAttribute("segP", this.seguimientoPacientesServices.findSeguimientoPacientesByTratPacId(histTratPacId));
			model.addAttribute("salida", salida);
			return "tratamientoPaciente/tratamientoPacienteDetalle";
		}
		int tratPacId = histTratPacId;
		TratamientoPaciente tratamientoPaciente  = new TratamientoPaciente();
		
		tratamientoPaciente.setTratPacId(tratPacId);

		this.seguimientoPacientesServices.insertSeguimientoPacientes(seguimientoPacientes);
		model.addAttribute(new HistorialPagos());
		model.addAttribute(new SeguimientoPacientes());
		model.addAttribute("histPagosByTratPacId", this.historialPagosServices.findHistorialPagoByHistTratPacId(histTratPacId));
		model.addAttribute("segP", this.seguimientoPacientesServices.findSeguimientoPacientesByTratPacId(histTratPacId));
		model.addAttribute("salida", salida);
		return "tratamientoPaciente/tratamientoPacienteDetalle";
	}
	
	
}
