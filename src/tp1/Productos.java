package tp1;

public class Productos {
	private String producto;
	private float precioUnitario;
	
	public Productos(String producto, float precioUnitario) {
		this.producto = producto;
		this.precioUnitario = precioUnitario;
	}
	
	public String getNombreProducto() {
		return producto;
	}
	
	public float getPrecioUnitario() {
		return precioUnitario;
	}
}
