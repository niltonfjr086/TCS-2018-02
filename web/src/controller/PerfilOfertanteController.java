package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PerfilOfertanteController implements Serializable {
	private static final long serialVersionUID = 1190432464992303360L;

	private String nome = "perfilOfertanteController";

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}