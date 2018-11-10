package controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.dao.FiltroOfertaDAO;
import model.dao.NichoDAO;
import model.dao.OrcamentoDAO;
import model.dao.RamoDAO;
import model.dao.TipoOfertaDAO;
import model.entity.Endereco;
import model.entity.FiltroOferta;
import model.entity.Nicho;
import model.entity.Orcamento;
import model.entity.Pedido;
import model.entity.Ramo;
import model.entity.TipoOferta;
import model.entity.Usuario;

@Named
@ViewScoped
public class NovoOrcamentoController implements Serializable {

	private static final long serialVersionUID = 2043634647244787097L;

	private Ramo ramoSelecionado;

	private String descricao;

	private List<TipoOferta> tipoServico = new LinkedList<>();
	private TipoOfertaDAO tipoOfertaDAO = new TipoOfertaDAO();

	private List<Nicho> nichosVigentes = new LinkedList<>();

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
		} else {
			this.orcamento.setEndereco(new Endereco());
		}

		this.ramos.clear();
		this.ramos.addAll(this.ramoDAO.findAll());

		this.tipoServico.clear();
		this.tipoServico.addAll(this.tipoOfertaDAO.findAll());

	}

	public void defineNichosVigentes() {
		List<Nicho> nichos = this.nichoDAO.procurarNichosPorRamo(this.ramoSelecionado);
		if (nichos != null) {
			this.nichosVigentes.clear();
			this.nichosVigentes.addAll(nichos);
		}
	}

	public void adicionaOrcamento() {
		// this.orcamento = this.orcamentoDAO.insert(this.orcamento);
		System.out.println("adicionaOrcamento()");
		System.out.println(this.orcamento);

		enviaPedidos(this.orcamento);

	}

	private void enviaPedidos(Orcamento prePedido) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar calendar = new GregorianCalendar();
		// System.out.println(calendar);

		// Pedido p = new Pedido();
		// p.setOrcamento(prePedido);
		// p.setDtAbertura(d);
		// p.setDescricao(this.descricao);
		// this.pedidoDAO.insert(p);

		FiltroOfertaDAO filtroOfertaDAO = new FiltroOfertaDAO();
		FiltroOferta filtroOferta = new FiltroOferta();
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Ramo getRamoSelecionado() {
		return ramoSelecionado;
	}

	public void setRamoSelecionado(Ramo ramoSelecionado) {
		this.ramoSelecionado = ramoSelecionado;
	}

	public List<Nicho> getNichosVigentes() {
		return nichosVigentes;
	}

	public void setNichosVigentes(List<Nicho> nichosVigentes) {
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

	public List<TipoOferta> getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(List<TipoOferta> tipoServico) {
		this.tipoServico = tipoServico;
	}

	public List<Ramo> getRamos() {
		return ramos;
	}

	public void setRamos(List<Ramo> ramos) {
		this.ramos = ramos;
	}

	public List<Nicho> getNichos() {
		return nichos;
	}

	public void setNichos(List<Nicho> nichos) {
		this.nichos = nichos;
	}

}
