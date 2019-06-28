package ufc.com.br.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class AulaFileUtils {
	
	public static void salvarImagem(String caminho, MultipartFile imagem) {
		File file = new File(caminho);
		
		try {
			FileUtils.writeByteArrayToFile(file, imagem.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void excluirImagem(String caminho) {
		File file = new File(caminho);
		
		try {
			FileUtils.deleteQuietly(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
