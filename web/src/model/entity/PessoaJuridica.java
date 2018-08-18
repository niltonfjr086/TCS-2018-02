package model.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "2")
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = -4620123394486400862L;

	public PessoaJuridica() {
		 super();
	}

}