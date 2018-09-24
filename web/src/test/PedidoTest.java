package test;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.dao.PedidoDAO;
import model.entity.Pedido;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PedidoTest {
	private static CadastroAcessoTest cadastroAcessoTest;

	private static PedidoDAO pedidoDAO;
	private static Long pedidoVigente;

	private static List<Long> idsManipuladas;

	private Pedido pedido;

	@BeforeClass
	public static void prepareTests() {
		cadastroAcessoTest = new CadastroAcessoTest();
		CadastroAcessoTest.prepareTests();

		pedidoDAO = new PedidoDAO();
		pedidoVigente = 0L;
		PedidoTest.idsManipuladas = new LinkedList<>();
	}

	@AfterClass
	public static void closeTests() {
		CadastroAcessoTest.closeTests();
		cadastroAcessoTest = null;

		pedidoDAO = null;
		pedidoVigente = null;
		PedidoTest.idsManipuladas = null;
	}

	@Before
	public void prepareNextTest() {
		this.pedido = new Pedido();
	}

	@After
	public void closeLastTest() {
		this.pedido = null;
	}

	@Test
	public void test001() {

		cadastroAcessoTest.prepareNextTest();
		cadastroAcessoTest.test001();
		cadastroAcessoTest.closeLastTest();
		cadastroAcessoTest.prepareNextTest();
		cadastroAcessoTest.test002();
		cadastroAcessoTest.closeLastTest();
		cadastroAcessoTest.prepareNextTest();
		cadastroAcessoTest.test003();
		cadastroAcessoTest.closeLastTest();
	}

	@Test
	public void test002() {

	}

	@Test
	public void test009() {
		cadastroAcessoTest.prepareNextTest();
		cadastroAcessoTest.test005();
		cadastroAcessoTest.closeLastTest();
		cadastroAcessoTest.prepareNextTest();
		cadastroAcessoTest.test006();
		cadastroAcessoTest.closeLastTest();
	}

}
