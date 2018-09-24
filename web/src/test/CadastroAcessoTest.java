package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.dao.PessoaDAO;
import model.dao.TipoUsuarioDAO;
import model.dao.UsuarioDAO;
import model.entity.Pessoa;
import model.entity.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CadastroAcessoTest {
	private static PessoaTest pessoaTest;

	private static PessoaDAO pDAO;
	private static TipoUsuarioDAO tpUsuarioDAO;
	private static UsuarioDAO uDAO;
	private static Long uVigente;

	private static List<Long> idsManipuladas;

	private static Integer totalCad;

	private Usuario usuario;

	@BeforeClass
	public static void prepareTests() {
		pessoaTest = new PessoaTest();
		PessoaTest.preparePessoaTests();

		pDAO = new PessoaDAO();
		uDAO = new UsuarioDAO();
		tpUsuarioDAO = new TipoUsuarioDAO();
		uVigente = 0L;
		totalCad = 0;
		CadastroAcessoTest.idsManipuladas = new LinkedList<>();
	}

	@AfterClass
	public static void closeTests() {
		PessoaTest.closePessoaTests();

		pDAO = null;
		uDAO = null;
		tpUsuarioDAO = null;
		uVigente = null;
		totalCad = null;
		CadastroAcessoTest.idsManipuladas = null;
	}

	@Before
	public void prepareNextTest() {
		this.usuario = new Usuario();
	}

	@After
	public void closeLastTest() {
		this.usuario = null;
	}

	@Test
	public void test001() {
		pessoaTest.prepareNextTest();
		pessoaTest.test001();
		pessoaTest.closeLastTest();
		pessoaTest.prepareNextTest();
		pessoaTest.test002();
		pessoaTest.closeLastTest();
		pessoaTest.prepareNextTest();
		pessoaTest.test003();
		pessoaTest.closeLastTest();
	}

	@Test
	public void test002() {

		Pessoa p = pDAO.findById(PessoaTest.getPfVigente());
		this.usuario.setPessoa(p);
		this.usuario.setTipo(tpUsuarioDAO.findById(1L));

		this.usuario.setLogin("joao02");
		this.usuario.setSenha("1234");

		this.usuario = uDAO.insert(this.usuario);

		System.out.println(this.usuario);

		uVigente = this.usuario.getId();
		CadastroAcessoTest.idsManipuladas.add(this.usuario.getId());

		assertNotNull(uDAO.findById(uVigente) != null);
	}

	@Test
	public void test003() {

		Pessoa p = pDAO.findById(PessoaTest.getPjVigente());
		this.usuario.setPessoa(p);
		this.usuario.setTipo(tpUsuarioDAO.findById(3L));

		this.usuario.setLogin("allstech");
		this.usuario.setSenha("1234");

		this.usuario = uDAO.insert(this.usuario);

		// uVigente = this.usuario.getId();
		CadastroAcessoTest.idsManipuladas.add(this.usuario.getId());

		assertNotNull(uDAO.findById(this.usuario.getId()) != null);

		CadastroAcessoTest.idsManipuladas.forEach(item -> {
			Usuario u = uDAO.findById(item);
			if (u != null) {
				totalCad++;
			}
		});

		assertTrue(totalCad == 2);
	}

	@Test
	public void test004() {
		this.usuario = uDAO.findById(uVigente);

		this.usuario.setLogin("joao33");

		uDAO.save(this.usuario);

		this.usuario = uDAO.findById(uVigente);

		assertEquals("joao33", this.usuario.getLogin());

	}

	@Test
	public void test005() {

		CadastroAcessoTest.idsManipuladas.forEach(item -> {
			if (uDAO.findById(item) != null)
				uDAO.delete(item);
		});
		CadastroAcessoTest.idsManipuladas.clear();

		assertNull(uDAO.findById(uVigente));
		assertEquals(0, uDAO.findAll().size());
	}

	@Test
	public void test006() {
		pessoaTest.test008();
	}

}
