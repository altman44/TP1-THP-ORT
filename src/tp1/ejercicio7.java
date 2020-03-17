package tp1;
import java.util.Scanner;

public class ejercicio7 {
	public static Scanner input = new Scanner(System.in);
			
	public static void main(String[] args) {
		int veces = 5, cant_mayores_rep = 1, num = 0;
		int orden_ingresado = 1; //empieza en 1 porque por predeterminado el mayor es el primer número ingresado
		int ordenes_ingresados[] = new int[veces]; //va a almacenar las posiciones en las que se repite el número mayor
		int mayor = Ingreso_de_Num(); //mayor va a ser el primer numero ingresado (no conviene que valga 0 porque si el usuario ingresa todos los números negativos va a quedar como que el mayor es el 0, un número que el usuario no ingresó 
		ordenes_ingresados[0] = 1; //la primer posición al principio es la mayor. En caso de que quede como la mayor tiene que establecerse antes de ingresar los siguientes números que en la primera posición se encuentra el mayor (en caso de que se repita de nuevo)
		
		for(int i = 1; i < veces; i++) {
			num = Ingreso_de_Num();
			if(num > mayor) {
				mayor = num;
				orden_ingresado = i + 1;
				for(int k = 0; k < ordenes_ingresados.length; k++) {
					ordenes_ingresados[k] = 0;
				}
				ordenes_ingresados[i] = i + 1; //si se repite después, el vector ya va a tener ingresada la posición en la que se ingresó anteriormente
				cant_mayores_rep = 1; //se reinicia a 1 porque hay un nuevo mayor entonces, por el momento, solo hay un mayor, no se repitió
			}else if (num == mayor) {
				ordenes_ingresados[i] = i + 1; //es i + 1 porque i empieza en 1 pero la primer posición ya fue ingresada (primer posición: 1, no es 0) 
				cant_mayores_rep++;				
			}
		}
		
		input.close();
		
		if(cant_mayores_rep == veces) {
			System.out.println("Los " + veces + " números son iguales");
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
			System.out.println("El número " + mayor + " es el mayor y se repite " + cant_mayores_rep + " veces en las posiciones " + text_posiciones);
		}else {
			System.out.println("El mayor es el " + orden_ingresado + "° número ingresado con un valor de: " + mayor);
		}
	}
	
	public static int Ingreso_de_Num() {
		int num = 0;
		boolean error = false;
		
		do {
			try {
				error = false;
				System.out.print("Ingrese un número entero: ");
				num = input.nextInt();
			}catch(Exception e){
				System.out.println("Debe ingresar un número entero");;
				error = true;
				input.nextLine();
			}
		}while(error);
		
		return num;
	}

}
