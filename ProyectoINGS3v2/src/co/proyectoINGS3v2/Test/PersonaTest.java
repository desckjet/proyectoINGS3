package co.proyectoINGS3v2.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import co.proyectoINGS3v2.dao.PersonaDAO;
import co.proyectoINGS3v2.modelo.Persona;

public class PersonaTest {

	private PersonaDAO per;
	private Persona p;
	
	@Test
	public void testLogin() throws Exception {
		p = new Persona();
		per = new PersonaDAO();
		
		p.setCodigo(1152710299);
		p.setNombre("david");
		p.setPassword("123");
		p.setTipo(2);
		
		per.login(p);
		
		System.out.println(per.loggedIn);
		assertTrue(per.loggedIn);
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
