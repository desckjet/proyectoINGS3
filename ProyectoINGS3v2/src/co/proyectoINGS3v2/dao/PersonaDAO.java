package co.proyectoINGS3v2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import co.proyectoINGS3v2.modelo.Persona;

public class PersonaDAO extends DAO {

	public boolean loggedIn = false;

	public void login(Persona per) throws Exception {

		ResultSet rs;
		try {
			this.conectar();
			PreparedStatement st = this.getCn().prepareStatement("SELECT nombre,password FROM personas");
			rs = st.executeQuery();
			FacesMessage message = null;

			while (rs.next()) {

				if (per.getNombre() != null && per.getNombre().equals(rs.getString(1)) && per.getPassword() != null
						&& per.getPassword().equals(rs.getString(2))) {
					loggedIn = true;
					message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", per.getNombre());
					//elusuario = u.getName();
					break;

				} else {
					loggedIn = false;
					message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error",
							"Usuario o Contraseña incorrectos");
				}

			}

			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			throw e;
		} finally {
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			this.cerrar();
		}

	}

	public void registrar(Persona per) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.getCn().prepareStatement(
					"INSERT INTO personas (codigo , tipoPersona_id, nombre , password) values (?,?,?,?)");
			st.setInt(1, per.getCodigo());
			st.setInt(2, per.getTipo());
			st.setString(3, per.getNombre());
			st.setString(4, per.getPassword());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}

	public List<Persona> traerPersonas() throws Exception {

		List<Persona> lista;
		ResultSet rs;
		try {
			this.conectar();
			PreparedStatement st = this.getCn().prepareCall("SELECT * from personas");
			rs = st.executeQuery();
			lista = new ArrayList<Persona>();
			while (rs.next()) {
				Persona per = new Persona();
				per.setCodigo(rs.getInt(1));
				per.setTipo(rs.getInt(2));
				per.setNombre(rs.getString(3));
				per.setPassword(rs.getString(4));

				lista.add(per);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			this.cerrar();
		}
		return lista;
	}

	public Persona leerID(Persona per) throws Exception {
		Persona pers = null;
		ResultSet rs;

		try {
			this.conectar();
			PreparedStatement st = this.getCn().prepareStatement("SELECT * from personas where codigo = ?");
			st.setInt(1, per.getCodigo());
			rs = st.executeQuery();
			while (rs.next()) {
				pers = new Persona();
				pers.setCodigo(rs.getInt(1));
				pers.setTipo(rs.getInt(2));
				pers.setNombre(rs.getString(3));
				pers.setPassword(rs.getString(4));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return pers;
	}

	public void modificar(Persona per) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.getCn().prepareStatement(
					"UPDATE personas SET tipoPersona_id = ? , nombre = ? , password = ? WHERE codigo = ? ");
			st.setInt(1, per.getTipo());
			st.setString(2, per.getNombre());
			st.setString(3, per.getPassword());
			st.setInt(4, per.getCodigo());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}

	public void eliminar(Persona per) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.getCn().prepareStatement("delete from personas WHERE codigo = ?");
			st.setInt(1, per.getCodigo());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}

}
