package it.prova.raccoltafilmspringmvc.repository.regista;

import java.util.List;

import it.prova.raccoltafilmspringmvc.model.Regista;

public interface CustomRegistaRepository {
	List<Regista> findByExample(Regista example);
}
