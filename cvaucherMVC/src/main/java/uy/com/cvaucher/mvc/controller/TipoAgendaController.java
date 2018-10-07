package uy.com.cvaucher.mvc.controller;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import uy.com.cvaucher.services.services.TipoAgendaService;
import uy.com.cvaucher.services.domain.Direccion;
import uy.com.cvaucher.services.domain.TipoAgenda;



//@Controller
//@RequestMapping("/tipo_agenda")
public class TipoAgendaController 
{
	
	private final TipoAgendaService tipoAgendaService;
	

	
	//@Autowired
	public TipoAgendaController(TipoAgendaService tipoAgendaService)
	{
		this.tipoAgendaService = tipoAgendaService;
		
	}
	
	//@RequestMapping(method = RequestMethod.GET, params = "insert")
	public String showInsertTipoAgenda(Model model)
	{
		model.addAttribute(new TipoAgenda());
		model.addAttribute("tipoAg", this.tipoAgendaService.findAllTipoAgenda());
		
		
		return "tipoAgenda/insertTipoAgenda";
	}
	
	//@RequestMapping(method = RequestMethod.POST, params = "insert")
	public String insertTipoAgenda(Model model, @Valid TipoAgenda tipoAgenda, BindingResult bindingResult)
	{
		tipoAgendaService.insertTipoAgenda(tipoAgenda);
		if(bindingResult.hasErrors())
		{
			System.out.println("Error en insertTipoAgenda "+tipoAgenda);
			model.addAttribute(new Direccion());
			model.addAttribute("direcc", tipoAgendaService.findAllTipoAgenda());
			return "tipoAgenda/insertTipoAgenda";
		}
		
		model.addAttribute(new Direccion());
		model.addAttribute("direcc", tipoAgendaService.findAllTipoAgenda());
		return "tipoAgenda/insertTipoAgenda";
	
	}
	

}
