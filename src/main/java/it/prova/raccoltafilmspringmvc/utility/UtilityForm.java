package it.prova.raccoltafilmspringmvc.utility;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import it.prova.raccoltafilmspringmvc.dto.RuoloDTO;

public class UtilityForm {

	public static Map<RuoloDTO, Boolean> buildCheckedRolesForPages(List<RuoloDTO> listaTotaleRuoli,
			Long[] ruoliIdFromParams) {
		// mi serve una mappa ordinata per codice ruolo
		Map<RuoloDTO, Boolean> result = new TreeMap<>(new Comparator<RuoloDTO>() {
			@Override
			public int compare(RuoloDTO r1, RuoloDTO r2) {
				return r1.getCodice().compareTo(r2.getCodice());
			}
		});

		for (RuoloDTO ruoloItem : listaTotaleRuoli) {
			result.put(ruoloItem, Arrays.asList(ruoliIdFromParams != null ? ruoliIdFromParams : new Long[] {})
					.contains(ruoloItem.getId()));
		}

		return result;
	}

	public static Map<RuoloDTO, Boolean> buildCheckedRolesFromRolesAlreadyInUtente(List<RuoloDTO> listaTotaleRuoli,
			List<RuoloDTO> listaRuoliPossedutiDaUtente) {
		Map<RuoloDTO, Boolean> result = new TreeMap<>(new Comparator<RuoloDTO>() {
			@Override
			public int compare(RuoloDTO r1, RuoloDTO r2) {
				return r1.getCodice().compareTo(r2.getCodice());
			}
		});

		// converto array di ruoli in List di Long
		List<Long> ruoliConvertitiInIds = listaRuoliPossedutiDaUtente.stream().map(r -> r.getId())
				.collect(Collectors.toList());

		for (RuoloDTO ruoloItem : listaTotaleRuoli) {
			result.put(ruoloItem, ruoliConvertitiInIds.contains(ruoloItem.getId()));
		}

		return result;
	}

}
