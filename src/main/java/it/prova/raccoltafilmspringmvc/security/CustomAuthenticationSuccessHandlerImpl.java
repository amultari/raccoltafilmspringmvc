package it.prova.raccoltafilmspringmvc.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import it.prova.raccoltafilmspringmvc.dto.UtenteDTO;
import it.prova.raccoltafilmspringmvc.model.Utente;
import it.prova.raccoltafilmspringmvc.repository.utente.UtenteRepository;

@Component
public class CustomAuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Autowired
	private UtenteRepository utenteRepository;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		//voglio mettere in sessione uno userInfo perché spring security mette solo un principal da cui attingere username
		Utente utenteFromDb = utenteRepository.findByUsername(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("Username " + authentication.getName() + " not found"));
		UtenteDTO utenteParziale = new UtenteDTO();
		utenteParziale.setNome(utenteFromDb.getNome());
		utenteParziale.setCognome(utenteFromDb.getCognome());
		request.getSession().setAttribute("userInfo", utenteParziale);
		response.sendRedirect("home");

	}

}
