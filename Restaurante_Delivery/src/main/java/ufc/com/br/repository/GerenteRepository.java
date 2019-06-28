package ufc.com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.com.br.model.Gerente;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long>{
	Gerente findByEmail(String email);
}
