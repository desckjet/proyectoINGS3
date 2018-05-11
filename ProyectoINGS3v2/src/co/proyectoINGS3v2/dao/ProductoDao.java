package co.proyectoINGS3v2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.proyectoINGS3v2.modelo.Producto;

public class ProductoDao extends DAO{
	
	public void registrar(Producto pro) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.getCn().prepareStatement("INSERT INTO productos (nombre , precio , cantidad) values (?,?,?)");
			st.setString(1, pro.getNombre());
			st.setDouble(2,	pro.getPrecio());
			st.setInt(3, pro.getCantidad());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
	
	public List<Producto> traerProductos() throws Exception{
		
		List<Producto> lista;
		ResultSet rs;
		try {
			this.conectar();
			PreparedStatement st = this.getCn().prepareCall("SELECT * from productos");
			rs = st.executeQuery();
			lista = new ArrayList<Producto>();
			while(rs.next()) {
				Producto prod = new Producto();
				prod.setCodigo(rs.getInt(1));
				prod.setNombre(rs.getString(2));
				prod.setPrecio(rs.getDouble(3));
				prod.setCantidad(rs.getInt(4));
				
				lista.add(prod);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return lista;
	}
	
	public Producto leerID(Producto pro) throws Exception {
		Producto prod = null;
		ResultSet rs;
		
		try {
			this.conectar();
			PreparedStatement st = this.getCn().prepareStatement("SELECT * from productos where codigo = ?");
			st.setInt(1, pro.getCodigo());
			rs = st.executeQuery();
			while(rs.next()) {
				prod = new Producto();
				prod.setCodigo(rs.getInt(1));
				prod.setNombre(rs.getString(2));
				prod.setPrecio(rs.getDouble(3));
				prod.setCantidad(rs.getInt(4));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return prod;
	}
	
	public void modificar(Producto pro) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.getCn().prepareStatement("Update productos SET nombre = ?, precio = ?, cantidad = ? WHERE codigo = ?");
			st.setString(1, pro.getNombre());
			st.setDouble(2,	pro.getPrecio());
			st.setInt(3, pro.getCantidad());
			st.setInt(4, pro.getCodigo());
			st.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
	
	public void eliminar(Producto pro) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.getCn().prepareStatement("delete from productos WHERE codigo = ?");
			st.setInt(1, pro.getCodigo());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
}
