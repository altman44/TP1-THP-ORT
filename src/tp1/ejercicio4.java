package tp1;
import java.util.Scanner;

public class ejercicio4 {
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		int flag = 0;
		do {
			try {
				int num1 = 0, num2 = 0;
				System.out.println("Ingrese el primer número: ");
				num1 = input.nextInt();
				System.out.println("Ingrese el segundo número: ");
				num2 = input.nextInt();
				int suma = num1 + num2;
				System.out.println("La suma entre " + num1 + " y " + num2 + " es: " + suma);
	
			}catch(Exception e){
				System.out.println("El dato ingresado no es válido!");	//significa que saltó un error, o sea, no es un número	
				flag = 1;
				input.nextLine();
			}
		}while(flag != 0); //flag va a ser distinto de 0 siempre que ocurra un error
		
		input.close();
	}

}
