package co.proyectoINGS3v2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.proyectoINGS3v2.modelo.Informe;
import co.proyectoINGS3v2.modelo.Venta;

public class InformeDao extends DAO{

	public List<Informe> informe(Venta ven) throws Exception {
		
		List<Informe> lista;
		ResultSet rs;
		try {
			this.conectar();
			PreparedStatement st = this.getCn().prepareStatement("SELECT personas.nombre , productos.nombre , detalleventas.cantidad , ventas.monto\r\n" + 
					"FROM ventas JOIN detalleventas JOIN productos JOIN personas\r\n" + 
					"WHERE personas.codigo = ventas.personas_codigo\r\n" + 
					"AND ventas.codigo = detalleventas.ventas_codigo\r\n" + 
					"AND detalleventas.productos_codigo = productos.codigo\r\n" + 
					"AND ventas.fecha BETWEEN ? AND ?");
			//st.setDate(1, ven.getFecha());
			//st.setDate(2, ven.getFecha2());
			System.out.println(new java.sql.Date(ven.getFecha().getTime()));
			System.out.println(new java.sql.Date(ven.getFecha2().getTime()));
			st.setDate(1, new java.sql.Date(ven.getFecha().getTime()));
			st.setDate(2, new java.sql.Date(ven.getFecha2().getTime()));
			
			rs = st.executeQuery();
			lista = new ArrayList<Informe>();
			
			while(rs.next()) {
				Informe inf = new Informe();
				inf.setPersonaNombre(rs.getString(1));
				inf.setProductoNombre(rs.getString(2));
				inf.setProductoCantidad(rs.getInt(3));
				inf.setMonto(rs.getDouble(4));
				
				lista.add(inf);
				System.out.println(lista);
				
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return lista;
	}
}
