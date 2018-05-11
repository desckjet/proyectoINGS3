package co.proyectoINGS3v2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import co.proyectoINGS3v2.modelo.DetalleVenta;
import co.proyectoINGS3v2.modelo.Venta;

public class VentaDao extends DAO {

	public void registrar(Venta venta, List<DetalleVenta> lista) throws Exception {
		try {
			this.conectar();
			this.getCn().setAutoCommit(false);
			
			PreparedStatement st1 = this.getCn().prepareStatement("INSERT INTO ventas (personas_codigo , monto) values (?,?)");
			st1.setInt(1, venta.getPersona().getCodigo());
			st1.setDouble(2, venta.getMonto());
			st1.executeUpdate();
			st1.close();
			
			PreparedStatement st2 = this.getCn().prepareStatement("SELECT LAST_INSERT_ID() FROM ventas LIMIT 1");
			ResultSet rs;
			int codVenta = 0;
			rs = st2.executeQuery();
			while(rs.next()) {
				codVenta = rs.getInt(1);
			}
			
			rs.close();
			
			for(DetalleVenta det : lista) {
				
				PreparedStatement st4 = this.getCn().prepareStatement("INSERT INTO detalleventas (ventas_codigo, productos_codigo, cantidad) values (?,?,?)");
				st4.setInt(1, codVenta);
				st4.setInt(2, det.getProducto().getCodigo());
				st4.setInt(3, det.getCantidad());
				st4.executeUpdate();
				st4.close();
			}
			
			this.getCn().commit();
			
			
		} catch (Exception e) {
			this.getCn().rollback();
			throw e;
		} finally {
			this.cerrar();
		}
	}
}
