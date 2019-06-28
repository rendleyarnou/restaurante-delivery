package ufc.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ufc.com.br.model.Usuario;
import ufc.com.br.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping("/formulario")
	public ModelAndView formulario() {
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("usuario", new Usuario());
		return mv;
	}

	@RequestMapping("/salvar")
	public String salvarUsuario(Usuario usuario) {
		usuarioService.cadastrar(usuario);
		return "redirect:/pratos/pratos";
	}

	@RequestMapping("/listar")
	public ModelAndView listarUsuarios() {
		List<Usuario> usuarios = usuarioService.listarUsuarios();
		ModelAndView mv = new ModelAndView("paginaListagem");
		mv.addObject("listaUsuarios", usuarios);
		return mv;
	}

	@RequestMapping("/excluir/{codigo}")
	public ModelAndView excluir(@PathVariable Long codigoUsuario) {
		usuarioService.excluir(codigoUsuario);

		ModelAndView mv = new ModelAndView("redirect:/usuario/listar");
		return mv;

	}

	@RequestMapping("/atualizar/{codigo}")
	public ModelAndView atualizar(@PathVariable Long codigoUsuario) {
		Usuario usuario = usuarioService.buscarPorId(codigoUsuario);
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("usuario", usuario);
		return mv;

	}

}
