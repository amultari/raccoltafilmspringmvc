package it.prova.raccoltafilmspringmvc.service;

import java.util.List;

import it.prova.raccoltafilmspringmvc.model.Regista;

public interface RegistaService {
	
	public List<Regista> listAllElements();

	public Regista caricaSingoloElemento(Long id);
	
	public Regista caricaSingoloElementoConFilms(Long id);

	public void aggiorna(Regista registaInstance);

	public void inserisciNuovo(Regista registaInstance);

	public void rimuovi(Regista registaInstance);
	
	public List<Regista> findByExample(Regista example);
	
	public List<Regista> cercaByCognomeENomeILike(String term);

}
