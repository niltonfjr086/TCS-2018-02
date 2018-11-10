package model.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.entity.Nicho;
import model.entity.Ramo;

public class NichoDAO extends GenericDAO<Nicho, Long> {

	public List<Nicho> procurarNichosPorRamo(Ramo ramo) {

		Map<String, String> params = new HashMap<>();

		Long ramoId = ramo.getId();

		params.put("ramo", ramoId != null ? String.valueOf(ramoId) : "0L");

		List<Nicho> nichos = new LinkedList<>();

		if (!params.get("ramo").equals("0L")) {

			List<Nicho> consulta = this.executeQuery(params);

			if (consulta != null && consulta.size() > 0) {
				nichos = consulta;

				return nichos;
			}
		}
		return null;
	}

}
