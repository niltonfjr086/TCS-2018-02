package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AcompanhamentoController implements Serializable {
	private static final long serialVersionUID = -7099790426577894627L;

	private String nome = "acompanhamentoController";

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
