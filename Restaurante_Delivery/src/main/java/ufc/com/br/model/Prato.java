package ufc.com.br.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigoPrato;
	
	private String nomePrato;
	private float preco;
	
	public Long getCodigoPrato() {
		return codigoPrato;
	}
	public void setCodigoPrato(Long codigoPrato) {
		this.codigoPrato = codigoPrato;
	}
	public String getNomePrato() {
		return nomePrato;
	}
	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
}
