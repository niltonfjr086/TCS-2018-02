package model.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.entity.Pedido;
import model.entity.Usuario;

public class PedidoDAO extends GenericDAO<Pedido, Long> {
	
	public List<Pedido> consultarPedidosOfertante(Usuario ofertante) {

		Map<String, String> params = new HashMap<>();

		Long ofertanteId = ofertante.getId();

		params.put("ofertante", ofertanteId != null ? String.valueOf(ofertanteId) : "0L");

		List<Pedido> pedidos = new LinkedList<>();

		if (!params.get("ofertante").equals("0L")) {

			List<Pedido> consulta = this.executeQuery(params);

			if (consulta != null && consulta.size() > 0) {
				for (Pedido p : consulta) {
					pedidos.add(p);
				}
				return pedidos;
			}
		}

		return null;
	}

}