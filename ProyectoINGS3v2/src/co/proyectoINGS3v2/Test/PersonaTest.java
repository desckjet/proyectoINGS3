package co.proyectoINGS3v2.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import co.proyectoINGS3v2.dao.PersonaDAO;
import co.proyectoINGS3v2.modelo.Persona;

public class PersonaTest {

	private PersonaDAO per = new PersonaDAO();
	private Persona p = new Persona();
	
	@Test
	public void testLogin() throws Exception {
		
		p.setCodigo(1152710299);
		p.setNombre("david");
		p.setPassword("123");
		p.setTipo(2);
		
		per.login(p);
		
		System.out.println(per.loggedIn);
		assertEquals(true, per.loggedIn);
	}

	@Test
	public void testRegistrar() {
		fail("Not yet implemented");
	}

	@Test
	public void testTraerPersonas() {
		fail("Not yet implemented");
	}

	@Test
	public void testLeerID() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificar() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminar() {
		fail("Not yet implemented");
	}

}
