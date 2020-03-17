package tp1;
import java.util.Scanner;

public class ejercicio6 {
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		int num1 = 0;
		boolean error = false;
		do {
			try {
				error = false;
				System.out.print("Ingrese un n�mero natural: ");
				num1 = input.nextInt();
				if(num1 < 0) {
					System.out.println("El n�mero ingresado debe ser un natural");
				}
			}catch(Exception e) {
				System.out.println("Debe ingresar un n�mero entero");
				input.nextLine();
				error = true;
			}
		}while(num1 < 0 || error);
		input.close();

		int resto = num1 % 2;
		String msg = "Ha ocurrido un error"; //en verdad este mensaje se muestra si por alguna raz�n no entra al switch
		switch (resto) {
			case 0:
				msg = "El n�mero es par";
				break;
			default:
				msg = "El n�mero es impar";
				break;
		}
		System.out.println(msg);
	}

}
