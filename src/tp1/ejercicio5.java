package tp1;
import java.util.Scanner;

public class ejercicio5 {
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		float num1 = 0, num2 = 0;
		float resultado = 0; //puede ser float también
		num1 = ejercicio5.Ingresar_Num("primer");
		do {
			num2 = ejercicio5.Ingresar_Num("segundo");
			if(num2 == 0) { //para la primera vez que se entra al while no es necesario que num2 valga 0
				System.out.println("No se puede dividir por 0!");
			}
			else {
				resultado = num1 / num2;
			}
		}while(num2 == 0);
		
		input.close();
		System.out.println("El resultado de dividir " + num1 + " por " + num2 + " es: " + resultado);
	}

	public static int Ingresar_Num(String orden_numero) {
		int num = 0;
		boolean error = false;
		do {
			try {
				error = false; //en caso de que ya haya habido un error, "error" va a ser true. Al hacer error = false, "error" se reincia para esperar el nuevo número y, en caso de volver a ingresarse un dato incorrecto volverá a valer true
				System.out.print("Ingrese el " + orden_numero + " número:");
				num = input.nextInt();
			}catch(Exception e) {
				System.out.println("Algún dato no es válido!");
				error = true;
				input.nextLine();
			}
		}while(error);
		
		return num; // nunca va a devolver un error porque mientras exista ese error se va a ejecutar el while
	}
}
