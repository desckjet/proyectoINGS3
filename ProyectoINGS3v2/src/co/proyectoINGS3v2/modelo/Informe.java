package co.proyectoINGS3v2.modelo;

public class Informe {

	private String personaNombre;
	private String productoNombre;
	private int productoCantidad;
	private double monto;
	
	public String getPersonaNombre() {
		return personaNombre;
	}
	public void setPersonaNombre(String personaNombre) {
		this.personaNombre = personaNombre;
	}
	public String getProductoNombre() {
		return productoNombre;
	}
	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}
	public int getProductoCantidad() {
		return productoCantidad;
	}
	public void setProductoCantidad(int producto_Cantidad) {
		this.productoCantidad = producto_Cantidad;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
}
