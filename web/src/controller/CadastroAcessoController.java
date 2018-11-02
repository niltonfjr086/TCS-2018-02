package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.control.RequestContextController;
import javax.faces.context.FacesContext;
//import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.json.JSONException;
import org.json.JSONObject;

import component.JsonReader;
import model.dao.ContatoDAO;
import model.dao.EnderecoDAO;
import model.dao.PessoaDAO;
import model.dao.PessoaFisicaDAO;
import model.dao.PessoaJuridicaDAO;
import model.dao.TipoContatoDAO;
import model.dao.TipoPessoaDAO;
import model.dao.TipoUsuarioDAO;
import model.dao.UsuarioDAO;
import model.entity.Contato;
import model.entity.Endereco;
import model.entity.Pessoa;
import model.entity.PessoaFisica;
import model.entity.PessoaJuridica;
import model.entity.TipoContato;
import model.entity.TipoPessoa;
import model.entity.TipoUsuario;
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

	private ContatoDAO contatoDAO = new ContatoDAO();

	private PessoaDAO pessoaDAO = new PessoaDAO();
	private PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
	private PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

	private TipoPessoaDAO tipoPessoaDAO = new TipoPessoaDAO();
	private List<TipoPessoa> tiposPessoa = new LinkedList<>();

//	private TipoUsuario tipoUsuario = new TipoUsuario();
	private List<TipoUsuario> tiposUsuario = new LinkedList<>();
	private TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();

	private Boolean logado;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;

	private String infoContato;
	private TipoContato tipoContatoSelecionado;
	private TipoPessoa tipoPessoaSelecionada;

	private EnderecoDAO enderecoDAO = new EnderecoDAO();
	private Endereco endereco = new Endereco();

	@Inject
	public CadastroAcessoController(LoginController loginController) {
		super();
		this.loginController = loginController;
		
		

		this.tiposContato = this.tipoContatoDAO.findAll();
		this.tipoContatoSelecionado = this.tiposContato.get(0);
		this.infoContato = "";

		this.tiposPessoa = this.tipoPessoaDAO.findAll();
		this.tipoPessoaSelecionada = this.tiposPessoa.get(0);
		
		this.tiposUsuario = this.tipoUsuarioDAO.findAll();


		verificarLogin(loginController);

		this.endereco.setCep("88020-180");

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
				

				this.usuarioDAO = new UsuarioDAO();
				this.usuario = new Usuario();
				this.usuario.setTipo(this.tiposUsuario.get(1));
				this.usuario.setPessoa(new PessoaFisica());
				this.usuario.getPessoa().setTipoPessoa(this.tipoPessoaSelecionada);

			}
		}
	}

	public void defineDoc() {
		System.out.println(this.tipoPessoaSelecionada);

		if (this.tipoPessoaSelecionada.getNome().equalsIgnoreCase("Física")) {

			this.usuario.setPessoa(new PessoaFisica());
			this.usuario.getPessoa().setTipoPessoa(this.tipoPessoaSelecionada);

		} else {

			this.usuario.setPessoa(new PessoaJuridica());
			this.usuario.getPessoa().setTipoPessoa(this.tipoPessoaSelecionada);
		}
	}

	public void defineTipoContato() {
		System.out.println("CadastroAcessoController -> defineTipoContato()");
		// if (this.tipoPessoaSelecionada.getNome().equalsIgnoreCase("Física")) {
		// this.usuario.setPessoa(new PessoaFisica());
		// } else {
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

	public void adicionaUsuario() {

		// this.usuario.getPessoa().setEndereco(this.endereco);
		// this.usuario.setPessoa(this.pessoaDAO.insert(this.usuario.getPessoa()));

		// ENDEREÇO E PESSOA ESTÃO SALVANDO OK COM CASCADE
//		this.usuario.getPessoa().setEndereco(this.endereco);
//		this.usuario.setPessoa(this.pessoaDAO.insert(this.usuario.getPessoa()));

		
		this.usuario.getPessoa().setEndereco(this.endereco);
		 this.usuario = this.usuarioDAO.insert(this.usuario);

		System.out.println(this.usuario);

	}

	public void digitando() {
		System.out.println(this.infoContato);
	}

	public void carregaEndereco() {

		System.out.println("carregaEndereco()");
		JSONObject json;
		try {
			json = JsonReader.readJsonFromUrl("https://api.postmon.com.br/v1/cep/" + this.endereco.getCep());
			// System.out.println(json.toString());

			this.endereco.setPais("Brasil");

			this.endereco.setEstado(json.get("estado").toString());
			this.endereco.setMunicipio(json.get("cidade").toString());
			this.endereco.setLogradouro(json.get("logradouro").toString());
			this.endereco.setBairro(json.get("bairro").toString());

			// this.endereco.setComplemento(json.get("complemento").toString());
			// this.endereco.setEstado(json.get("numero").toString());

		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
