package tp1;
import java.util.Scanner;

public class ejercicio7 {
	public static Scanner input = new Scanner(System.in);
			
	public static void main(String[] args) {
		int veces = 5, cant_mayores_rep = 1, num = 0;
		int orden_ingresado = 1; //empieza en 1 porque por predeterminado el mayor es el primer n�mero ingresado
		int ordenes_ingresados[] = new int[veces]; //va a almacenar las posiciones en las que se repite el n�mero mayor
		int mayor = Ingreso_de_Num(); //mayor va a ser el primer numero ingresado (no conviene que valga 0 porque si el usuario ingresa todos los n�meros negativos va a quedar como que el mayor es el 0, un n�mero que el usuario no ingres� 
		ordenes_ingresados[0] = 1; //la primer posici�n al principio es la mayor. En caso de que quede como la mayor tiene que establecerse antes de ingresar los siguientes n�meros que en la primera posici�n se encuentra el mayor (en caso de que se repita de nuevo)
		
		for(int i = 1; i < veces; i++) {
			num = Ingreso_de_Num();
			if(num > mayor) {
				mayor = num;
				orden_ingresado = i + 1;
				for(int k = 0; k < ordenes_ingresados.length; k++) {
					ordenes_ingresados[k] = 0;
				}
				ordenes_ingresados[i] = i + 1; //si se repite despu�s, el vector ya va a tener ingresada la posici�n en la que se ingres� anteriormente
				cant_mayores_rep = 1; //se reinicia a 1 porque hay un nuevo mayor entonces, por el momento, solo hay un mayor, no se repiti�
			}else if (num == mayor) {
				ordenes_ingresados[i] = i + 1; //es i + 1 porque i empieza en 1 pero la primer posici�n ya fue ingresada (primer posici�n: 1, no es 0) 
				cant_mayores_rep++;				
			}
		}
		
		input.close();
		
		if(cant_mayores_rep == veces) {
			System.out.println("Los " + veces + " n�meros son iguales");
		}else if(cant_mayores_rep > 1){
			String text_posiciones = "";
			int counter_posiciones = 0;
			for (int i = 0; i < ordenes_ingresados.length; i++) {
				if(ordenes_ingresados[i] != 0) {
					if(counter_posiciones == cant_mayores_rep-1) {
						text_posiciones += " y " + ordenes_ingresados[i] + ".";
					}else if(counter_posiciones == 0){
						text_posiciones = String.valueOf(ordenes_ingresados[i]);
					}else {
						text_posiciones += ", " + ordenes_ingresados[i];
					}
					counter_posiciones++;
				}
			}
			System.out.println("El n�mero " + mayor + " es el mayor y se repite " + cant_mayores_rep + " veces en las posiciones " + text_posiciones);
		}else {
			System.out.println("El mayor es el " + orden_ingresado + "� n�mero ingresado con un valor de: " + mayor);
		}
	}
	
	public static int Ingreso_de_Num() {
		int num = 0;
		boolean error = false;
		
		do {
			try {
				error = false;
				System.out.print("Ingrese un n�mero entero: ");
				num = input.nextInt();
			}catch(Exception e){
				System.out.println("Debe ingresar un n�mero entero");;
				error = true;
				input.nextLine();
			}
		}while(error);
		
		return num;
	}

}
