package it.prova.raccoltafilmspringmvc.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
		return (List<Regista>) repository.findAll();
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
	public void rimuovi(Long idToDelete) {
		repository.deleteById(idToDelete);
	}

	@Transactional(readOnly = true)
	public List<Regista> findByExample(Regista example) {
		return repository.findByExample(example);
	}

	@Transactional(readOnly = true)
	public List<Regista> cercaByCognomeENomeILike(String term) {
		return repository.findByCognomeIgnoreCaseContainingOrNomeIgnoreCaseContainingOrderByNomeAsc(term, term);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Regista> findByExampleWithPagination(Regista example, Integer pageNo, Integer pageSize, String sortBy) {
		Specification<Regista> specificationCriteria = (root, query, cb) -> {

			List<Predicate> predicates = new ArrayList<Predicate>();

			if (StringUtils.isNotEmpty(example.getNome()))
				predicates.add(cb.like(cb.upper(root.get("nome")), "%" + example.getNome().toUpperCase() + "%"));

			if (StringUtils.isNotEmpty(example.getCognome()))
				predicates.add(cb.like(cb.upper(root.get("cognome")), "%" + example.getCognome().toUpperCase() + "%"));

			if (StringUtils.isNotEmpty(example.getNickName()))
				predicates
						.add(cb.like(cb.upper(root.get("nickName")), "%" + example.getNickName().toUpperCase() + "%"));

			if (example.getSesso() != null)
				predicates.add(cb.equal(root.get("sesso"), example.getSesso()));

			if (example.getDataDiNascita() != null)
				predicates.add(cb.greaterThanOrEqualTo(root.get("dataDiNascita"), example.getDataDiNascita()));

			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		};

		Pageable paging = null;
		// se non passo parametri di paginazione non ne tengo conto
		if (pageSize == null || pageSize < 10)
			paging = Pageable.unpaged();
		else
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		return repository.findAll(specificationCriteria, paging);
	}

}
