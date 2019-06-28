package ufc.com.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ufc.com.br.model.Usuario;
import ufc.com.br.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void cadastrar(Usuario usuario) {
		usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));

		usuarioRepository.save(usuario);
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	public void excluir(Long codigoUsuario) {
		usuarioRepository.deleteById(codigoUsuario);
	}

	public Usuario buscarPorId(Long codigoUsuario) {
		return usuarioRepository.getOne(codigoUsuario);
	}

	public Usuario findByUsername(String username) {
		return usuarioRepository.findByEmail(username);
	}

	@Override
	public Usuario loadUserByUsername(String email) throws UsernameNotFoundException {
		return usuarioRepository.findByEmail(email);
	}

}