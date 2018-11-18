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
import model.entity.Pedido;

@Named
@ViewScoped
public class PerfilOfertanteController implements Serializable {
	private static final long serialVersionUID = 1190432464992303360L;

	private StatusPedidoDAO statusPedidoDAO;
	private PedidoDAO pedidoDAO;
	private List<Pedido> pedidos;
	private Map<String, List<Pedido>> pedidosPorStatus;

	private Pedido pedidoSelecionado;

	private LoginController loginController;

	@Inject
	public PerfilOfertanteController(LoginController loginController) {
		super();
		this.loginController = loginController;

		this.statusPedidoDAO = new StatusPedidoDAO();
		this.pedidoDAO = new PedidoDAO();

		this.pedidos = new LinkedList<>();

		// this.pedidos.clear();
		// this.pedidos.addAll(this.pedidoDAO.consultarPedidosOfertante(this.loginController.getUsuario()));
		// this.pedidosPorStatus = new HashMap<>();
		this.classificarPedidos();
	}

	public void classificarPedidos() {
		this.pedidos.clear();
		this.pedidos.addAll(this.pedidoDAO.consultarPedidosOfertante(this.loginController.getUsuario()));

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

	public void verificarPedido(String status, Integer index) {
		List<Pedido> pedidosStatus = pedidosPorStatus.get(status);
		this.pedidoSelecionado = pedidosStatus.get(index);

		System.out.println(this.pedidoSelecionado);
	}

	public void descartarPedido(String status, Integer index) {
		List<Pedido> pedidosStatus = pedidosPorStatus.get(status);
		this.pedidoSelecionado = pedidosStatus.get(index);
		
//		this.pedidoSelecionado = this.pedidos.get(index);

		this.pedidoSelecionado.setStatusPedido(this.statusPedidoDAO.findById(4L));
		this.pedidoSelecionado = this.pedidoDAO.save(this.pedidoSelecionado);

		this.classificarPedidos();
	}

	private String nome = "perfilOfertanteController";

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

}