package it.prova.raccoltafilmspringmvc.utility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import it.prova.raccoltafilmspringmvc.model.Ruolo;

public class UtilityForm {

	public static Map<Ruolo, Boolean> buildCheckedRolesForPages(List<Ruolo> listaTotaleRuoli,
			Long[] ruoliIdFromParams) {
		Map<Ruolo, Boolean> result = new HashMap<>();

		for (Ruolo ruoloItem : listaTotaleRuoli) {
			result.put(ruoloItem, Arrays.asList(ruoliIdFromParams != null ? ruoliIdFromParams : new Long[] {}).contains(ruoloItem.getId()));
		}

		return result;
	}

	public static Map<Ruolo, Boolean> buildCheckedRolesFromRolesAlreadyInUtente(List<Ruolo> listaTotaleRuoli,
			Set<Ruolo> listaRuoliPossedutiDaUtente) {
		Map<Ruolo, Boolean> result = new HashMap<>();

		// converto array di ruoli in List di Long
		List<Long> ruoliConvertitiInIds = listaRuoliPossedutiDaUtente.stream().map(r -> r.getId()).collect(Collectors.toList());

		for (Ruolo ruoloItem : listaTotaleRuoli) {
			result.put(ruoloItem, ruoliConvertitiInIds.contains(ruoloItem.getId()));
		}

		return result;
	}

}
