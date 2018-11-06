package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.component.EditableValueHolder;
//import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
//import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.json.JSONException;
import org.json.JSONObject;

import component.JsonReader;
import model.dao.ContatoDAO;
import model.dao.TipoContatoDAO;
import model.dao.TipoPessoaDAO;
import model.dao.TipoUsuarioDAO;
import model.dao.UsuarioDAO;
import model.entity.Contato;
import model.entity.Endereco;
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
	// private PessoaDAO pessoaDAO = new PessoaDAO();
	// private PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
	// private PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

	private TipoPessoaDAO tipoPessoaDAO = new TipoPessoaDAO();
	private List<TipoPessoa> tiposPessoa = new LinkedList<>();

	// private TipoUsuario tipoUsuario = new TipoUsuario();
	private List<TipoUsuario> tiposUsuario = new LinkedList<>();
	private TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();

	private Boolean logado;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;

	private String infoContato;
	private TipoContato tipoContatoSelecionado;
	private Contato contatoAdd = new Contato();

	private TipoPessoa tipoPessoaSelecionada;

	private boolean ofertante = false;

	@Inject
	public CadastroAcessoController(LoginController loginController) {
		super();
		this.loginController = loginController;

		this.tiposContato = this.tipoContatoDAO.findAll();

		this.contatoAdd = new Contato();
		this.contatoAdd.setTipoContato(this.tiposContato.get(0));

		this.tiposPessoa = this.tipoPessoaDAO.findAll();
		this.tipoPessoaSelecionada = this.tiposPessoa.get(0);

		this.tiposUsuario = this.tipoUsuarioDAO.findAll();

		verificarLogin(loginController);

	}

	private void verificarLogin(LoginController loginController) {

		this.usuarioDAO = new UsuarioDAO();

		if (loginController != null) {

			Usuario tmp = loginController.getUsuario();

			if (tmp != null && tmp.getId() != null) {
				this.logado = true;
				this.usuario = tmp;

				List<Contato> contatos = this.usuario.getPessoa().getContatos();
				List<Contato> contatosLinked = new LinkedList<>();
				for (Contato c : contatos) {
					contatosLinked.add(c);
				}
				this.usuario.getPessoa().getContatos().clear();
				this.usuario.getPessoa().getContatos().addAll(contatosLinked);

				// this.usuario.getPessoa().setContatos((List)this.usuario.getPessoa().getContatos());

				if (this.usuario.getTipo().getNome().equalsIgnoreCase("Ofertante")) {
					this.ofertante = true;
				}

				// System.out.println(this.usuario);

			} else {
				this.logado = false;
				this.tipoPessoaSelecionada = this.getTiposPessoa().get(0);
				this.usuario = new Usuario();
				this.usuario.setTipo(this.tiposUsuario.get(1));
				this.usuario.setPessoa(new PessoaFisica());
				this.usuario.getPessoa().setTipoPessoa(this.tipoPessoaSelecionada);

				this.usuario.getPessoa().setDocumento("");

			}

			if (this.usuario.getPessoa().getEndereco() == null) {
				this.usuario.getPessoa().setEndereco(new Endereco());
				this.usuario.getPessoa().getEndereco().setCep("");
			}

			JSONObject json;
			try {
				json = JsonReader.readJsonFromUrl("https://api.myip.com");
				System.out.println("SHOW IP: " + json.get("ip").toString());
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public void defineDoc() {
		// System.out.println(this.tipoPessoaSelecionada);

		String nome, login, senha;
		nome = this.usuario.getPessoa().getNome();
		login = this.usuario.getLogin();
		senha = this.usuario.getSenha();
		Endereco e = this.usuario.getPessoa().getEndereco();
		List<Contato> contatos = this.usuario.getPessoa().getContatos();

		if (this.tipoPessoaSelecionada.getNome().equalsIgnoreCase("Física")) {

			this.usuario.setPessoa(new PessoaFisica());
			this.usuario.getPessoa().setTipoPessoa(this.tipoPessoaSelecionada);

		} else {

			this.usuario.setPessoa(new PessoaJuridica());
			this.usuario.getPessoa().setTipoPessoa(this.tipoPessoaSelecionada);
		}
		this.usuario.getPessoa().setNome(nome);
		this.usuario.setLogin(login);
		this.usuario.setSenha(senha);
		this.usuario.getPessoa().setEndereco(e);
		this.usuario.getPessoa().setContatos(contatos);
	}

	public void defineTipoContato() {
		System.out.println("CadastroAcessoController -> defineTipoContato()");
	}

	public void adicionaContato() {

		if (this.contatoAdd.getInformacao() != null && this.contatoAdd.getInformacao().length() > 5) {

			Contato contato = new Contato();

			contato.setTipoContato(this.contatoAdd.getTipoContato());
			contato.setInformacao(this.contatoAdd.getInformacao());
			contato.setTipoContato(this.contatoAdd.getTipoContato());

			this.usuario.getPessoa().getContatos().add(contato);

			this.contatoAdd = new Contato();
			this.contatoAdd.setTipoContato(this.tiposContato.get(0));

		}

	}

	public void adicionaUsuario() {

		if (this.ofertante) {
			this.usuario.setTipo(this.tiposUsuario.get(2));
		} else {
			this.usuario.setTipo(this.tiposUsuario.get(1));
		}

		List<Contato> contatos = this.usuario.getPessoa().getContatos();

		if (this.usuario != null) {

			if (this.usuario.getPessoa() != null) {

				for (Contato contato : contatos) {
					contato.setPessoa(this.usuario.getPessoa());
				}
			}

			if (this.usuario.getId() == null) {
				this.usuario = this.usuarioDAO.insert(this.usuario);
			} else {
				this.usuario = this.usuarioDAO.save(this.usuario);
			}
		}

		this.loginController.setUsuario(this.usuario);

		this.recarregar();

	}

	public void carregaEndereco() {

		if (this.usuario.getPessoa().getEndereco().getCep() != null
				&& this.usuario.getPessoa().getEndereco().getCep().length() == 9) {
			JSONObject json;
			try {

				json = JsonReader.readJsonFromUrl(
						"https://api.postmon.com.br/v1/cep/" + this.usuario.getPessoa().getEndereco().getCep());
				// System.out.println(json.toString());

				this.usuario.getPessoa().getEndereco().setPais("Brasil");

				this.usuario.getPessoa().getEndereco().setEstado(json.get("estado").toString());
				this.usuario.getPessoa().getEndereco().setMunicipio(json.get("cidade").toString());
				this.usuario.getPessoa().getEndereco().setLogradouro(json.get("logradouro").toString());
				this.usuario.getPessoa().getEndereco().setBairro(json.get("bairro").toString());

			} catch (JSONException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void apagarContato(int index) {
		this.usuario.getPessoa().getContatos().remove(index);

	}

	public void recarregar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("landing_page.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void digitando() {
//		Object o = ((EditableValueHolder) event.getComponent().getParent()).getValue();
		
		System.out.println("digitando()");
//		System.out.println(o.toString());
		
		System.out.println(this.usuario.getPessoa().getDocumento().toString());
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

	public Contato getContatoAdd() {
		return contatoAdd;
	}

	public void setContatoAdd(Contato contatoAdd) {
		this.contatoAdd = contatoAdd;
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

	public boolean getOfertante() {
		return ofertante;
	}

	public void setOfertante(boolean ofertante) {
		this.ofertante = ofertante;
	}

}
