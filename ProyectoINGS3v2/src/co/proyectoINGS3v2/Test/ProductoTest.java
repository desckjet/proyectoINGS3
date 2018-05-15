package co.proyectoINGS3v2.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import co.proyectoINGS3v2.dao.ProductoDao;
import co.proyectoINGS3v2.modelo.Producto;

public class ProductoTest {
	
	private ProductoDao pro;
	private Producto p;
	private Producto p2;
	private Producto p3;
	private List<Producto> listaTest;
	private List<Producto> listaTest2;

	@Test
	public void debeRegistrarUnNuevoProductoEnLaBD() throws Exception {
		
		p = new Producto();
		pro = new ProductoDao();
		
		p.setNombre("Nike");
		p.setPrecio(2000);
		p.setCantidad(10);
		
		pro.registrar(p);
	}

	@Test
	public void debeTraerUnaListaDeProductos() throws Exception {
		
		listaTest = new ArrayList<Producto>();
		listaTest2 = new ArrayList<Producto>();
		
		p = new Producto();
		p2 = new Producto();
		p3 = new Producto();
		pro = new ProductoDao();
		
		p.setCodigo(10);
		p.setNombre("zapato");
		p.setPrecio(1000.00);
		p.setCantidad(4);
		
		p2.setCodigo(11);
		p2.setNombre("chancla");
		p2.setPrecio(1500.00);
		p2.setCantidad(4);
		
		p3.setCodigo(32);
		p3.setNombre("nike");
		p3.setPrecio(2000.00);
		p3.setCantidad(10);
		
		listaTest.add(p);
		listaTest.add(p2);
		listaTest.add(p3);
		
		listaTest2 = pro.traerProductos();
		
		assertEquals(listaTest, listaTest2);
	}

	@Test
	public void debeRetornarUnProducto() throws Exception {
		
		p = new Producto();
		p2 = new Producto();
		pro = new ProductoDao();
		
		p.setCodigo(32);
		p.setNombre("zapato");
		p.setPrecio(1000.00);
		p.setCantidad(4);
		
		p2 = pro.leerID(p);
		
		assertEquals(p, p2);
	}

	@Test
	public void debeModificarunProducto() throws Exception {
		
		p = new Producto();
		pro = new ProductoDao();
		
		p.setCodigo(32);
		p.setNombre("nike");
		p.setPrecio(2000.00);
		p.setCantidad(20);
		
		pro.modificar(p);
		
	}

	@Test
	public void testEliminar() throws Exception {
		
		p = new Producto();
		pro = new ProductoDao();
		
		p.setCodigo(32);
		
		pro.eliminar(p);
		
	}

}
