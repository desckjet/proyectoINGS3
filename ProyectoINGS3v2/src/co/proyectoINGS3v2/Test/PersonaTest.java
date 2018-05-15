package co.proyectoINGS3v2.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import co.proyectoINGS3v2.dao.PersonaDAO;
import co.proyectoINGS3v2.modelo.Persona;

public class PersonaTest {

	private PersonaDAO per;
	private Persona p;
	private Persona p2;
	private Persona p3;
	private List<Persona> listaTest;
	private List<Persona> listaTest2;
	
	@Test
	public void testLoginTrue() throws Exception {
		
		p = new Persona();
		per = new PersonaDAO();
		
		p.setCodigo(1152710299);
		p.setNombre("david");
		p.setPassword("123");
		p.setTipo(2);
		
		per.login(p);
		
		assertEquals(true, per.loggedIn);
	}
	
	@Test
	public void testLoginFalse() throws Exception {
		
		p = new Persona();
		per = new PersonaDAO();
		
		p.setCodigo(1152710299);
		p.setNombre("asd");
		p.setPassword("4589");
		p.setTipo(2);
		
		per.login(p);
	
		assertEquals(false, per.loggedIn);
	}

	@Test
	public void debeIngresarUnNuevoUsuarioEnLaBD() throws Exception {
		
		p = new Persona();
		per = new PersonaDAO();
		
		p.setCodigo(123);
		p.setNombre("petrosky");
		p.setPassword("1089");
		p.setTipo(2);
		
		per.registrar(p);
	}

	@Test
	public void debeTraerUnaListaDePersonas() throws Exception {
		
		listaTest = new ArrayList<Persona>();
		listaTest2 = new ArrayList<Persona>();
		
		p = new Persona();
		p2 = new Persona();
		p3 = new Persona();
		per = new PersonaDAO();
		
		p.setCodigo(123);
		p.setNombre("petrosky");
		p.setPassword("1089");
		p.setTipo(1);
		
		p2.setCodigo(123456789);
		p2.setNombre("alejandro");
		p2.setPassword("456");
		p2.setTipo(1);
		
		p3.setCodigo(1152710299);
		p3.setNombre("david");
		p3.setPassword("123");
		p3.setTipo(2);
		
		listaTest.add(p);
		listaTest.add(p2);
		listaTest.add(p3);
		
		listaTest2 = per.traerPersonas();
		
		assertEquals(listaTest, listaTest2);
	
	}

	@Test
	public void debeRetornarUnaPersona() throws Exception {
		
		p = new Persona();
		p2 = new Persona();
		per = new PersonaDAO();
		
		p.setCodigo(1152710299);
		p.setNombre("david");
		p.setPassword("123");
		p.setTipo(2);
		
		p2 = per.leerID(p);
		
		assertEquals(p, p2);
		
	}

	@Test
	public void debeModificarLosDatosDeUnaPersona() throws Exception {
		
		p = new Persona();
		per = new PersonaDAO();
		
		p.setCodigo(123);
		p.setNombre("petrosky");
		p.setPassword("1089");
		p.setTipo(1);
		
		per.modificar(p);
		
	}

	@Test
	public void debeEliminarUnUsuarioDeLaBD() throws Exception {
		
		p = new Persona();
		per = new PersonaDAO();
		
		p.setCodigo(123);
		
		per.eliminar(p);
	}

}
