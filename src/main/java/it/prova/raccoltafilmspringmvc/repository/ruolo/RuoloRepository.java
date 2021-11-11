package it.prova.raccoltafilmspringmvc.repository.ruolo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.prova.raccoltafilmspringmvc.model.Ruolo;

public interface RuoloRepository extends CrudRepository<Ruolo, Long> {
	Ruolo findByDescrizioneAndCodice(String descrizione, String codice);
	List<Ruolo> findAllByOrderByCodiceAsc();
}
