package uy.com.cvaucher.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import uy.com.cvaucher.services.services.TratamientoService;

@RestController
public class TratamientoController {
	
	@Autowired
	private TratamientoService tratamientoService;
}
