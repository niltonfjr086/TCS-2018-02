package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
	private PessoaTest pessoaTest = new PessoaTest();

	private PessoaDAO pDAO = new PessoaDAO();

	private static TipoUsuarioDAO tpUsuarioDAO;
	private static UsuarioDAO uDAO;
	private static Long uVigente;

	private static List<Long> idsManipuladas;

	private Usuario usuario;

	@BeforeClass
	public static void prepareTests() {
		PessoaTest.preparePessoaTests();

		uDAO = new UsuarioDAO();
		tpUsuarioDAO = new TipoUsuarioDAO();
		uVigente = 0L;
		CadastroAcessoTest.idsManipuladas = new LinkedList<>();
	}

	@AfterClass
	public static void closeTests() {
		PessoaTest.closePessoaTests();

		uDAO = null;
		tpUsuarioDAO = null;
		uVigente = null;
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
		this.usuario = uDAO.findById(uVigente);

		this.usuario.setLogin("joao33");

		uDAO.save(this.usuario);

		this.usuario = uDAO.findById(uVigente);

		assertEquals("joao33", this.usuario.getLogin());

	}

	@Test
	public void test004() {

		CadastroAcessoTest.idsManipuladas.forEach(item -> {
			if (uDAO.findById(uVigente) != null)
				uDAO.delete(item);
		});
		CadastroAcessoTest.idsManipuladas.clear();

		assertNull(uDAO.findById(uVigente));
	}

	@Test
	public void test005() {
		pessoaTest.test008();
	}

}
