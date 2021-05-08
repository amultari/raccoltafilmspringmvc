package it.prova.raccoltafilmspringmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.raccoltafilmspringmvc.model.Film;
import it.prova.raccoltafilmspringmvc.repository.film.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository repository;

	@Transactional(readOnly = true)
	public List<Film> listAllElements() {
		return (List<Film>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Film caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public Film caricaSingoloElementoEager(Long id) {
		return repository.findSingleFilmEager(id);
	}

	@Transactional
	public void aggiorna(Film filmInstance) {
		repository.save(filmInstance);
	}

	@Transactional
	public void inserisciNuovo(Film filmInstance) {
		repository.save(filmInstance);
	}

	@Transactional
	public void rimuovi(Film filmInstance) {
		repository.delete(filmInstance);
	}

	@Transactional(readOnly = true)
	public List<Film> findByExample(Film example) {
		// da implementare
		return this.listAllElements();
	}

}
