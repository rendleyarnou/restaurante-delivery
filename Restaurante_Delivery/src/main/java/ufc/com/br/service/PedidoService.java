package ufc.com.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.com.br.model.Pedido;
import ufc.com.br.model.Usuario;
import ufc.com.br.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public void salvar(Pedido pedido) {
		
		pedidoRepository.save(pedido);
	}
	
	public List<Pedido> getHistorico(Usuario usuario){
		return pedidoRepository.findByUsuario(usuario);
}

}
