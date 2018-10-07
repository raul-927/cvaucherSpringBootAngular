package uy.com.cvaucher.mvc.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uy.com.cvaucher.services.domain.Login;
import uy.com.cvaucher.services.services.LoginService;


@Controller
@RequestMapping("/login")
public class LoginController 
{
	private final LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService)
	{
		this.loginService = loginService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	  public String login(Locale locale, Model model, Login login, String domUserNic) 
	{
		model.addAttribute(new Login());
		model.addAttribute("login",loginService.showLoginUser(domUserNic));
		return "login";
	}
}
