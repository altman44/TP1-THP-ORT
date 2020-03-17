package tp1;
import java.util.Scanner;

public class ejercicio8 {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int num_dia = 0;
		String dia = "";
		
		System.out.println("Teniendo en cuenta que el Domingo es el primer día de la semana.");
		do {
			num_dia = Ingresar_Num_Dia();
			if(num_dia < 1 || num_dia > 7) { //para la primera vez este if es innecesario, pero para el resto de las veces sí sirve
				System.out.println("El día ingresado no es válido.");
			}
		}while(num_dia < 1 || num_dia > 7);
		
		input.close();
		
		switch(num_dia) {
		case 1:
			dia = "Domingo";
			break;
		case 2:
			dia = "Lunes";
			break;
		case 3:
			dia = "Martes";
			break;
		case 4:
			dia = "Miércoles";
			break;
		case 5:
			dia = "Jueves";
			break;
		case 6:
			dia = "Viernes";
			break;
		case 7:
			dia = "Sábado";
			break;
		default:
			dia = "Hubo un error";
			break;
		}
		System.out.println("El día elegido es: " + dia);
	}
	
	public static int Ingresar_Num_Dia() {
		boolean error = false;
		int numero = 0;
		do {
			try {
				error = false;
				System.out.print("Ingrese un número correspondiente al número que desea imprimir:");
				numero = input.nextInt();
			}catch(Exception e) {
				System.out.println("Debe ingresar un número.");
				error = true;
				input.nextLine();
			}
		}while(error);
		
		return numero;
	}
}
