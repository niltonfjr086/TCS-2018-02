package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PerfilDemandanteController implements Serializable {
	private static final long serialVersionUID = 1508573494335963749L;

	private String nome = "perfilDemandanteController";

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}