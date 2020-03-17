package tp1;
import java.util.Scanner;

public class ejercicio10 {
	private static Scanner input = new Scanner(System.in);
	private static int HORA_APERTURA = 10;
	private static int HORA_CIERRE = 18;
	
	public static void main(String[] args) {
		boolean estaAbierto = false;
		estaAbierto = ingresarHora();
		if (estaAbierto) {
			System.out.println("Estacionamiento abierto");
		}else {
			System.out.println("Estacionamiento cerrado");
		}
	}
	
	public static boolean ingresarHora() {
		int hora = 0;
		boolean error = false;
		do {
			try {
				error = false;
				System.out.print("Ingrese la hora: ");
				hora = input.nextInt();
				if(hora < 0 || hora >= 24) {
					error = true;
					System.out.println("Hora incorrecta!");
				} else if(hora < HORA_APERTURA || hora > HORA_CIERRE) { //estacionamiento cerrado
					return false;
				}
			} catch(Exception e) { 
				System.out.println("La hora se indica con un número!");
				input.nextLine();
				error = true;
			}
		} while (error);
		
		//si no hay error, la hora fue ingresada correctamente y el estacionamiento está abierto
		return true;
	}
}
