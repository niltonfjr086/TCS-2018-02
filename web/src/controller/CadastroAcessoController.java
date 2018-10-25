package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.control.RequestContextController;
import javax.faces.context.FacesContext;
//import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

//import org.json.JSONException;
//import org.json.JSONObject;
import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;

//import component.JsonReader;
import model.dao.TipoContatoDAO;
import model.dao.TipoPessoaDAO;
import model.entity.Contato;
import model.entity.Endereco;
import model.entity.PessoaFisica;
import model.entity.PessoaJuridica;
import model.entity.TipoContato;
import model.entity.TipoPessoa;
import model.entity.Usuario;

@Named
@ViewScoped
// @RequestScoped
// @SessionScoped
public class CadastroAcessoController implements Serializable {

	private static final long serialVersionUID = 2425783147349721021L;
	private LoginController loginController;

	private TipoContatoDAO tipoContatoDAO = new TipoContatoDAO();
	private List<TipoContato> tiposContato = new LinkedList<>();

	private TipoPessoaDAO tipoPessoaDAO = new TipoPessoaDAO();
	private List<TipoPessoa> tiposPessoa = new LinkedList<>();

	private Boolean logado;
	private Usuario usuario;

	private String infoContato;
	private TipoContato tipoContatoSelecionado;
	private TipoPessoa tipoPessoaSelecionada;

	@Inject
	public CadastroAcessoController(LoginController loginController) {
		super();
		this.loginController = loginController;

		this.tiposContato = this.tipoContatoDAO.findAll();
		this.tipoContatoSelecionado = this.tiposContato.get(0);
		this.infoContato = "";

		this.tiposPessoa = this.tipoPessoaDAO.findAll();
		this.tipoPessoaSelecionada = this.tiposPessoa.get(0);

		verificarLogin(loginController);
		
		

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
				// this.tipoPessoaSelecionada = new PessoaFisica().getConfiguracao();
				// this.tipoPessoaSelecionada = new PessoaJuridica().getConfiguracao();

				this.usuario = new Usuario();
				this.usuario.setPessoa(new PessoaFisica());
				this.usuario.getPessoa().setEndereco(new Endereco());
				// this.usuario.setPessoa(new PessoaJuridica());

			}
		}
	}

	public void defineDoc() {
		// System.out.println(this.tipoPessoaSelecionada);

		if (this.tipoPessoaSelecionada.getNome().equalsIgnoreCase("Física")) {

			this.usuario.setPessoa(new PessoaFisica());

		} else {

			this.usuario.setPessoa(new PessoaJuridica());
		}
	}

	public void defineTipoContato() {
		System.out.println("CadastroAcessoController -> defineTipoContato()");
		// PrimeFaces.current().executeScript("");

		// if (this.tipoPessoaSelecionada.getNome().equalsIgnoreCase("Física")) {
		//
		// this.usuario.setPessoa(new PessoaFisica());
		//
		// } else {
		//
		// this.usuario.setPessoa(new PessoaJuridica());
		// }
	}

	public void adicionaContato() {
		System.out.println("adicionaContato()");
		Contato contato = new Contato();

		contato.setInformacao(this.infoContato);
		contato.setTipoContato(this.tipoContatoSelecionado);

		this.usuario.getPessoa().getContatos().add(contato);

		this.infoContato = "";

		// return "printTest()";

	}

	public void digitando() {
		System.out.println(this.infoContato);
	}

	public void carregaEndereco() {

		System.out.println("carregaEndereco()");
		// JSONObject json;
		// try {
		// JSONObject json =
		// JsonReader.readJsonFromUrl("https://api.postmon.com.br/v1/cep/88020-280");
		// System.out.println(json.toString());
		// } catch (JSONException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		// if(json != null) {
		// System.out.println(json.toString());
		// System.out.println(json.get("bairro"));
		// System.out.println(json.get("logradouro"));
		// System.out.println(json.get("estado"));
		// System.out.println(json.get("cidade"));
		// }

	}

	// GETTERS E SETTER PARA A VIEW

	public List<TipoPessoa> getTiposPessoa() {
		return tiposPessoa;
	}

	public void setTiposPessoa(List<TipoPessoa> tiposPessoa) {
		this.tiposPessoa = tiposPessoa;
	}

	public List<TipoContato> getTiposContato() {
		return tiposContato;
	}

	public void setTiposContato(List<TipoContato> tiposContato) {
		this.tiposContato = tiposContato;
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

	public String getInfoContato() {
		return infoContato;
	}

	public void setInfoContato(String infoContato) {
		this.infoContato = infoContato;
	}

	public TipoContato getTipoContatoSelecionado() {
		return tipoContatoSelecionado;
	}

	public void setTipoContatoSelecionado(TipoContato tipoContatoSelecionado) {
		this.tipoContatoSelecionado = tipoContatoSelecionado;
	}

	public TipoPessoa getTipoPessoaSelecionada() {
		return tipoPessoaSelecionada;
	}

	public void setTipoPessoaSelecionada(TipoPessoa tipoPessoaSelecionada) {
		this.tipoPessoaSelecionada = tipoPessoaSelecionada;
	}

}
