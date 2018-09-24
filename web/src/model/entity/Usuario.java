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
@Table(name = "tb_usuario")
public class Usuario extends BaseEntity {

	private static final long serialVersionUID = 1160425699312099326L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo", nullable = false)
	private TipoUsuario tipoUsuario;
	
	@Column(name = "login", nullable = false, length = 100)
	private String login;
	
	@Column(name = "senha", nullable = false, length = 30)
	private String senha;

	@ManyToOne(cascade = { }, fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoa", nullable = false)
	private Pessoa pessoa;
	
	@Column(name = "media_demandada")
	private Double mediaDemandada;
	
	@Column(name = "quantidade_demandada")
	private Integer quantidadeDemandada;
	
	@Column(name = "media_ofertada")
	private Double medidaOfertada;
	
	@Column(name = "quantidade_ofertada")
	private Integer quantidadeOfertada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoUsuario getTipo() {
		return tipoUsuario;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipoUsuario = tipo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getMediaDemandada() {
		return mediaDemandada;
	}

	public void setMediaDemandada(Double mediaDemandada) {
		this.mediaDemandada = mediaDemandada;
	}

	public Integer getQuantidadeDemandada() {
		return quantidadeDemandada;
	}

	public void setQuantidadeDemandada(Integer quantidadeDemandada) {
		this.quantidadeDemandada = quantidadeDemandada;
	}

	public Double getMedidaOfertada() {
		return medidaOfertada;
	}

	public void setMedidaOfertada(Double medidaOfertada) {
		this.medidaOfertada = medidaOfertada;
	}

	public Integer getQuantidadeOfertada() {
		return quantidadeOfertada;
	}

	public void setQuantidadeOfertada(Integer quantidadeOfertada) {
		this.quantidadeOfertada = quantidadeOfertada;
	}

}
