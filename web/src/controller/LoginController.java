package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.dao.TipoPessoaDAO;

@Named
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = -6983839857205389929L;

	public void validar() {
		TipoPessoaDAO tipoPessoaDAO = new TipoPessoaDAO();
		System.out.println("validar()");
		System.out.println(tipoPessoaDAO.findAll());
	}
}
