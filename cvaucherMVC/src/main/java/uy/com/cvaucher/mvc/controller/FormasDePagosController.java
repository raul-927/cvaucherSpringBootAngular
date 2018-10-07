package uy.com.cvaucher.mvc.controller;

import java.util.ArrayList;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import uy.com.cvaucher.services.domain.FormasDePagos;
import uy.com.cvaucher.services.enumerador.TiposFormasDePagos;
import uy.com.cvaucher.services.services.FormasDePagosService;
import uy.com.cvaucher.services.services.CuentasService;

@Controller
@RequestMapping("/formasDePagos")
public class FormasDePagosController 
{
	private ArrayList<Integer>grupoCuentaId = new ArrayList<Integer>();
	private final FormasDePagosService formasDePagosServices;
	private final CuentasService		cuentasService;
	@Autowired
	public FormasDePagosController(FormasDePagosService formasDePagosServices, CuentasService cuentasService)
	{
		this.formasDePagosServices = formasDePagosServices;
		this.cuentasService = cuentasService;
		grupoCuentaId.add(7);
		grupoCuentaId.add(8);
		grupoCuentaId.add(9);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = "insert")
	public String showFormasDePagos(Model model, FormasDePagos formasDePagos)
	{
		
		
		model.addAttribute(new FormasDePagos());
		model.addAttribute("forPag", this.formasDePagosServices.findAllFormasDePagos(null));
		model.addAttribute("tiposPagos",TiposFormasDePagos.values());
		model.addAttribute("cuentas",this.cuentasService.selectAllCuentasByGrupo(grupoCuentaId));
		return "formasDePagos/insertFormasDePagos";
	}
	
	@RequestMapping(method = RequestMethod.POST, params = "insert")
	public String insertFormasDePagos(Model model, @Valid FormasDePagos formasDePagos, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			System.out.println("Error en insertar Tipos de Pagos"+bindingResult.getAllErrors());
			model.addAttribute(new FormasDePagos());
			model.addAttribute("forPag", this.formasDePagosServices.findAllFormasDePagos(null));
			model.addAttribute("tiposPagos",TiposFormasDePagos.values());
			model.addAttribute("cuentas",this.cuentasService.selectAllCuentasByGrupo(grupoCuentaId));
		}
		this.formasDePagosServices.insertFormasDePagos(formasDePagos);
		model.addAttribute(new FormasDePagos());
		model.addAttribute("forPag", this.formasDePagosServices.findAllFormasDePagos(null));
		model.addAttribute("tiposPagos",TiposFormasDePagos.values());
		
		
		model.addAttribute("cuentas",this.cuentasService.selectAllCuentasByGrupo(grupoCuentaId));
		return "formasDePagos/insertFormasDePagos";
	}
}
