package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipo_usuario")
public class TipoUsuario extends BaseEntity {

	private static final long serialVersionUID = 8258911895916570934L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false, length = 100)
	private String nome;

	// @Column(nullable = false)
	// @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
	// CascadeType.REFRESH,
	// CascadeType.DETACH }, mappedBy = "tipoUsuario", fetch = FetchType.EAGER)
	// private List<Usuario> usuarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
