package ufc.com.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ufc.com.br.model.Prato;
import ufc.com.br.repository.PratoRepository;
import ufc.com.br.util.AulaFileUtils;

@Service
public class PratoService {
	
	@Autowired
	private PratoRepository pratoRepository;
	
	public void cadastrar(Prato prato, MultipartFile imagem) {
		String caminho = "images/" + prato.getNomePrato() + ".png";
		
		AulaFileUtils.salvarImagem(caminho, imagem);
		pratoRepository.save(prato);
	}
	
	public List<Prato> listarPratos() {
		return pratoRepository.findAll();
	}
	
	public void excluir(Long codigoPrato) {
		pratoRepository.deleteById(codigoPrato);
	}

}
