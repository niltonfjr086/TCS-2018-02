package controller;

import java.io.Serializable;
import java.util.Collections;
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

		this.carregaAcompanhamentos();
		this.montaAcompanhamento();
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

			this.carregaAcompanhamentos();
			this.montaAcompanhamento();
		} else {
			this.mensagemAviso = "Favor escreva algo antes de enviar";
		}
		// System.out.println(this.acompanhamento.getMensagem());
	}

	private void carregaAcompanhamentos() {

		List<Acompanhamento> resultList = this.acompanhamentoDAO.acompanhamentosPedido(this.pedidoAcompanhado);
		if (resultList != null && resultList.size() > 0) {
			Collections.reverse(resultList);
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

}
