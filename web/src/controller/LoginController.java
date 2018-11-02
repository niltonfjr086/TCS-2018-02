package controller;

import java.io.Reader;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.primefaces.PrimeFaces;

import model.dao.UsuarioDAO;
import model.entity.Usuario;

@Named
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = -6983839857205389929L;

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	public void validar() throws ScriptException {
		// TipoPessoaDAO tipoPessoaDAO = new TipoPessoaDAO();
		System.out.println("validar()");

		System.out.println(this.usuario.getLogin());
		System.out.println(this.usuario.getSenha());

		Usuario tmp = this.usuarioDAO.validarLogin(this.usuario);
		this.usuario = tmp != null ? tmp : new Usuario();
		
		if(this.usuario.getId() != null) {
			
		}
		System.out.println(this.usuario);
		
		// ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
		// Bindings obj = (Bindings)engine.eval("abreModal('login_submetido');");
		// RequestContext.getCurrentInstance().execute("abreModal('login_submetido');");
		// "abreModal('login_submetido');"
		// return "login_submetido";
		// PrimeFaces.current().executeScript("abreModal('login_submetido');");
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
