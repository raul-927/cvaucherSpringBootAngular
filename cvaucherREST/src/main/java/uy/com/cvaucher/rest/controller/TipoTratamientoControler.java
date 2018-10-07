package uy.com.cvaucher.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import uy.com.cvaucher.services.domain.TipoTratamiento;
import uy.com.cvaucher.services.services.TipoTratamientoService;


@RestController
public class TipoTratamientoControler{
	
	@Autowired
	private TipoTratamientoService tipoTratamientoService;
	
	
	@RequestMapping(value ="/tipoTratamientos", method =RequestMethod.GET, 
												produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<TipoTratamiento>> getAllTipoTratamiento(){
		HttpHeaders responseHeaders = new HttpHeaders();
		List<TipoTratamiento> tipoTratamiento = tipoTratamientoService.findAllTipoTratamiento();
		return new ResponseEntity<List<TipoTratamiento>>(tipoTratamiento,responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/tipoTratamientos/{tipTratId}", method =RequestMethod.GET, 
															produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<TipoTratamiento> getTipoTratamiento(@PathVariable int tipTratId){
		HttpHeaders responseHeaders = new HttpHeaders();
		TipoTratamiento tipoTratamiento = tipoTratamientoService.findTipoTratamientoById(tipTratId);
		return new ResponseEntity<TipoTratamiento>(tipoTratamiento,responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/tipoTratamientos", method =RequestMethod.POST, 
												consumes ={MediaType.APPLICATION_JSON_VALUE},
												produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<TipoTratamiento> setTipoTratamiento(@RequestBody TipoTratamiento tipoTratamiento, BindingResult bindingResult){
		HttpHeaders responseHeaders = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<TipoTratamiento>(tipoTratamiento,responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		tipoTratamientoService.createTipoTratamiento(tipoTratamiento);
		return new ResponseEntity<TipoTratamiento>(tipoTratamiento,responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/tipoTratamientos", method =RequestMethod.PUT, 
												consumes ={MediaType.APPLICATION_JSON_VALUE}, 
												produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<TipoTratamiento> updateTipoTratamiento(@RequestBody TipoTratamiento tipoTratamiento, BindingResult bindingResult){
		HttpHeaders responseHeaders = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<TipoTratamiento>(tipoTratamiento,responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		tipoTratamientoService.updateTipoTratamiento(tipoTratamiento);
		return new ResponseEntity<TipoTratamiento>(tipoTratamiento,responseHeaders, HttpStatus.OK);
	}
	
	
	@RequestMapping(value ="/tipoTratamientos/{tipTratId}", method =RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<TipoTratamiento> deleteTipoTratamiento(@PathVariable int tipTratId){
		HttpHeaders responseHeaders = new HttpHeaders();
		tipoTratamientoService.deleteTipoTratamiento(tipTratId);
		return new ResponseEntity<TipoTratamiento>(null,responseHeaders, HttpStatus.OK);
	}
	

}
