package controller;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.dao.AcompanhamentoDAO;
import model.entity.Acompanhamento;
import model.entity.Pedido;

@Named
@ViewScoped
public class AcompanhamentoController implements Serializable {
	private static final long serialVersionUID = -7099790426577894627L;

	private Pedido pedidoAcompanhado;
	private AcompanhamentoDAO acompanhamentoDAO = new AcompanhamentoDAO();
	private List<Acompanhamento> acompanhamentos;
	private Acompanhamento acompanhamento;
	private String mensagemAviso = "";

	private LoginController loginController;
	private DetalhesPedidoController detalhesPedidoController;

	@Inject
	public AcompanhamentoController(LoginController loginController,
			DetalhesPedidoController detalhesPedidoController) {
		super();
		this.loginController = loginController;
		this.detalhesPedidoController = detalhesPedidoController;
		this.pedidoAcompanhado = this.detalhesPedidoController.getPedidoSelecionado();

		this.montaAcompanhamento();
		this.carregaAcompanhamentos();
	}

	private void montaAcompanhamento() {
		this.acompanhamento = new Acompanhamento();
		this.acompanhamento.setPedido(this.pedidoAcompanhado);
		this.acompanhamento.setEmissor(this.loginController.getUsuario());
	}

	public void salvarAcompanhamento() {
		if (this.acompanhamento.getMensagem().length() > 0) {
			this.acompanhamentoDAO.insert(this.acompanhamento);
			this.mensagemAviso = "";
		} else {
			this.mensagemAviso = "Favor escreva algo antes de enviar";
		}
	}

	private void carregaAcompanhamentos() {

		List<Acompanhamento> resultList = this.acompanhamentoDAO.acompanhamentosPedido(this.pedidoAcompanhado);
		if (resultList != null && resultList.size() > 0) {
			this.acompanhamentos = resultList;
		} else {
			this.acompanhamentos = new LinkedList<>();
		}

	}

	public List<Acompanhamento> getAcompanhamentos() {
		return acompanhamentos;
	}

	public void setAcompanhamentos(List<Acompanhamento> acompanhamentos) {
		this.acompanhamentos = acompanhamentos;
	}

	public Acompanhamento getAcompanhamento() {
		return acompanhamento;
	}

	public void setAcompanhamento(Acompanhamento acompanhamento) {
		this.acompanhamento = acompanhamento;
	}

	private String nome = "acompanhamentoController";

	public void teste() {
		this.nome = "FOI";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
