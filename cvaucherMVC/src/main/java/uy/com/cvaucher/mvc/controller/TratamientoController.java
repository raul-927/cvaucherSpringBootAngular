package uy.com.cvaucher.mvc.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uy.com.cvaucher.services.domain.Impuesto;
import uy.com.cvaucher.services.domain.Tratamiento;
import uy.com.cvaucher.services.services.TratamientoService;
import uy.com.cvaucher.services.services.ImpuestoService;
import uy.com.cvaucher.services.services.TipoTratamientoService;
import uy.com.cvaucher.services.enumerador.TipoImpuesto;

@Controller
@RequestMapping("/tratamiento")
public class TratamientoController 
{
	private ImpuestoService		   impuestoService;
	private final TratamientoService tratamientoService;
	private final TipoTratamientoService tipoTratamientoService;
	
	@Autowired
	public TratamientoController(TratamientoService tratamientoService, TipoTratamientoService tipoTratamientoService,ImpuestoService impuestoService)
	{
		this.tratamientoService = tratamientoService;
		this.tipoTratamientoService = tipoTratamientoService;
		this.impuestoService = impuestoService;
	}
	
	@RequestMapping(method = RequestMethod.GET, params ="insert")
	public String showInsertTratamiento(Model model)
	{
		Impuesto imp = new Impuesto();
		imp.setImpuestoDescAbrv("ECONOMICO");
		model.addAttribute(new Tratamiento());
		model.addAttribute("trat", tratamientoService.findAllTratamientos());
		model.addAttribute("tipoTrat", tipoTratamientoService.findAllTipoTratamiento());
		model.addAttribute("impuestos", impuestoService.findAllImpuestosByTipo(TipoImpuesto.ECONOMICO.toString()));
		
		return "tratamiento/insertTratamiento";
	}
	
	
	@RequestMapping(method = RequestMethod.POST, params ="insert")
	public String insertTratamiento(Model model, @Valid Tratamiento tratamiento, BindingResult bindingResult){
		Impuesto imp = new Impuesto();
		imp.setImpuestoDescAbrv("ECONOMICO");
		if(bindingResult.hasErrors()){
			model.addAttribute(new Tratamiento());
			System.out.println("Error en insertTratamiento");
			model.addAttribute("trat", tratamientoService.findAllTratamientos());
			model.addAttribute("tipoTrat", tipoTratamientoService.findAllTipoTratamiento());
			model.addAttribute("impuestos", impuestoService.findAllImpuestosByTipo(TipoImpuesto.ECONOMICO.toString()));
			
			return "tratamiento/insertTratamiento";
		}
		tratamientoService.insertTratamiento(tratamiento);
		model.addAttribute(new Tratamiento());
		model.addAttribute("trat", tratamientoService.findAllTratamientos());
		model.addAttribute("tipoTrat", tipoTratamientoService.findAllTipoTratamiento());
		model.addAttribute("impuestos", impuestoService.findAllImpuestosByTipo(TipoImpuesto.ECONOMICO.toString()));
		
		return "tratamiento/insertTratamiento";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, params ="update")
	public String showUpdateTratamiento(Model model){
		Impuesto imp = new Impuesto();
		imp.setImpuestoDescAbrv("ECONOMICO");
		model.addAttribute(new Tratamiento());
		model.addAttribute("trat", tratamientoService.findAllTratamientos());
		model.addAttribute("tipoTrat", tipoTratamientoService.findAllTipoTratamiento());
		model.addAttribute("impuestos", impuestoService.findAllImpuestosByTipo(TipoImpuesto.ECONOMICO.toString()));
		
		return "tratamiento/updateTratamiento";
	}
	
	
	@RequestMapping(method = RequestMethod.POST, params ="update")
	public String updateTratamiento(Model model, @Valid Tratamiento tratamiento, BindingResult bindingResult){
		Impuesto imp = new Impuesto();
		imp.setImpuestoDescAbrv("ECONOMICO");
		if(bindingResult.hasErrors()){
			System.out.println("Error en updateTratamiento");
			model.addAttribute(new Tratamiento());
			model.addAttribute("trat", tratamientoService.findAllTratamientos());
			model.addAttribute("tipoTrat", tipoTratamientoService.findAllTipoTratamiento());
			model.addAttribute("impuestos", impuestoService.findAllImpuestosByTipo(TipoImpuesto.ECONOMICO.toString()));
			
			return "tratamiento/updateTratamiento";
		}
		tratamientoService.updateTratamiento(tratamiento);
		model.addAttribute(new Tratamiento());
		model.addAttribute("trat", tratamientoService.findAllTratamientos());
		model.addAttribute("tipoTrat", tipoTratamientoService.findAllTipoTratamiento());
		model.addAttribute("impuestos", impuestoService.findAllImpuestosByTipo(TipoImpuesto.ECONOMICO.toString()));
		
		return "tratamiento/updateTratamiento";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, params ="delete")
	public String showDeleteTratamiento(Model model){
		Impuesto imp = new Impuesto();
		imp.setImpuestoDescAbrv("ECONOMICO");
		model.addAttribute(new Tratamiento());
		model.addAttribute("trat", tratamientoService.findAllTratamientos());
		model.addAttribute("tipoTrat", tipoTratamientoService.findAllTipoTratamiento());
		model.addAttribute("impuestos", impuestoService.findAllImpuestosByTipo(TipoImpuesto.ECONOMICO.toString()));
		
		return "tratamiento/deleteTratamiento";
	}
	
	
	@RequestMapping(method = RequestMethod.POST, params ="delete")
	public String deleteTratamiento(Model model, @Valid Tratamiento tratamiento, BindingResult bindingResult){
		Impuesto imp = new Impuesto();
		imp.setImpuestoDescAbrv("ECONOMICO");
		if(bindingResult.hasErrors()){
			System.out.println("Error en deleteTratamiento");
			model.addAttribute(new Tratamiento());
			model.addAttribute("trat", tratamientoService.findAllTratamientos());
			model.addAttribute("tipoTrat", tipoTratamientoService.findAllTipoTratamiento());
			model.addAttribute("impuestos", impuestoService.findAllImpuestosByTipo(TipoImpuesto.ECONOMICO.toString()));
			
			return "tratamiento/deleteTratamiento";
		}
		tratamientoService.deleteTratamiento(tratamiento.getTratId());
		model.addAttribute(new Tratamiento());
		model.addAttribute("trat", tratamientoService.findAllTratamientos());
		model.addAttribute("tipoTrat", tipoTratamientoService.findAllTipoTratamiento());
		model.addAttribute("impuestos", impuestoService.findAllImpuestosByTipo(TipoImpuesto.ECONOMICO.toString()));
		
		return "tratamiento/deleteTratamiento";
	}
	
	
}
