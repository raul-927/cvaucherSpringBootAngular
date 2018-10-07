package uy.com.cvaucher.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uy.com.cvaucher.mvc.impl.SearchPacientesControllerImpl;
import uy.com.cvaucher.services.clases.SearchPacientes;
import uy.com.cvaucher.services.domain.Pacientes;
import uy.com.cvaucher.services.services.AgendaService;
import uy.com.cvaucher.services.services.DireccionService;
import uy.com.cvaucher.services.services.HistoriaClinicaService;
import uy.com.cvaucher.services.services.PacientesService;
import uy.com.cvaucher.services.services.SeguimientoPacientesService;
import uy.com.cvaucher.services.services.SesionesService;
import uy.com.cvaucher.services.services.TratamientoService;


@Controller
@Secured({"ROLE_USER", "ROLE_ADMIN"})
@RequestMapping("/pacsearch")
public class SearchPacientesController// implements SearchPacientesControllerImpl
{
	
	private final PacientesService 	pacientesServices;
	
	@Autowired
	public SearchPacientesController(PacientesService pacientesServices, 
			  DireccionService direccionServices, 
			  SesionesService sesionesServices,
			  HistoriaClinicaService historiaClinicaServices, 
			  SeguimientoPacientesService seguimientoPacientesServices,
			  TratamientoService tratamientoServices,
			  AgendaService agendaServices){

		this.pacientesServices 	= pacientesServices;

}
	
	@RequestMapping(method = RequestMethod.GET)
	public String ShowSearchPacientes(Model model)
	{
		UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().
		getPrincipal();
		System.out.println("Bien venido "+user.getUsername()+ ", usted tiene el rol "+user.getAuthorities() +", Su Password es = "+user.getPassword());
		model.addAttribute("userName",user.getUsername());
		model.addAttribute("userRole",user.getAuthorities());
		model.addAttribute(new Pacientes());
		model.addAttribute(new SearchPacientes());
		model.addAttribute("pac", this.pacientesServices.findAllPacientes());
		//model.addAttribute("pacientesS",this.pacientesSearch.values());
		
		return "pacientes/searchPacientes";
	}
	
//	@RequestMapping(value ="/prueba", method = RequestMethod.POST)
//	public void ShowSearchPacientes2(Model model){
//		System.out.println("Esto es una prueba");
//	}
	
	@RequestMapping(value ="/search",method = RequestMethod.POST)
	public String searchPacientes(Model model,@Valid SearchPacientes searchPacientes, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			
			return "pacientes/searchPacientes";
		}
		
		//model.addAttribute(new Pacientes());
		model.addAttribute(new SearchPacientes());
		model.addAttribute("pac", this.pacientesServices.findPacientes(searchPacientes));
		return "pacientes/searchPacientes";
	}

}
