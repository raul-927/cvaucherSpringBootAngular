package uy.com.cvaucher.mvc.impl;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uy.com.cvaucher.services.domain.TipoTratamiento;

@RequestMapping("/tipo_tratamiento")
public interface TipoTratamientoImpl {
	
	@RequestMapping(method = RequestMethod.GET, params ="insert")
	String showInsertTipoTratamiento(Model model);
	
	@RequestMapping(method = RequestMethod.POST, params ="insert")
	String insertTipoTratamiento(Model model, @Valid TipoTratamiento tipoTratamiento, BindingResult bindingResult);

}
