package tp1;
import java.util.Scanner;

public class ejercicio9 {
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		String nombre = "";
		float aporte = 0, porcentaje = 0;
		int totalPersonas = 3, totalAportes = 0;
		
		classAux[] personas = new classAux[totalPersonas];
		
		for(int i = 0; i < totalPersonas; i++) {
			nombre = ingresarNombre(i);
			aporte = ingresarAporte(i);
			totalAportes += aporte;
			personas[i] = new classAux(nombre, aporte, porcentaje);
		}
		
		input.close();
		
		for(int i = 0; i < totalPersonas; i++) {
			aporte = personas[i].getAporte();
			porcentaje = aporte * 100 / totalAportes;
			personas[i] = new classAux(personas[i].getNombre(), aporte, porcentaje);
			System.out.println("Nombre: " + personas[i].getNombre() + ", Capital aportado: $" + aporte + ", Porcentaje del capital: " + porcentaje + "%");
		}
		System.out.println("Monto total: " + totalAportes);
		
	}
	
	public static String ingresarNombre(int number) {
		String nombre = "";
		System.out.print("Ingrese el nombre de la persona n°" + (number + 1) + ": ");
		nombre = input.next();
		return nombre;
	}

	public static float ingresarAporte(int number) {
		float aporte = 0;
		boolean error = false, debe = false;
		do {
			try {
				error = false;
				debe = false;
				System.out.print("Ingrese el aporte de la persona n°" + (number + 1) + ": ");
				aporte = input.nextFloat();
				if(aporte <= 0) {
					System.out.println("Debe aportar algo!");
					debe = true;
				}
			} catch (Exception e) {
				System.out.println("Debe ingresar un número!");
				error = true;
				input.nextLine();
			}
		} while (error || debe);
		
		
		return aporte;
	}
}
