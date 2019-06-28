package ufc.com.br.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ufc.com.br.model.Usuario;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/logar")
	public String getFormulatio() {
		return "login";
	}
	
	@RequestMapping("/entrar")
	public ModelAndView logar(Usuario usuario) {
		ModelAndView mv = new ModelAndView("redirect:/pratos/listar");
		return mv;
}

}
