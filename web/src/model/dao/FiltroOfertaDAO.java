package model.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.entity.FiltroOferta;
import model.entity.Nicho;
import model.entity.Usuario;

public class FiltroOfertaDAO extends GenericDAO<FiltroOferta, Long> {

	public List<Usuario> consultarOfertantesNicho(Nicho nicho) {

		Map<String, String> params = new HashMap<>();

		Long nichoId = nicho.getId();

		params.put("nicho", nichoId != null ? String.valueOf(nichoId) : "0L");

		List<Usuario> ofertantes = new LinkedList<>();

		if (!params.get("nicho").equals("0L")) {

			List<FiltroOferta> consulta = this.executeQuery(params);

			if (consulta != null && consulta.size() > 0) {
				for (FiltroOferta filtroOferta : consulta) {
					ofertantes.add(filtroOferta.getOfertante());
				}
				return ofertantes;
			}
		}

		return null;
	}

}