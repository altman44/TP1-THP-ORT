package tp1;

public class classAux {
	private String nombre;
	private float aporte;
	private float porcentaje;
	
	public classAux(String nombre, float aporte, float porcentaje) { //constructor
		this.nombre = nombre;
		this.aporte = aporte;
		this.porcentaje = porcentaje;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public float getAporte() {
		return aporte;
	}
	
	public float getPorcentaje () {
		return porcentaje;
	}
}
