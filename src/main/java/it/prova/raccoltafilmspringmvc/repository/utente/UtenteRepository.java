package it.prova.raccoltafilmspringmvc.repository.utente;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import it.prova.raccoltafilmspringmvc.model.StatoUtente;
import it.prova.raccoltafilmspringmvc.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long> {
	
	Optional<Utente> findByUsername(String username);
	
	Utente findByUsernameAndPassword(String username, String password);
	
	//caricamento eager, ovviamente si può fare anche con jpql
	@EntityGraph(attributePaths = { "ruoli" })
	Utente findByUsernameAndPasswordAndStato(String username,String password, StatoUtente stato);
}
