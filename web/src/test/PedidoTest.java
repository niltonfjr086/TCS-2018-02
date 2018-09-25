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
import model.dao.StatusPedidoDAO;
import model.dao.UsuarioDAO;
import model.entity.Pedido;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PedidoTest {
	private static CadastroAcessoTest cadastroAcessoTest;

	private static StatusPedidoDAO statusPedidoDAO;
	private static UsuarioDAO usuarioDAO;
	private static PedidoDAO pedidoDAO;
	private static Long pedidoVigente;

	private static List<Long> idsManipuladas;

	private Pedido pedido;

	@BeforeClass
	public static void prepareTests() {
		cadastroAcessoTest = new CadastroAcessoTest();
		CadastroAcessoTest.prepareTests();

		statusPedidoDAO = new StatusPedidoDAO();
		usuarioDAO = new UsuarioDAO();
		pedidoDAO = new PedidoDAO();
		pedidoVigente = 0L;
		PedidoTest.idsManipuladas = new LinkedList<>();
	}

	@AfterClass
	public static void closeTests() {
		CadastroAcessoTest.closeTests();
		cadastroAcessoTest = null;

		statusPedidoDAO = null;
		usuarioDAO = null;
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
		System.out.println(statusPedidoDAO.findAll());

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
		
		// Long id = CadastroAcessoTest.getuVigente();
		// this.pedido.setDemandante(usuarioDAO.findById(id));
		// this.pedido = pedidoDAO.insert(this.pedido);

		// this.pedido.setStatusPedido(statusPedido);
		
		

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
