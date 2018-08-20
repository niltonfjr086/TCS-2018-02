package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import model.dao.EnderecoDAO;
import model.dao.PessoaFisicaDAO;
import model.dao.PessoaJuridicaDAO;
import model.dao.TipoPessoaDAO;
import model.entity.Endereco;
import model.entity.Pessoa;
import model.entity.PessoaFisica;
import model.entity.PessoaJuridica;
import model.entity.TipoPessoa;

public class MainTest {

	public static void main(String[] args) {

		String dtFromDB = "01/06/2018 21:35:43";
		StringBuilder date = new StringBuilder(dtFromDB);

		String[] dateArray = dtFromDB.split(" ");
		// dateArray[0] = new StringBuilder((String)
		// dateArray[0]).reverse().toString().split("/");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar calendar = new GregorianCalendar(2013, 1, 28, 13, 24, 56);

		PessoaFisica pf = new PessoaFisica();
		PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
		 pf.setDocumento("000.000.000-00");
		 pf.setNome("João Silva");
		 pfDAO.insert(pf);

		System.out.println(pfDAO.findById(1L).getConfiguracao());

		Endereco e = new Endereco();
		EnderecoDAO eDAO = new EnderecoDAO();
		 e.setPais("Brasil");
		 e.setCep("88088-888");
		 e.setEstado("Santa Catarina");
		 e.setMunicipio("Florianópolis");
		 e.setLogradouro("Av. Mauro Ramos");
		 e.setNumero(2020);
		 e = eDAO.insert(e);
		 pf = pfDAO.findById(1L);
		 pf.setEndereco(e);
		 pfDAO.save(pf);

		PessoaJuridica pj = new PessoaJuridica();
		PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO();
		pj.setDocumento("00.000.000/0000-00");
		pj.setNome("AllSmartTech Soluções IOT e Mobile Ltda.");
		pjDAO.insert(pj);

		System.out.println(pjDAO.findById(2L));

		
		pf = new PessoaFisica();
		pf.setDocumento("111.111.111-11");
		pf.setNome("Marcos Fereira");
		pf = pfDAO.insert(pf);
		
		List<Pessoa> lista = new LinkedList<>();
		lista.addAll(pfDAO.findAll());
		lista.addAll(pjDAO.findAll());
		
		System.out.println(lista);
		
		pfDAO.delete(pf.getId());

	}

}