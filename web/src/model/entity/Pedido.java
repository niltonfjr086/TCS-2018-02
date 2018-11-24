package model.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido extends BaseEntity {
	private static final long serialVersionUID = 1182547082380523201L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "status_pedido", nullable = true)
	private StatusPedido statusPedido;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "unidade_medida", nullable = true)
	private UnidadeMedida unidadeMedida;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "orcamento", nullable = false)
	private Orcamento orcamento;

	@Column(name = "descricao", length = 10000)
	private String descricao;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "demandante", nullable = false)
	private Usuario demandante;

	@Column(name = "nota_para_demandante")
	private Integer notaParaDemandante;

	@Column(name = "comentario_para_demandante", length = 100)
	private String comentarioParaDemandante;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "ofertante")
	private Usuario ofertante;

	@Column(name = "nota_para_ofertante")
	private Integer notaParaOfertante;

	@Column(name = "comentario_para_ofertante", length = 100)
	private String comentarioParaOfertante;

	@Column(name = "valor_unidade")
	private Double valorUnidade = 0.00;

	@Column(name = "quantidade")
	private Integer quantidade = 0;

	@Column(name = "valor_total")
	private Double valorTotal = 0.00;

	@Column(name = "dt_abertura")
	private Calendar dtAbertura;

	@Column(name = "dt_fechamento")
	private Calendar dtFechamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getDemandante() {
		return demandante;
	}

	public void setDemandante(Usuario demandante) {
		this.demandante = demandante;
	}

	public Integer getNotaParaDemandante() {
		return notaParaDemandante;
	}

	public void setNotaParaDemandante(Integer notaParaDemandante) {
		this.notaParaDemandante = notaParaDemandante;
	}

	public String getComentarioParaDemandante() {
		return comentarioParaDemandante;
	}

	public void setComentarioParaDemandante(String comentarioParaDemandante) {
		this.comentarioParaDemandante = comentarioParaDemandante;
	}

	public Usuario getOfertante() {
		return ofertante;
	}

	public void setOfertante(Usuario ofertante) {
		this.ofertante = ofertante;
	}

	public Integer getNotaParaOfertante() {
		return notaParaOfertante;
	}

	public void setNotaParaOfertante(Integer notaParaOfertante) {
		this.notaParaOfertante = notaParaOfertante;
	}

	public String getComentarioParaOfertante() {
		return comentarioParaOfertante;
	}

	public void setComentarioParaOfertante(String comentarioParaOfertante) {
		this.comentarioParaOfertante = comentarioParaOfertante;
	}

	public Double getValorUnidade() {
		return valorUnidade;
	}

	public void setValorUnidade(Double valorUnidade) {
		this.valorUnidade = valorUnidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Calendar getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(Calendar dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Calendar getDtFechamento() {
		return dtFechamento;
	}

	public void setDtFechamento(Calendar dtFechamento) {
		this.dtFechamento = dtFechamento;
	}

}
