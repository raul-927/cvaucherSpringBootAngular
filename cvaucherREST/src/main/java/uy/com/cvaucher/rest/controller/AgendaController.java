package uy.com.cvaucher.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uy.com.cvaucher.services.domain.Agenda;
import uy.com.cvaucher.services.services.AgendaService;

@RestController
public class AgendaController {
	
	@Autowired
	private AgendaService agendaService;
	
	@RequestMapping(value ="/agenda", method =RequestMethod.GET, 
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<Agenda>> getAgendas(){
		HttpHeaders responseHeaders = new HttpHeaders();
		List<Agenda> agendas = agendaService.findAllAgenda();
		
		return new ResponseEntity<List<Agenda>>(agendas, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/agenda/{pacId}", method =RequestMethod.GET, 
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<Agenda>> getAgendaByPacId(@PathVariable int pacId){
		HttpHeaders responseHeaders = new HttpHeaders();
		List<Agenda> agendas = agendaService.findAgendaById(pacId);
		
		return new ResponseEntity<List<Agenda>>(agendas, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/agenda/cedula/{cedula}", method =RequestMethod.GET, 
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<Agenda>> getAgendaByCedula(@PathVariable int cedula){
		HttpHeaders responseHeaders = new HttpHeaders();
		List<Agenda> agendas = agendaService.findAgendaByCedula(cedula);
		
		return new ResponseEntity<List<Agenda>>(agendas, responseHeaders, HttpStatus.OK);
	}
	
	
}
