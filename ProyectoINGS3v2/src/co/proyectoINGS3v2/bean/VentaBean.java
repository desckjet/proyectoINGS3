package co.proyectoINGS3v2.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.proyectoINGS3v2.dao.VentaDao;
import co.proyectoINGS3v2.modelo.DetalleVenta;
import co.proyectoINGS3v2.modelo.Producto;
import co.proyectoINGS3v2.modelo.Venta;

@ManagedBean
@ViewScoped
public class VentaBean {
	
	private Venta venta = new Venta();
	private Producto producto = new Producto();
	private int cantidad;
	private List<DetalleVenta> lista = new ArrayList<>();

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public List<DetalleVenta> getLista() {
		return lista;
	}

	public void setLista(List<DetalleVenta> lista) {
		this.lista = lista;
	}
	
	public void agregar() {
		DetalleVenta det = new DetalleVenta();
		det.setCantidad(cantidad);
		det.setProducto(producto);
		
		this.lista.add(det);
	}
	
	public void registrar() throws Exception {
		VentaDao dao;
		double monto = 0;
		try {
			
			for(DetalleVenta det : lista) {
				monto += det.getProducto().getPrecio() * det.getCantidad();
				
			}
			
			dao = new VentaDao();
			venta.setMonto(monto);
			dao.registrar(venta, lista);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","guardado exitosamente"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"error","revice la cantidad de inventario"));
		} finally {
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		}
	}
	
}
