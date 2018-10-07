package uy.com.cvaucher.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uy.com.cvaucher.services.domain.Cuentas;
import uy.com.cvaucher.services.enumerador.CuentaTipo;
import uy.com.cvaucher.services.services.CuentasService;
import uy.com.cvaucher.services.services.GrupoCuentasService;

@Controller
@RequestMapping("/cuentas")
public class CuentasController 
{
	private final CuentasService cuentasService;
	private final GrupoCuentasService grupoCuentasService;
	
	@Autowired
	public CuentasController(CuentasService cuentasService,GrupoCuentasService grupoCuentasService){
		this.cuentasService = cuentasService;
		this.grupoCuentasService = grupoCuentasService;
	}
	
	@RequestMapping(value ="/cuenta",params ="insert", method = RequestMethod.GET)
	public String showInsertCuenta(Model model, Cuentas cuentas){
		
		UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().
				getPrincipal();
		model.addAttribute(new Cuentas());
		model.addAttribute("user",user.getUsername());
		model.addAttribute("fecha",this.showDate());
		model.addAttribute("hora",this.showHora());
		model.addAttribute("cuentaTipo", CuentaTipo.values());
		model.addAttribute("muestroCuentas", this.cuentasService.selectAllCuentas());
		model.addAttribute("allGrupoCuentas",this.grupoCuentasService.showAllGrupoCuentas());
		System.out.println("user ==>> "+user.getUsername());
		System.out.println("fecha ==>> "+this.showDate());
		System.out.println("Hora ==>> "+this.showHora());
		return "cuentas/cuentas";
	}
	
	@RequestMapping(value ="/cuenta",params ="insert", method = RequestMethod.POST)
	public String insertCuenta(Model model, @Valid Cuentas cuentas, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().
					getPrincipal();
			model.addAttribute(new Cuentas());
			model.addAttribute("user",user.getUsername());
			model.addAttribute("fecha",this.showDate());
			model.addAttribute("hora",this.showHora());
			model.addAttribute("cuentaTipo", CuentaTipo.values());
			model.addAttribute("muestroCuentas", this.cuentasService.selectAllCuentas());
			model.addAttribute("allGrupoCuentas",this.grupoCuentasService.showAllGrupoCuentas());
			return "cuentas/cuentas";
		}
		UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().
				getPrincipal();
		model.addAttribute(new Cuentas());
		
		
		model.addAttribute("user",user.getUsername());
		model.addAttribute("fecha",this.showDate());
		model.addAttribute("hora",this.showHora());
		this.cuentasService.insertCuenta(cuentas);
		model.addAttribute("muestroCuentas", this.cuentasService.selectAllCuentas());
		model.addAttribute("allGrupoCuentas",this.grupoCuentasService.showAllGrupoCuentas());
		return "cuentas/cuentas";
	}
	private String showDate(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date hoy = new Date();
		String fecha = dateFormat.format(hoy);
		return fecha;
	}
	
	private String showHora(){
		SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm.ss");
		Date hoy = new Date();
		String hora = horaFormat.format(hoy);
		return hora;
	}
}
