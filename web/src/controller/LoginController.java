package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.dao.UsuarioDAO;
import model.entity.Usuario;

@Named
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = -6983839857205389929L;

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	public void validar() {
		// TipoPessoaDAO tipoPessoaDAO = new TipoPessoaDAO();
		System.out.println("validar()");

		System.out.println(this.usuario.getLogin());
		System.out.println(this.usuario.getSenha());

		Usuario tmp = this.usuarioDAO.validarLogin(this.usuario);
		this.usuario = tmp != null ? tmp : new Usuario();

		// RequestContext.getCurrentInstance().execute("abreModal('login_submetido');");
		// "abreModal('login_submetido');"
		// return "login_submetido";
//		PrimeFaces.current().executeScript("abreModal('login_submetido');");
	}

	public void apagar() {
		System.out.println("APAGADO");
	}

	// GETTERS E SETTER PARA A VIEW

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
