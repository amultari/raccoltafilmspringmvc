package it.prova.raccoltafilmspringmvc.repository.regista;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.prova.raccoltafilmspringmvc.model.Regista;

public interface RegistaRepository
		extends JpaRepository<Regista, Long>, PagingAndSortingRepository<Regista, Long>, JpaSpecificationExecutor<Regista>, CustomRegistaRepository {
	
	List<Regista> findByCognomeIgnoreCaseContainingOrNomeIgnoreCaseContainingOrderByNomeAsc(String cognome,
			String nome);
}
