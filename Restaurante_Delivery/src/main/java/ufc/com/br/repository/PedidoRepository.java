package ufc.com.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.com.br.model.Pedido;
import ufc.com.br.model.Usuario;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	List<Pedido> findByUsuario(Usuario usuario);
}
