package controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;
import javax.inject.Named;

import model.dao.PedidoDAO;
import model.dao.UnidadeMedidaDAO;
import model.dao.StatusPedidoDAO;
import model.entity.Pedido;
import model.entity.UnidadeMedida;
import javax.enterprise.context.SessionScoped;

@Named
@SessionScoped
public class DetalhesPedidoController implements Serializable {
	private static final long serialVersionUID = -9093030449583325323L;

	private UnidadeMedidaDAO unidadeMedidaDAO = new UnidadeMedidaDAO();
	private List<UnidadeMedida> unidadesMedida = new LinkedList<>();
	private List<SelectItem> itensUnidadesMedida = new LinkedList<>();

	Long unidadeMedidaSelecionada = 1L;

	private Map<String, String> status = new HashMap<>();
	private Pedido pedidoSelecionado = new Pedido();
	private PedidoDAO pedidoDAO = new PedidoDAO();

	private StatusPedidoDAO statusPedidoDAO = new StatusPedidoDAO();

	public DetalhesPedidoController() {
		super();

		this.constroiMapaDeEstilizacaoDinamica();

		this.unidadesMedida = this.unidadeMedidaDAO.findAll();
		this.carregaSelectUnidadesMedida();

	}

	private void constroiMapaDeEstilizacaoDinamica() {
		this.status.put("Aguardando", "");
		this.status.put("Negociando", "yellow darken-1");
		this.status.put("Executando", "white-text green darken-1");
		this.status.put("Descartado", "white-text blue-grey darken-1");
		this.status.put("Cancelado interrompido", "white-text red darken-1");
		this.status.put("Concluído", "white-text blue darken-1");
	}

	private void carregaSelectUnidadesMedida() {
		for (UnidadeMedida unidade : this.unidadesMedida) {
			this.itensUnidadesMedida.add(new SelectItem(unidade.getId(), unidade.getNome()));
		}
	}

	public void selecionaUnidadeMedida() {
		this.pedidoSelecionado.setUnidadeMedida(this.unidadeMedidaDAO.findById(this.unidadeMedidaSelecionada));
	}

	public void responderPedido() {
		this.pedidoSelecionado.setStatusPedido(this.statusPedidoDAO.findById(2L));
		this.pedidoSelecionado = this.pedidoDAO.save(this.pedidoSelecionado);
	}

	public void executarPedido() {
		this.pedidoSelecionado.setStatusPedido(this.statusPedidoDAO.findById(3L));
		this.pedidoSelecionado = this.pedidoDAO.save(this.pedidoSelecionado);
	}

	public void descartarPedido() {
		this.pedidoSelecionado.setStatusPedido(this.statusPedidoDAO.findById(4L));
		this.pedidoSelecionado = this.pedidoDAO.save(this.pedidoSelecionado);
	}

	public void cancelarPedido() {
		this.pedidoSelecionado.setStatusPedido(this.statusPedidoDAO.findById(5L));
		this.pedidoSelecionado = this.pedidoDAO.save(this.pedidoSelecionado);
	}

	public void concluirPedido() {
		this.pedidoSelecionado.setStatusPedido(this.statusPedidoDAO.findById(6L));
		this.pedidoSelecionado = this.pedidoDAO.save(this.pedidoSelecionado);
	}

	public void calcularTotal() {
		if (respeitaCondicaoDeCalculo()) {
			this.pedidoSelecionado
					.setValorTotal(this.pedidoSelecionado.getQuantidade() * this.pedidoSelecionado.getValorUnidade());
		}
	}

	private Boolean respeitaCondicaoDeCalculo() {
		if (this.pedidoSelecionado != null && this.pedidoSelecionado.getValorUnidade() != null
				&& this.pedidoSelecionado.getValorUnidade() > 0 && this.pedidoSelecionado.getQuantidade() != null
				&& this.pedidoSelecionado.getQuantidade() > 0) {
			return true;

		} else {
			return false;
		}
	}

	public List<UnidadeMedida> getUnidadesMedida() {
		return unidadesMedida;
	}

	public void setUnidadesMedida(List<UnidadeMedida> unidadesMedida) {
		this.unidadesMedida = unidadesMedida;
	}

	public List<SelectItem> getItensUnidadesMedida() {
		return itensUnidadesMedida;
	}

	public void setItensUnidadesMedida(List<SelectItem> itensUnidadesMedida) {
		this.itensUnidadesMedida = itensUnidadesMedida;
	}

	public Long getUnidadeMedidaSelecionada() {
		return unidadeMedidaSelecionada;
	}

	public void setUnidadeMedidaSelecionada(Long unidadeMedidaSelecionada) {
		this.unidadeMedidaSelecionada = unidadeMedidaSelecionada;
	}

	public Map<String, String> getStatus() {
		return status;
	}

	public void setStatus(Map<String, String> status) {
		this.status = status;
	}

	public Pedido getPedidoSelecionado() {
		return pedidoSelecionado;
	}

	public void setPedidoSelecionado(Pedido pedidoSelecionado) {
		this.pedidoSelecionado = pedidoSelecionado;
	}

}
