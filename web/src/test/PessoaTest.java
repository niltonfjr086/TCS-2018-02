package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.dao.PessoaDAO;
import model.dao.PessoaFisicaDAO;
import model.dao.PessoaJuridicaDAO;
import model.entity.Endereco;
import model.entity.Pessoa;
import model.entity.PessoaFisica;
import model.entity.PessoaJuridica;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PessoaTest {

	private static PessoaFisicaDAO pfDAO;
	private static Long pfVigente = 0L;

	private static PessoaJuridicaDAO pjDAO;
	private static Long pjVigente = 0L;

	private static List<Long> idsManipuladas;

	private PessoaFisica pf;
	private PessoaJuridica pj;
	

	public static Long getPfVigente() {
		return pfVigente;
	}

	public static Long getPjVigente() {
		return pjVigente;
	}

	@BeforeClass
	public static void preparePessoaTests() {

		pfDAO = new PessoaFisicaDAO();
		pfVigente = 0L;

		pjDAO = new PessoaJuridicaDAO();
		pjVigente = 0L;

		PessoaTest.idsManipuladas = new LinkedList<>();

	}

	@AfterClass
	public static void closePessoaTests() {

		pfDAO = null;
		pfVigente = null;

		pfDAO = null;
		pjVigente = null;

		PessoaTest.idsManipuladas = null;
	}

	@Before
	public void prepareNextTest() {
		this.pf = new PessoaFisica();
		this.pj = new PessoaJuridica();
	}

	@After
	public void closeLastTest() {
		this.pf = null;
		this.pj = null;
	}

	@Test
	public void test001() {
		System.out.println("test001 -> INSERT");

		this.pf.setDocumento("000.000.000-00");
		this.pf.setNome("João Silva");
		this.pf = pfDAO.insert(pf);
		assertNotNull(pf.getId());

		PessoaTest.idsManipuladas.add(this.pf.getId());

		// Para testar o update
		pfVigente = this.pf.getId();

	}

	@Test
	public void test002() {
		System.out.println("test002 -> INSERT2");

		this.pj.setDocumento("00.000.000/0000-00");
		this.pj.setNome("AllSmartTech Soluções IOT e Mobile Ltda.");
		this.pj = pjDAO.insert(pj);
		assertNotNull(pj.getId());

		PessoaTest.idsManipuladas.add(this.pj.getId());

		// Para testar o update
		pjVigente = this.pj.getId();

	}

	@Test
	public void test003() {
		System.out.println("test003 -> INSERT3");

		this.pf.setDocumento("111.111.111-11");
		this.pf.setNome("Marcos Fereira");
		this.pf = pfDAO.insert(pf);
		assertNotNull(pf.getId());

		PessoaTest.idsManipuladas.add(this.pf.getId());
	}

	@Test
	public void test004() {
		System.out.println("test004 -> getById");

		this.pf = pfDAO.findById(pfVigente);
		assertNotNull(pf.getId());

		this.pj = pjDAO.findById(pjVigente);
		assertNotNull(pj.getId());

	}

	@Test
	public void test005() {
		System.out.println("test005 -> saveUpdate");

		Endereco e = new Endereco();
		// EnderecoDAO eDAO = new EnderecoDAO(); FEITO ATRAVÉS DE CASCADE
		e.setPais("Brasil");
		e.setCep("88088-888");
		e.setEstado("Santa Catarina");
		e.setMunicipio("Florianópolis");
		e.setLogradouro("Av. Mauro Ramos");
		e.setNumero(2020);
		// e = eDAO.insert(e); FEITO ATRAVÉS DE CASCADE

		this.pf = pfDAO.findById(pfVigente);
		this.pf.setEndereco(e);
		System.out.println("SAVE UPDATE..: " + this.pf.getEndereco());
		this.pf = pfDAO.save(pf);
		assertNotNull(pf.getEndereco().getId());

	}

	@Test
	public void test006() {
		System.out.println("test006 -> listAll");

		List<Pessoa> lista = new LinkedList<>();

		List<PessoaFisica> listaPF = pfDAO.findAll();
		if (listaPF != null && listaPF.size() > 0) {
			lista.addAll(listaPF);
		}
		assertEquals(2, listaPF.size());

		List<PessoaJuridica> listaPJ = pjDAO.findAll();
		if (listaPJ != null && listaPJ.size() > 0) {
			lista.addAll(listaPJ);
		}
		assertEquals(1, listaPJ.size());

		// LISTA INTEIRA
		assertEquals(3, lista.size());

	}

	@Test
	public void test007() {
		System.out.println("test007 -> delete");

		pfDAO.delete(pfVigente);
		this.pf = pfDAO.findById(pfVigente);
		assertNull(pfDAO.findById(pfVigente));
		pjDAO.delete(pjVigente);
		this.pj = pjDAO.findById(pjVigente);
		assertNull(pjDAO.findById(pjVigente));

	}

	@Test
	public void test008() {
		System.out.println("test008 -> deleteAll");

		PessoaDAO pDAO = new PessoaDAO();

		IntStream indexIterator = IntStream.range(0, (PessoaTest.idsManipuladas.size()));

		indexIterator.forEach(index -> {


			
			Long itemId = PessoaTest.idsManipuladas.get(index);
			Pessoa item = pDAO.findById(itemId);

			if (item != null) {
				pDAO.delete(itemId);

				System.out.println("INDEX / SIZE");
				if(index == PessoaTest.idsManipuladas.size() - 1) {
					System.out.println("B.I.N.G.O. !!!");
				}
				System.out.println(""+index+""+(PessoaTest.idsManipuladas.size()-1));
				if (index == PessoaTest.idsManipuladas.size() - 1) {
					PessoaTest.idsManipuladas.clear();
				}
			}

		});

		assertEquals(0, PessoaTest.idsManipuladas.size());

	}

	// private List<Pessoa> getListaInteira() {
	//
	// List<Pessoa> lista = new LinkedList<>();
	//
	// List<PessoaFisica> listaPF = pfDAO.findAll();
	//
	// if (listaPF != null && listaPF.size() > 0)
	// lista.addAll(listaPF);
	//
	// List<PessoaJuridica> listaPJ = pjDAO.findAll();
	//
	// if (listaPJ != null && listaPJ.size() > 0)
	// lista.addAll(listaPJ);
	//
	// return lista;
	// }

}