package co.proyectoINGS3v2.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.proyectoINGS3v2.dao.ProductoDao;
import co.proyectoINGS3v2.modelo.Producto;

@ManagedBean
@ViewScoped
public class ProductoBean {
	
	private Producto producto = new Producto();
	private List<Producto> lstProductos;
	private String accion;

	public List<Producto> getLstProductos() {
		return lstProductos;
	}

	public void setLstProductos(List<Producto> lstProductos) {
		this.lstProductos = lstProductos;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.limpiar();
		this.accion = accion;
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
		this.producto.setCodigo(0);
		this.producto.setNombre("");
		this.producto.setPrecio(0);
	}

	private void registrar() throws Exception {
		ProductoDao dao;
		try {
			dao = new ProductoDao();
			System.out.println(producto.getNombre());
			dao.registrar(producto);
			this.traerProductos();
		} catch (Exception e) {
			throw e;
		}
	}

	public void traerProductos() throws Exception {
		ProductoDao dao;
		try {
			dao = new ProductoDao();
			lstProductos = dao.traerProductos();
		} catch (Exception e) {
			throw e;
		}
	}

	public void leerID(Producto pro) throws Exception {
		ProductoDao dao;
		Producto temp;
		try {
			dao = new ProductoDao();
			temp = dao.leerID(pro);

			if (temp != null) {
				this.producto = temp;
				this.accion = "Modificar";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void modificar() throws Exception {
		ProductoDao dao;
		try {
			dao = new ProductoDao();
			dao.modificar(producto);
			this.traerProductos();
		} catch (Exception e) {
			throw e;
		}
	}

	public void eliminar(Producto pro) throws Exception {
		ProductoDao dao;
		try {
			dao = new ProductoDao();
			dao.eliminar(pro);
			this.traerProductos();
		} catch (Exception e) {
			throw e;
		}
	}
}
