package model.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.entity.Acompanhamento;
import model.entity.Pedido;

public class AcompanhamentoDAO extends GenericDAO<Acompanhamento, Long> {

	public List<Acompanhamento> acompanhamentosPedido(Pedido pedidoSelecionado) {
		
		Map<String, String> params = new HashMap<>();

		Long pedidoId = pedidoSelecionado.getId();

		params.put("pedido", pedidoId != null ? String.valueOf(pedidoId) : "0L");

		List<Acompanhamento> acompanhamentos = new LinkedList<>();

		if (!params.get("pedido").equals("0L")) {

			List<Acompanhamento> consulta = this.executeQuery(params);

			if (consulta != null && consulta.size() > 0) {
				acompanhamentos = consulta;

				return acompanhamentos;
			}
		}
		return null;
	}

}
