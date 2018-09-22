package test;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * 
 * @author main - Classe exemplo inicial para os casos de teste
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainTest {

	@BeforeClass
	public static void beforeAllTests() {
		System.out.println("BEFORE ALL");
	}

	@AfterClass
	public static void afterAllTests() {
		System.out.println("AFTER ALL");
	}

	@Before
	public void beforeEachTest() {
		System.out.println("BEFORE STARTED");
	}

	@After
	public void afterEachTest() {
		System.out.println("AFTER STARTED");
	}

	@Test
	public void test1() {

		System.out.println("STARTED 1");

		int i = 1;
		assertEquals(1, i);
		assertNotEquals(0, i);

		String objeto = "";
		assertNotNull("Objeto não nulo", objeto);

		String objeto2 = null;
		assertNull("Objeto2 nulo", objeto2);

	}

	@Test
	public void test2() {
		System.out.println("STARTED 2");
	}

}