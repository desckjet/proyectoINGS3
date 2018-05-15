package co.proyectoINGS3v2.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import co.proyectoINGS3v2.dao.VentaDao;
import co.proyectoINGS3v2.modelo.DetalleVenta;
import co.proyectoINGS3v2.modelo.Persona;
import co.proyectoINGS3v2.modelo.Producto;
import co.proyectoINGS3v2.modelo.Venta;

public class VentaTest {
	
	private VentaDao ven;
	private Venta v;
	private Producto p;
	private Persona per;
	
	private DetalleVenta det;
	private List<DetalleVenta> listaTest;
	
	@Test
	public void debeVerificarQueSeIngreseCorrectamenteLaVenta() throws Exception {
		
		listaTest = new ArrayList<DetalleVenta>();
		det = new DetalleVenta();
		v = new Venta();
		ven = new VentaDao();
		p = new Producto();
		per = new Persona();
		
		p.setCodigo(10);
		p.setNombre("zapato");
		p.setPrecio(1000.00);
		p.setCantidad(4);
		
		per.setCodigo(1152710299);
		per.setNombre("david");
		per.setPassword("123");
		per.setTipo(2);
		
		v.setPersona(per);
		v.setMonto(15000.00);
		
		det.setCodigo(1);
		det.setProducto(p);
		det.setCantidad(2);
		
		listaTest.add(det);
		
		ven.registrar(v, listaTest);
		
	}


}
