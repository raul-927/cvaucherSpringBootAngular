package uy.com.cvaucher.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uy.com.cvaucher.services.domain.Pacientes;
import uy.com.cvaucher.services.services.PacientesService;

@RestController
public class PacienteController {
	
	@Autowired
	private PacientesService pacienteService;
	
	@RequestMapping(value ="/pacientes", method =RequestMethod.GET, 
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<Pacientes>> getAllPacientes(){
		HttpHeaders responseHeaders = new HttpHeaders();
		List<Pacientes> pacientes = this.pacienteService.findAllPacientes();
		
		return new ResponseEntity<List<Pacientes>>(pacientes,responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/pacientes/{pacId}", method =RequestMethod.GET, 
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Pacientes> getPaciente(@PathVariable int pacId){
		HttpHeaders responseHeaders = new HttpHeaders();
		Pacientes paciente = this.pacienteService.findPacientesById(pacId);
		
		return new ResponseEntity<Pacientes>(paciente,responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/pacientes", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Pacientes> setPaciente(@RequestBody @Valid Pacientes paciente, BindingResult bindingResult){
		HttpHeaders responseHeaders = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<Pacientes>(null,responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.pacienteService.insertPacientes(paciente);
		
		return new ResponseEntity<Pacientes>(paciente,responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/pacientes", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Pacientes> updatePaciente(@RequestBody @Valid Pacientes paciente, BindingResult bindingResult){
		HttpHeaders responseHeaders = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<Pacientes>(null,responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.pacienteService.updatePacientes(paciente);
		
		return new ResponseEntity<Pacientes>(paciente,responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/pacientes/{pacId}", method =RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Pacientes> deletePaciente(@PathVariable int pacId){
		HttpHeaders responseHeaders = new HttpHeaders();
		this.pacienteService.deletePacientes(pacId);
		
		return new ResponseEntity<Pacientes>(null,responseHeaders, HttpStatus.OK);
	}
}
