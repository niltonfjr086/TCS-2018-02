package model.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.entity.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario, Long> {

	public Usuario validarLogin(Usuario usuario) {

		Map<String, String> params = new HashMap<>();

		String login = usuario.getLogin();

		params.put("login", login != null ? login.trim() : "");

		params.put("senha", usuario.getSenha().trim());

		List<Usuario> usuarios = new LinkedList<>();

		if (params.get("login").length() > 0 && params.get("senha").length() > 0) {

			List<Usuario> consulta = this.executeQuery(params);

			if (consulta != null) {
				usuarios = consulta;
			}
		}

		// usuarios.size() == 1
		if (usuarios.size() > 0 && usuarios.get(0) != null && usuarios.get(0).getId() != null) {

			return usuarios.get(0);

		}
		// else {
		return null;
		// }

	}

}
