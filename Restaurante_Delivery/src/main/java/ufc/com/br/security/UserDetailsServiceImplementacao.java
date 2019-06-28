package ufc.com.br.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import ufc.com.br.model.Gerente;
import ufc.com.br.model.Usuario;
import ufc.com.br.repository.GerenteRepository;
import ufc.com.br.repository.UsuarioRepository;

@Repository
public class UserDetailsServiceImplementacao implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private GerenteRepository gerenteRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email);
		Gerente gerente = gerenteRepository.findByEmail(email);
		
		if (usuario != null)
			return usuario;

		if (gerente != null)
			return gerente;

		throw new UsernameNotFoundException("Usuário não existe");
	}

}
