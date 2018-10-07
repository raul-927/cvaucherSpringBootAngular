package uy.com.cvaucher.mvc.impl;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uy.com.cvaucher.services.clases.SearchPacientes;

@RequestMapping("/pacsearch")
public interface SearchPacientesControllerImpl {
	
	@RequestMapping(method = RequestMethod.GET)
	//@ResponseBody
	String ShowSearchPacientes(Model model);
	
	@RequestMapping(value ="/search",method = RequestMethod.POST)
	//@ResponseBody
	String searchPacientes(Model model,@Valid 
			SearchPacientes searchPacientes, BindingResult bindingResult);
	
}
