package it.prova.raccoltafilmspringmvc.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.prova.raccoltafilmspringmvc.dto.FilmDTO;
import it.prova.raccoltafilmspringmvc.dto.RegistaDTO;
import it.prova.raccoltafilmspringmvc.model.Film;
import it.prova.raccoltafilmspringmvc.service.FilmService;
import it.prova.raccoltafilmspringmvc.service.RegistaService;

@Controller
@RequestMapping(value = "/film")
public class FilmController {

	@Autowired
	private FilmService filmService;

	@Autowired
	private RegistaService registaService;

	@GetMapping
	public ModelAndView listAllFilms() {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmService.listAllElements();
		mv.addObject("film_list_attribute", FilmDTO.createFilmDTOListFromModelList(films, false));
		mv.setViewName("film/list");
		return mv;
	}

	@GetMapping("/insert")
	public String createFilm(Model model) {
		model.addAttribute("insert_film_attr", new FilmDTO());
		return "film/insert";
	}

	// inietto la request perché ci potrebbe tornare utile per ispezionare i
	// parametri
	@PostMapping("/save")
	public String saveFilm(@Valid @ModelAttribute("insert_film_attr") FilmDTO filmDTO, BindingResult result,
			RedirectAttributes redirectAttrs, HttpServletRequest request) {

		// se fosse un entity questa operazione sarebbe inutile perche provvederebbe
		// da solo fare il binding dell'intero oggetto. Essendo un dto dobbiamo pensarci
		// noi 'a mano'. Se validazione risulta ok devo caricare l'oggetto per
		// visualizzarne nome e cognome nel campo testo
		if (filmDTO.getRegista() == null || filmDTO.getRegista().getId() == null)
			result.rejectValue("regista", "film.regista.notnull");
		else
			filmDTO.setRegista(RegistaDTO
					.buildRegistaDTOFromModel(registaService.caricaSingoloElemento(filmDTO.getRegista().getId())));

		if (result.hasErrors()) {
			return "film/insert";
		}
		filmService.inserisciNuovo(filmDTO.buildFilmModel());

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/film";
	}

	@GetMapping("/search")
	public String searchFilm(Model model) {
		model.addAttribute("registi_list_attribute",
				RegistaDTO.createRegistaDTOListFromModelList(registaService.listAllElements()));
		return "film/search";
	}

	@PostMapping("/list")
	public String listFilms(FilmDTO filmExample, ModelMap model) {
		List<Film> films = filmService.findByExample(filmExample.buildFilmModel());
		model.addAttribute("film_list_attribute", FilmDTO.createFilmDTOListFromModelList(films, false));
		return "film/list";
	}

	@GetMapping("/show/{idFilm}")
	public String showFilm(@PathVariable(required = true) Long idFilm, Model model) {
		model.addAttribute("show_film_attr",
				FilmDTO.buildFilmDTOFromModel(filmService.caricaSingoloElementoEager(idFilm), true));
		return "film/show";
	}

}
