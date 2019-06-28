package ufc.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ufc.com.br.model.Prato;
import ufc.com.br.service.PratoService;

@Controller
@RequestMapping("/pratos")
public class PratoController {

	@Autowired
	private PratoService pratoService;
	
	@RequestMapping("/listar")
	public ModelAndView listarPratos() {
		List<Prato> pratos = pratoService.listarPratos();
		ModelAndView mv = new ModelAndView("pratos");
		mv.addObject("listaDePratos", pratos);
		return mv;
	}
	
	@RequestMapping("/formulario")
	public ModelAndView formularioPratos() {
		ModelAndView mv = new ModelAndView("formularioPratos");
		mv.addObject("prato", new Prato());
		return mv;
	}
	
	@RequestMapping("/salvar")
	public ModelAndView salvarPrato(Prato prato, @RequestParam(value = "imagem") MultipartFile imagem) {
		pratoService.cadastrar(prato, imagem);
		ModelAndView mv = new ModelAndView("redirect:/pratos/listar");
		return mv;
	}
	
	@RequestMapping("/excluir/{codigo}")
	public ModelAndView excluir(@PathVariable Long codigoPrato) {
		pratoService.excluir(codigoPrato);
		
		ModelAndView mv = new ModelAndView("redirect:/pratos/listar");
		return mv;
		
}

}
