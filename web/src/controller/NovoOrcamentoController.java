package controller;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.dao.NichoDAO;
import model.dao.OrcamentoDAO;
import model.dao.RamoDAO;
import model.entity.Nicho;
import model.entity.Orcamento;
import model.entity.Pedido;
import model.entity.Ramo;
import model.entity.Usuario;

@Named
@ViewScoped
public class NovoOrcamentoController implements Serializable {

	private static final long serialVersionUID = 2043634647244787097L;

	private List<String> nichosAlimentacao = new LinkedList<>();
	private List<String> nichosConstrucao = new LinkedList<>();

	private String ramoSelecionado;
	private String nichoSelecionado;

	private List<String> tipoServico = new LinkedList<>();
	private String tipoServicoSelecionado;

	private List<String> nichosVigentes = new LinkedList<>();

	private Orcamento orcamento = new Orcamento();
	private Pedido pedido;

	private OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
	private LoginController loginController;
	
	private RamoDAO ramoDAO = new RamoDAO();
	private List<Ramo> ramos = new LinkedList<>();
	
	private NichoDAO nichoDAO = new NichoDAO();
	private List<Nicho> nichos = new LinkedList<>(); 
	
	
	@Inject
	public NovoOrcamentoController(LoginController loginController) {
		super();

		this.loginController = loginController;

		Usuario usuario = this.loginController.getUsuario();
		if (usuario != null && usuario.getId() != null && usuario.getId() > 0L) {
			this.orcamento.setEndereco(usuario.getPessoa().getEndereco());
		}else {
			//TODO o que fazer caso não tenha user? Exemplo: acesso direto da URL sem login
		}

		/*this.ramos.add("Alimentacao");
		this.ramos.add("Construcao");

		this.nichosAlimentacao.add("Bobs");
		this.nichosAlimentacao.add("McDonalds");

		this.nichosConstrucao.add("Pedreiro");
		this.nichosConstrucao.add("Pintor");

		this.tipoServico.add("Serviço completo");
		this.tipoServico.add("Somente mão de obra");*/
	}

	public void defineNicho() {
		this.nichosVigentes.clear();
		if (this.ramoSelecionado.equals("Alimentacao")) {
			this.nichosVigentes.addAll(this.nichosAlimentacao);
		} else if (this.ramoSelecionado.equals("Construcao")) {
			this.nichosVigentes.addAll(this.nichosConstrucao);
		} else {
			this.nichosVigentes.clear();
		}
	}

	public void adicionaOrcamento() {
		this.orcamentoDAO.insert(this.orcamento);
		System.out.println("Salvou saporra? " + this.orcamento);

	}


	
	public String getRamoSelecionado() {
		return ramoSelecionado;
	}

	public void setRamoSelecionado(String ramoSelecionado) {
		this.ramoSelecionado = ramoSelecionado;
	}

	public String getNichoSelecionado() {
		return nichoSelecionado;
	}

	public void setNichoSelecionado(String nichoSelecionado) {
		this.nichoSelecionado = nichoSelecionado;
	}

	public List<String> getNichosVigentes() {
		return nichosVigentes;
	}

	public void setNichosVigentes(List<String> nichosVigentes) {
		this.nichosVigentes = nichosVigentes;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<String> getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(List<String> tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getTipoServicoSelecionado() {
		return tipoServicoSelecionado;
	}

	public void setTipoServicoSelecionado(String tipoServicoSelecionado) {
		this.tipoServicoSelecionado = tipoServicoSelecionado;
	}

}
