package it.prova.raccoltafilmspringmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.raccoltafilmspringmvc.model.Regista;
import it.prova.raccoltafilmspringmvc.repository.regista.RegistaRepository;

@Service
public class RegistaServiceImpl implements RegistaService {

	@Autowired
	private RegistaRepository repository;


	@Transactional(readOnly = true)
	public List<Regista> listAllElements() {
		return (List<Regista>)repository.findAll();
	}

	@Transactional(readOnly = true)
	public Regista caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public Regista caricaSingoloElementoConFilms(Long id) {
		return null;
	}

	@Transactional
	public void aggiorna(Regista registaInstance) {
		repository.save(registaInstance);
	}

	@Transactional
	public void inserisciNuovo(Regista registaInstance) {
		repository.save(registaInstance);
	}

	@Transactional
	public void rimuovi(Regista registaInstance) {
		repository.delete(registaInstance);
	}

	@Transactional(readOnly = true)
	public List<Regista> findByExample(Regista example) {
		return repository.findByExample(example);
	}

	@Transactional(readOnly = true)
	public List<Regista> cercaByCognomeENomeILike(String term) {
		return repository.findByCognomeIgnoreCaseContainingOrNomeIgnoreCaseContainingOrderByNomeAsc(term, term);
	}

}
