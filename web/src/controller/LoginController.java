package controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import model.dao.UsuarioDAO;
import model.entity.Usuario;

@Named
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = -6983839857205389929L;

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	private String paginaVigente = "";

	public void validar() {

		System.out.println(this.usuario.getLogin());
		System.out.println(this.usuario.getSenha());

		Usuario tmp = this.usuarioDAO.validarLogin(this.usuario);
		this.usuario = tmp != null ? tmp : new Usuario();

		if (this.usuario.getId() != null) {
			this.recarregar();
		}
	}

	public String homePage() {
		this.paginaVigente = "";
		return "landing_page.xhtml";
	}

	public String login() {
		this.paginaVigente = " | Acesso ao Sistema";
		return "login_page.xhtml";
	}

	public void logout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		this.recarregar();
	}

	public void recarregar() {
		this.paginaVigente = "";
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("landing_page.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String carregarPerfil() {
		this.paginaVigente = " | Dados Cadastrais";

		return "cadastro_acesso_page.xhtml";
	}

	public String perfilOfertante() {
		this.paginaVigente = " | Perfil Prestador";

		return "perfil_ofertante_page.xhtml";
	}

	public String perfilDemandante() {
		this.paginaVigente = " | Perfil Cliente";

		return "perfil_demandante_page.xhtml";
	}

	public String acompanhamento() {
		this.paginaVigente = " | Acompanhamento";

		return "acompanhamento_page.xhtml";
	}

	public String novoOrcamento() {
		this.paginaVigente = " | Novo Orçamento";

		return "novo_orcamento_page.xhtml";
	}

	public String detalhesPedido() {
		this.setPaginaVigente(" | Detalhes Pedido");
		return "detalhes_pedido_page.xhtml";
	}

	public String voltarAoPerfilVigente(String vigencia) {

		switch (vigencia) {

		case "Ofertando":
			return this.perfilOfertante();

		case "Solicitando":
			return this.perfilDemandante();

		default:
			return this.homePage();
		}

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

	public String getPaginaVigente() {
		return paginaVigente;
	}

	public void setPaginaVigente(String paginaVigente) {
		this.paginaVigente = paginaVigente;
	}

}
