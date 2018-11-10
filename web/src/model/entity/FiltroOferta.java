package model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_filtro_oferta")
public class FiltroOferta extends BaseEntity {
	private static final long serialVersionUID = -1352694904725355934L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ofertante", nullable = false)
	private Usuario ofertante;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo", nullable = false)
	private TipoOferta tipo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nicho", nullable = false)
	private Nicho nicho;

	public FiltroOferta() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getOfertante() {
		return ofertante;
	}

	public void setOfertante(Usuario ofertante) {
		this.ofertante = ofertante;
	}

	public TipoOferta getTipo() {
		return tipo;
	}

	public void setTipo(TipoOferta tipo) {
		this.tipo = tipo;
	}

	public Nicho getNicho() {
		return nicho;
	}

	public void setNicho(Nicho nicho) {
		this.nicho = nicho;
	}

}