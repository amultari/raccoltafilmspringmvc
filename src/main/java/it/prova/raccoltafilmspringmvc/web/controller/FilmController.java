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

import it.prova.raccoltafilmspringmvc.model.Film;
import it.prova.raccoltafilmspringmvc.service.FilmService;

@Controller
@RequestMapping(value = "/film")
public class FilmController {

	@Autowired
	private FilmService filmService;

	@GetMapping
	public ModelAndView listAllFilms() {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmService.listAllElements();
		mv.addObject("film_list_attribute", films);
		mv.setViewName("film/list");
		return mv;
	}

	@GetMapping("/insert")
	public String createFilm(Model model) {
		model.addAttribute("insert_film_attr", new Film());
		return "film/insert";
	}

	@PostMapping("/save")
	public String saveFilm(@Valid @ModelAttribute("insert_film_attr") Film film, BindingResult result,
			RedirectAttributes redirectAttrs, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "film/insert";
		}
		filmService.inserisciNuovo(film);

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/film";
	}

	@GetMapping("/search")
	public String searchFilm() {
		return "film/search";
	}

	@PostMapping("/list")
	public String listRegisti(Film filmExample, ModelMap model) {
		List<Film> films = filmService.findByExample(filmExample);
		model.addAttribute("film_list_attribute", films);
		return "film/list";
	}

	@GetMapping("/show/{idFilm}")
	public String showFilm(@PathVariable(required = true) Long idFilm, Model model) {
		model.addAttribute("show_film_attr", filmService.caricaSingoloElementoEager(idFilm));
		return "film/show";
	}

}
