package model.entity;

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
@Table(name = "tb_item")
public class Item extends BaseEntity {
	private static final long serialVersionUID = -6417897809585366176L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo", nullable = false)
	private TipoOferta tipoOferta;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "nicho", nullable = false)
	private Nicho nicho;

	@Column(nullable = false, length = 30)
	private String nome;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "unidade_medida", nullable = false)
	private UnidadeMedida unidadeMedida;

	@Column(nullable = false)
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoOferta getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(TipoOferta tipoOferta) {
		this.tipoOferta = tipoOferta;
	}

	public Nicho getNicho() {
		return nicho;
	}

	public void setNicho(Nicho nicho) {
		this.nicho = nicho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
