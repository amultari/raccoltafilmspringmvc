package it.prova.raccoltafilmspringmvc.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = {RequestMethod.POST,RequestMethod.GET})
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		String message = null;
		if (error != null) {
			message = "Username or Password is incorrect !!";
			model.addAttribute("errorMessage", message);
		}
		if (logout != null) {
			message = "You have been successfully logged out !!";
			model.addAttribute("infoMessage", message);
		}
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout=true";
	}
	
	@RequestMapping(value = "/accessDenied", method = {RequestMethod.POST,RequestMethod.GET})
	public String createRegista(Model model) {
		model.addAttribute("errorMessage", "Accesso negato.");
		return "index";
	}

}
