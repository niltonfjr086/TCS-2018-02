package model.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "1")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = -5680990804874128581L;

	public PessoaFisica() {
		 super();
	}

}