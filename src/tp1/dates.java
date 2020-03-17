package tp1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dates {
	private static String fecha;
	
	public dates(String fecha) {
		this.fecha = fecha;
	}

	public static String pedirHora() {
		Date date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		fecha = hourFormat.format(date);
		return fecha;
	}

	public static String pedirDia() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		fecha = dateFormat.format(date);
		return fecha;
	}
	
	public static String pedirDiaHora() {
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		fecha = hourdateFormat.format(date);
		return fecha;
	}
	
}
