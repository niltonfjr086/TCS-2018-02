package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ramo")
public class Ramo extends BaseEntity {
	private static final long serialVersionUID = -9201211914589084761L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 30)
	private String nome;

//	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
//			CascadeType.DETACH }, mappedBy = "ramo", fetch = FetchType.LAZY)
//	private List<Nicho> nichos;

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

//	public List<Nicho> getNichos() {
//		return nichos;
//	}
//
//	public void setNichos(List<Nicho> nichos) {
//		this.nichos = nichos;
//	}

}
