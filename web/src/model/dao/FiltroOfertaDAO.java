package model.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.entity.FiltroOferta;
import model.entity.Nicho;
import model.entity.TipoOferta;
import model.entity.Usuario;

public class FiltroOfertaDAO extends GenericDAO<FiltroOferta, Long> {

	public List<Usuario> consultarOfertantesNicho(Nicho nicho, TipoOferta tipoOferta, Usuario logado) {

		Map<String, String> params = new HashMap<>();

		Long nichoId = nicho.getId();
		Long tipoOfertaId = tipoOferta.getId();
		Long usuarioLogadoId = logado.getId();

		params.put("nicho", nichoId != null ? String.valueOf(nichoId) : "0L");
		params.put("tipo", nichoId != null ? String.valueOf(tipoOfertaId) : "0L");
		params.put("ofertante NOT", usuarioLogadoId != null ? String.valueOf(usuarioLogadoId) : "0L");

		List<Usuario> ofertantes = new LinkedList<>();

		if (!params.get("nicho").equals("0L") && !params.get("tipo").equals("0L")
				&& !params.get("ofertante NOT").equals("0L")) {

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

	/**
	 * ESTE MÉTODO SERIA USADO APENAS SE USUÁRIOS TIVESSEM VÁRIOS NICHOS PARA
	 * FILTRAR
	 * 
	 * @param usuario
	 * @return
	 */
	public List<FiltroOferta> consultarFiltrosUsuario(Usuario usuario) {

		Map<String, String> params = new HashMap<>();

		Long usuarioId = usuario.getId();
		params.put("ofertante", usuarioId != null ? String.valueOf(usuarioId) : "0L");

		if (!params.get("ofertante").equals("0L")) {

			List<FiltroOferta> filtros = this.executeQuery(params);

			if (filtros != null && filtros.size() > 0) {
				return filtros;
			}
		}
		return null;
	}

}