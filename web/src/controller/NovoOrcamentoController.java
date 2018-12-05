package controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.dao.FiltroOfertaDAO;
import model.dao.NichoDAO;
import model.dao.OrcamentoDAO;
import model.dao.PedidoDAO;
import model.dao.RamoDAO;
import model.dao.StatusPedidoDAO;
import model.dao.TipoOfertaDAO;
import model.entity.Endereco;
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

	private Ramo ramoSelecionado = new Ramo();

	private String descricao = "";

	private List<TipoOferta> tiposOferta = new LinkedList<>();
	private TipoOfertaDAO tipoOfertaDAO = new TipoOfertaDAO();
	private List<SelectItem> itensTiposOferta = new LinkedList<>();
	private Long idTipoOfertaOrcamento;

	private List<Nicho> nichosVigentes = new LinkedList<>();
	private List<SelectItem> itensNichosVigentes = new LinkedList<>();
	private Long idNichoVigenteSelecionado;

	private Orcamento orcamento = new Orcamento();
	private OrcamentoDAO orcamentoDAO = new OrcamentoDAO();

	private LoginController loginController;

	private RamoDAO ramoDAO = new RamoDAO();
	private List<Ramo> ramos = new LinkedList<>();
	private List<SelectItem> itemRamos = new LinkedList<>();

	private NichoDAO nichoDAO = new NichoDAO();
	private List<Nicho> nichos = new LinkedList<>();

	private String aviso = "";

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
		this.carregaSelectRamos();

		this.tiposOferta.clear();
		this.tiposOferta.addAll(this.tipoOfertaDAO.findAll());
		this.carregaSelectTiposOferta();
	}

	private void carregaSelectTiposOferta() {
		for (TipoOferta item : this.tiposOferta) {
			this.itensTiposOferta.add(new SelectItem(item.getId(), item.getNome()));
		}
	}

	private void carregaSelectRamos() {
		for (Ramo r : this.ramos) {
			this.itemRamos.add(new SelectItem(r.getId(), r.getNome()));
		}
	}

	public void carregaSelecNichosVigentes() {
		this.itensNichosVigentes.clear();
		for (Nicho item : this.nichosVigentes) {
			this.itensNichosVigentes.add(new SelectItem(item.getId(), item.getNome()));
		}
	}

	public void defineNichosVigentes() {
		List<Nicho> nichos = this.nichoDAO.procurarNichosPorRamo(this.ramoSelecionado);
		if (nichos != null) {
			this.nichosVigentes.clear();
			this.nichosVigentes.addAll(nichos);
		}
		this.carregaSelecNichosVigentes();
	}

	public void defineNichoOrcamento() {
		// this.consultaExistenciaOfertantesNicho();
		this.orcamento.setNicho(this.nichoDAO.findById(this.idNichoVigenteSelecionado));
	}

	public void defineTipoOferta() {
		this.orcamento.setTipoOferta(this.tipoOfertaDAO.findById(this.idTipoOfertaOrcamento));
	}

	// public void consultaExistenciaOfertantesNicho() {
	// if (this.orcamento != null && this.orcamento.getNicho() != null) {
	// FiltroOfertaDAO filtroOfertaDAO = new FiltroOfertaDAO();
	// List<Usuario> listaOfertantesNicho =
	// filtroOfertaDAO.consultarOfertantesNicho(this.orcamento.getNicho(),
	// this.loginController.getUsuario());
	//
	// if (listaOfertantesNicho != null && listaOfertantesNicho.size() > 0) {
	// this.aviso = null;
	// } else {
	// this.aviso = "Favor escolha outro nicho. Ainda sem fornecedores para a
	// seleção atual.";
	// }
	// }
	// }

	private Boolean formularioValido() {

		if (this.orcamento != null && this.orcamento.getNicho() != null && this.orcamento.getTipoOferta() != null
				&& this.orcamento.getTitulo() != null && this.orcamento.getTitulo().length() > 3
				&& this.orcamento.getEndereco() != null && this.orcamento.getEndereco().getCep() != null
				&& this.orcamento.getEndereco().getCep().length() >= 8 && this.orcamento.getEndereco().getPais() != null
				&& this.orcamento.getEndereco().getPais().length() > 1
				&& this.orcamento.getEndereco().getEstado() != null
				&& this.orcamento.getEndereco().getEstado().length() > 1
				&& this.orcamento.getEndereco().getMunicipio() != null
				&& this.orcamento.getEndereco().getMunicipio().length() > 1
				&& this.orcamento.getEndereco().getNumero() != null) {
			this.aviso = "";
			return true;

		} else {
			this.aviso = "Favor preencha todos os campos. Obrigado.";
			return false;

		}

	}

	public String adicionaOrcamento() {

		if (formularioValido()) {

			FiltroOfertaDAO filtroOfertaDAO = new FiltroOfertaDAO();

			List<Usuario> listaOfertantesNicho = filtroOfertaDAO.consultarOfertantesNicho(this.orcamento.getNicho(),
					this.orcamento.getTipoOferta(), this.loginController.getUsuario());

			if (listaOfertantesNicho != null && listaOfertantesNicho.size() > 0) {

				this.orcamento = this.orcamentoDAO.insert(this.orcamento);
				this.enviaPedidos(this.orcamento, listaOfertantesNicho);

				return this.loginController.perfilDemandante();
			}

			this.aviso = "Favor escolha outro nicho. Ainda sem fornecedores para a seleção atual.";
		}
		return "";
	}

	private void enviaPedidos(Orcamento prePedido, List<Usuario> ofertantes) {
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		// FiltroOfertaDAO filtroOfertaDAO = new FiltroOfertaDAO();
		//
		// List<Usuario> listaOfertantesNicho =
		// filtroOfertaDAO.consultarOfertantesNicho(prePedido.getNicho(),
		// this.loginController.getUsuario());

		// System.out.println(listaOfertantesNicho);

		if (ofertantes != null && ofertantes.size() > 0) {

			Pedido p;
			PedidoDAO pedidoDAO = new PedidoDAO();
			Calendar abertura = new GregorianCalendar();

			for (Usuario usuario : ofertantes) {
				p = new Pedido();
				p.setOrcamento(prePedido);

				p.setStatusPedido(new StatusPedidoDAO().findById(1L));
				p.setDtAbertura(abertura);

				p.setOfertante(usuario);
				p.setDemandante(this.loginController.getUsuario());

				p.setDescricao(this.descricao);

				pedidoDAO.save(p);
			}
		}
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

	public List<SelectItem> getItensNichosVigentes() {
		return itensNichosVigentes;
	}

	public void setItensNichosVigentes(List<SelectItem> itensNichosVigentes) {
		this.itensNichosVigentes = itensNichosVigentes;
	}

	public Long getIdNichoVigenteSelecionado() {
		return idNichoVigenteSelecionado;
	}

	public void setIdNichoVigenteSelecionado(Long idNichoVigenteSelecionado) {
		this.idNichoVigenteSelecionado = idNichoVigenteSelecionado;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public List<TipoOferta> getTiposOferta() {
		return tiposOferta;
	}

	public void setTiposOferta(List<TipoOferta> tiposOferta) {
		this.tiposOferta = tiposOferta;
	}

	public List<SelectItem> getItensTiposOferta() {
		return itensTiposOferta;
	}

	public void setItensTiposOferta(List<SelectItem> itensTiposOferta) {
		this.itensTiposOferta = itensTiposOferta;
	}

	public Long getIdTipoOfertaOrcamento() {
		return idTipoOfertaOrcamento;
	}

	public void setIdTipoOfertaOrcamento(Long idTipoOfertaOrcamento) {
		this.idTipoOfertaOrcamento = idTipoOfertaOrcamento;
	}

	public List<Ramo> getRamos() {
		return ramos;
	}

	public void setRamos(List<Ramo> ramos) {
		this.ramos = ramos;
	}

	public List<SelectItem> getItemRamos() {
		return itemRamos;
	}

	public void setItemRamos(List<SelectItem> itemRamos) {
		this.itemRamos = itemRamos;
	}

	public List<Nicho> getNichos() {
		return nichos;
	}

	public void setNichos(List<Nicho> nichos) {
		this.nichos = nichos;
	}

	public String getAviso() {
		return aviso;
	}

	public void setAviso(String aviso) {
		this.aviso = aviso;
	}

}
