package ufc.com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.com.br.model.Prato;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {

}
