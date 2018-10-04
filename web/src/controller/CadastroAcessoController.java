package controller;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

//import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.dao.TipoPessoaDAO;
import model.entity.PessoaFisica;
import model.entity.PessoaJuridica;
import model.entity.TipoPessoa;
import model.entity.Usuario;

@Named
@ViewScoped
//@RequestScoped
public class CadastroAcessoController implements Serializable {

	private static final long serialVersionUID = 2425783147349721021L;
	private LoginController loginController;

	private TipoPessoaDAO tipoPessoaDAO = new TipoPessoaDAO();
	private List<TipoPessoa> tiposPessoa = new LinkedList<>();
	
	private Boolean logado;
	private Usuario usuario;
	
	private TipoPessoa tipoPessoaSelecionada;

	@Inject
	public CadastroAcessoController(LoginController loginController) {
		super();

		this.tiposPessoa = this.tipoPessoaDAO.findAll();
		verificarLogin(loginController);
		this.loginController = loginController;

	}

	private void verificarLogin(LoginController loginController) {

		if (loginController != null) {

			Usuario tmp = loginController.getUsuario();

			if (tmp != null && tmp.getId() != null) {
				this.logado = true;
				this.tipoPessoaSelecionada = this.usuario.getPessoa().getConfiguracao();

				this.usuario = tmp;

			} else {
				this.logado = false;
				this.tipoPessoaSelecionada = this.getTiposPessoa().get(0);
//				this.tipoPessoaSelecionada = new PessoaFisica().getConfiguracao();
//				this.tipoPessoaSelecionada = new PessoaJuridica().getConfiguracao();

				this.usuario = new Usuario();
				this.usuario.setPessoa(new PessoaFisica());
//				this.usuario.setPessoa(new PessoaJuridica());

			}
		}
	}
	
	public void defineDoc() {
//		System.out.println(this.tipoPessoaSelecionada);
		
		if(this.tipoPessoaSelecionada.getNome().equalsIgnoreCase("Física")) {
		
			this.usuario.setPessoa(new PessoaFisica());
		
		} else {
			
			this.usuario.setPessoa(new PessoaJuridica());
		}
	}

	// GETTERS E SETTER PARA A VIEW


	public List<TipoPessoa> getTiposPessoa() {
		return tiposPessoa;
	}

	public void setTiposPessoa(List<TipoPessoa> tiposPessoa) {
		this.tiposPessoa = tiposPessoa;
	}

	public Boolean getLogado() {
		return logado;
	}
	
	public void setLogado(Boolean logado) {
		this.logado = logado;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoPessoa getTipoPessoaSelecionada() {
		return tipoPessoaSelecionada;
	}

	public void setTipoPessoaSelecionada(TipoPessoa tipoPessoaSelecionada) {
		this.tipoPessoaSelecionada = tipoPessoaSelecionada;
	}	

}
