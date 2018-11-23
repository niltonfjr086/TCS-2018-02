package controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.dao.PedidoDAO;
import model.dao.StatusPedidoDAO;
import model.dao.UnidadeMedidaDAO;
import model.entity.Pedido;
import model.entity.UnidadeMedida;

@Named
@ViewScoped
public class PerfilOfertanteController implements Serializable {
	private static final long serialVersionUID = 1190432464992303360L;

	private StatusPedidoDAO statusPedidoDAO;
	private PedidoDAO pedidoDAO;
	private List<Pedido> pedidos;
	private Map<String, List<Pedido>> pedidosPorStatus;

	private UnidadeMedidaDAO unidadeMedidaDAO = new UnidadeMedidaDAO();
	private List<UnidadeMedida> unidadeMedidas = new LinkedList<>();

	private Pedido pedidoSelecionado;

	private LoginController loginController;

	@Inject
	public PerfilOfertanteController(LoginController loginController) {
		super();
		this.loginController = loginController;

		this.statusPedidoDAO = new StatusPedidoDAO();
		this.pedidoDAO = new PedidoDAO();

		this.pedidos = new LinkedList<>();

		this.pedidoSelecionado = null;

		this.unidadeMedidas.clear();
		this.unidadeMedidas.addAll(this.unidadeMedidaDAO.findAll());

		// this.pedidos.clear();
		// this.pedidos.addAll(this.pedidoDAO.consultarPedidosOfertante(this.loginController.getUsuario()));
		// this.pedidosPorStatus = new HashMap<>();
		this.classificarPedidos();
	}

	public void classificarPedidos() {
		this.pedidos.clear();
		
		List<Pedido> retornada = this.pedidoDAO.consultarPedidosOfertante(this.loginController.getUsuario());
		if(retornada != null) {
			this.pedidos.addAll(this.pedidoDAO.consultarPedidosOfertante(this.loginController.getUsuario()));			
		}

		this.pedidosPorStatus = new HashMap<>();
		this.pedidosPorStatus.put("Aguardando", new LinkedList<>());
		this.pedidosPorStatus.put("Negociando", new LinkedList<>());
		this.pedidosPorStatus.put("Executando", new LinkedList<>());
		this.pedidosPorStatus.put("Descartado", new LinkedList<>());
		this.pedidosPorStatus.put("Cancelado interrompido", new LinkedList<>());
		this.pedidosPorStatus.put("Concluído", new LinkedList<>());

		for (Pedido p : pedidos) {
			switch (p.getStatusPedido().getNome()) {

			case "Aguardando":
				this.pedidosPorStatus.get("Aguardando").add(p);
				break;
			case "Negociando":
				this.pedidosPorStatus.get("Negociando").add(p);
				break;
			case "Executando":
				this.pedidosPorStatus.get("Executando").add(p);
				break;
			case "Descartado":
				this.pedidosPorStatus.get("Descartado").add(p);
				break;
			case "Cancelado interrompido":
				this.pedidosPorStatus.get("Cancelado interrompido").add(p);
				break;
			case "Concluído":
				this.pedidosPorStatus.get("Concluído").add(p);
				break;

			default:
				break;
			}
		}

	}

	public void verificarPedido(String status, String index) {
		List<Pedido> pedidosStatus = pedidosPorStatus.get(status);
		this.pedidoSelecionado = pedidosStatus.get(Integer.parseInt(index));

		System.out.println("verificarPedido(String status, String index)");
		System.out.println(this.pedidoSelecionado);

		if (this.pedidoSelecionado.getValorTotal() == null || this.pedidoSelecionado.getValorTotal() < 0) {
			this.pedidoSelecionado.setValorTotal(0.0);
		}

//		return "responde_pedido";
	}

	public void responderPedido() {

		this.pedidoSelecionado.setStatusPedido(this.statusPedidoDAO.findById(2L));
		this.pedidoSelecionado = this.pedidoDAO.save(this.pedidoSelecionado);

		this.classificarPedidos();

	}

	public void descartarPedido(String status, Integer index) {
		List<Pedido> pedidosStatus = pedidosPorStatus.get(status);
		this.pedidoSelecionado = pedidosStatus.get(index);

		// this.pedidoSelecionado = this.pedidos.get(index);

		this.pedidoSelecionado.setStatusPedido(this.statusPedidoDAO.findById(4L));
		this.pedidoSelecionado = this.pedidoDAO.save(this.pedidoSelecionado);

		this.classificarPedidos();
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

	public void clicou() {
		System.out.println("clicou()");
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Map<String, List<Pedido>> getPedidosPorStatus() {
		return pedidosPorStatus;
	}

	public void setPedidosPorStatus(Map<String, List<Pedido>> pedidosPorStatus) {
		this.pedidosPorStatus = pedidosPorStatus;
	}

	public Pedido getPedidoSelecionado() {
		return pedidoSelecionado;
	}

	public void setPedidoSelecionado(Pedido pedidoSelecionado) {
		this.pedidoSelecionado = pedidoSelecionado;
	}

	public List<UnidadeMedida> getUnidadeMedidas() {
		return unidadeMedidas;
	}

	public void setUnidadeMedidas(List<UnidadeMedida> unidadeMedidas) {
		this.unidadeMedidas = unidadeMedidas;
	}

}