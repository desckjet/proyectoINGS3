package co.proyectoINGS3v2.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.proyectoINGS3v2.dao.PersonaDAO;
import co.proyectoINGS3v2.modelo.Persona;

@ManagedBean
@ViewScoped
public class PersonaBean {

	private Persona persona = new Persona();
	private List<Persona> lstPersonas;
	private String accion;

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.limpiar();
		this.accion = accion;
	}

	public String login() throws Exception {
		PersonaDAO dao ;
		
		try {
			dao = new PersonaDAO();
			dao.login(persona);
			if(dao.loggedIn == true && dao.tipoU == 1) {
				return "menuEmp";
			}
			else if(dao.loggedIn == true && dao.tipoU == 2) {
				return "menuAdmin";
			}
			else {
				return "login";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public void operar() throws Exception {
		switch (accion) {
		case "Registrar":
			this.registrar();
			this.limpiar();
			break;
		case "Modificar":
			this.modificar();
			this.limpiar();
			break;
		}
	}

	public void limpiar() {
		this.persona.setCodigo(0);
		this.persona.setNombre("");
		this.persona.setPassword("");;
	}

	private void registrar() throws Exception {
		PersonaDAO dao;
		try {
			dao = new PersonaDAO();
			dao.registrar(persona);
			this.traerPersonas();
		} catch (Exception e) {
			throw e;
		}
	}

	public void traerPersonas() throws Exception {
		PersonaDAO dao;
		try {
			dao = new PersonaDAO();
			lstPersonas = dao.traerPersonas();
			
		} catch (Exception e) {
			throw e;
		}
	}

	public void leerID(Persona per) throws Exception {
		PersonaDAO dao;
		Persona temp;
		try {
			dao = new PersonaDAO();
			temp = dao.leerID(per);

			if (temp != null) {
				this.persona = temp;
				this.accion = "Modificar";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void modificar() throws Exception {
		PersonaDAO dao;
		try {
			dao = new PersonaDAO();
			dao.modificar(persona);
			this.traerPersonas();
		} catch (Exception e) {
			throw e;
		}
	}

	public void eliminar(Persona per) throws Exception {
		PersonaDAO dao;
		try {
			dao = new PersonaDAO();
			dao.eliminar(per);
			this.traerPersonas();
		} catch (Exception e) {
			throw e;
		}
	}

}
