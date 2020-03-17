package tp1;
import java.util.Date;

public class Compras {
	private static String fecha;
	private static String comprador;
	private static String producto;
	private static int cantidad;
	private static float precioUnitario;
	private static float total;
	
	public Compras(String fecha, String comprador, String producto, int cantidad, float precioUnitario, float total) {
		this.fecha = fecha;
		this.comprador = comprador;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.total = total;
	}

	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
		
	public String getComprador() {
		return comprador;
	}
	
	public void setComprador(String comprador) {
		this.comprador = comprador;
	}
	
	public String getProducto() {
		return producto;
	}
	
	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario= precioUnitario;
	}
	
	public float getTotal() {
		return total;
	}
	
	public void setTotal(float total) {
		this.total = total;
	}
}
