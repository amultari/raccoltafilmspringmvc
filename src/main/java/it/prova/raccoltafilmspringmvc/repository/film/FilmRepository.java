package it.prova.raccoltafilmspringmvc.repository.film;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.raccoltafilmspringmvc.model.Film;

public interface FilmRepository extends CrudRepository<Film, Long> {
	@Query("from Film f join fetch f.regista where f.id = ?1")
	Film findSingleFilmEager(Long id);

}
