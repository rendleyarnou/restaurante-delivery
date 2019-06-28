package ufc.com.br.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ufc.com.br.model.ItemPedido;
import ufc.com.br.model.Pedido;
import ufc.com.br.model.Prato;
import ufc.com.br.model.Usuario;
import ufc.com.br.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	Usuario usuarioLogado = null;

	private List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

	@RequestMapping("/carrinho")
	public ModelAndView itensPedido() {
		usuarioLogado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView mv = new ModelAndView("carrinho");
		mv.addObject("itensPedido", itensPedido);
		mv.addObject("historico", pedidoService.getHistorico(usuarioLogado));
		return mv;
	}

	@RequestMapping("/adicionar/{prato}")
	public ModelAndView adicionarAoCarrinho(@PathVariable Prato prato) {
		itensPedido.add(new ItemPedido(prato));
		return new ModelAndView("redirect:/pratos/listar");
	}
	
	@RequestMapping("/remover/{id}")
	public ModelAndView removerCarrinho(@PathVariable Long codigoItemPedido) throws IOException {
		itensPedido.remove(getItemIndexById(codigoItemPedido));
		ModelAndView mv = new ModelAndView("redirect:/pedidos/carrinho");
		return mv;
	}
	
	@RequestMapping("/cancelar")
	public ModelAndView cancelar() throws IOException {
		itensPedido.clear();
		ModelAndView mv = new ModelAndView("redirect:/pratos/listar");
		return mv;
	}

	@RequestMapping("/salvar")
	public ModelAndView salvar() throws IOException {
		pedidoService.salvar(new Pedido(usuarioLogado, itensPedido));

		itensPedido.clear();

		ModelAndView mv = new ModelAndView("redirect:/pratos/listar");
		return mv;
	}

	public int getItemIndexById(Long codigoPrato) {
		for (int i = 0; i < itensPedido.size(); i++) {
			if (itensPedido.get(i).getPrato().getCodigoPrato() == codigoPrato)
				return i;
		}
		return -1;
	}

	public List<ItemPedido> getitensPedido() {
		return itensPedido;
	}

}
