package ufc.com.br.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigoItemPedido;
	
	@ManyToOne
	private Prato prato;
	
	public ItemPedido() {
		
	}
	
	public ItemPedido(Prato prato) {
		this.prato = prato;
	}

	public Long getCodigoItemPedido() {
		return codigoItemPedido;
	}

	public void setCodigoItemPedido(Long codigoItemPedido) {
		this.codigoItemPedido = codigoItemPedido;
	}

	public Prato getPrato() {
		return prato;
	}

	public void setPrato(Prato prato) {
		this.prato = prato;
	}

}
