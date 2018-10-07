package uy.com.cvaucher.mvc.controller
;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import uy.com.cvaucher.services.services.AgendaService;
import uy.com.cvaucher.services.domain.Agenda;

import uy.com.cvaucher.services.enumerador.TipoAgenda;



//@Controller
//@RequestMapping("/agenda")
public class AgendaController 
{
	private final AgendaService agendaService;
	//@Autowired
	public AgendaController(AgendaService agendaService)
	{
		this.agendaService = agendaService;
	}
	
	
	
	//@RequestMapping(method = RequestMethod.GET, params = "insert")
	public String showInsertAgenda(Model model, TipoAgenda tipoAgenda)
	{
		model.addAttribute(new Agenda());
		model.addAttribute("age", agendaService.findAllAgenda());
		model.addAttribute("tipage", TipoAgenda.values());
		
		return "agenda/insertAgenda";
	}
	
	//@RequestMapping(method = RequestMethod.POST, params = "insert")
	public String insertAgenda(Model model, @Valid Agenda agenda, BindingResult bindingResult)
	{
		
		if(bindingResult.hasErrors())
		{
			System.out.println("Error en insertAgenda "+bindingResult.getAllErrors());
			model.addAttribute("age", agendaService.findAllAgenda());
			model.addAttribute("tipage", TipoAgenda.values());
			
			return "agenda/insertAgenda";
		}
		agendaService.insertAgenda(agenda);
		model.addAttribute("age", agendaService.findAllAgenda());
		model.addAttribute("tipage", TipoAgenda.values());
		
		return "agenda/insertAgenda";
	
	}
	
	
	
	//@RequestMapping(method = RequestMethod.GET, params = "update")
	public String showUpdateAgenda(Model model, TipoAgenda tipoAgenda)
	{
		model.addAttribute(new Agenda());
		model.addAttribute("age", agendaService.findAllAgenda());
		model.addAttribute("tipage", TipoAgenda.values());
		
		return "agenda/insertAgenda";
	}
	
	//@RequestMapping(method = RequestMethod.POST, params = "update")
	public String updateAgenda(Model model, @Valid Agenda agenda, BindingResult bindingResult)
	{
		
		if(bindingResult.hasErrors())
		{
			System.out.println("Error en updateAgenda "+bindingResult.getAllErrors());
			model.addAttribute("age", agendaService.findAllAgenda());
			model.addAttribute("tipage", TipoAgenda.values());
			
			return "agenda/insertAgenda";
		}
		agendaService.updateAgenda(agenda);
		model.addAttribute("age", agendaService.findAllAgenda());
		model.addAttribute("tipage", TipoAgenda.values());
		
		return "agenda/insertAgenda";
	
	}
	
	

}
