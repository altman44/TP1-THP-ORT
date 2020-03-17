package tp1;

import java.util.Scanner;
import java.util.Arrays;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ejercicio11 {
	private static Scanner input = new Scanner(System.in);
	private static int contadorCompras = 0;
	static Compras compras[] = new Compras[50];

	public static void main(String[] args) {
		int operacion = -1;

		ofrecerOperaciones();
		if (operacion == 0) {
			comprarProducto();
		} else if (operacion == 1) {
			mostrarCompra();
		}
	}

	public static void ofrecerOperaciones() {
		boolean error = false;
		int operacion = -1;

		do {
			try {
				error = false;
				System.out.println("Ingrese qué operación desea hacer:");
				System.out.println("(0): Comprar un producto");
				System.out.println("(1): Mostrar compra");
				operacion = input.nextInt();
				if (operacion == 0) {
					comprarProducto();
				} else if (operacion == 1) {
					mostrarCompra();
				} else {
					System.out.println("Debe ingresar un 0 o un 1");
					error = true;
				}
			} catch (Exception e) {
				System.out.println("Debe ingresar un número");
				error = true;
				input.nextLine();
			}
		} while (error);

		input.close();
	}

	public static void comprarProducto() {
		// Declaración de variables
		Object producto[] = new Object[2];
		String nombreComprador = "", nombreProducto = "";
		int datosCorrectos = 0;
		int numeroProducto = 0, cantidad = 0;
		int cantidadMaximaProductos = 50;
		float precioUnitario = 0, total = 0;
		boolean salir = false;
		Productos[] products = new Productos[5];

		do {
			// Ingreso de datos
			// Nombre del comprador
			System.out.print("Ingrese el nombre del comprador: ");
			nombreComprador = input.next();

			// Número de producto
			for (int i = 0; i < products.length; i++) {
				producto = GenerarProducto(i);
				nombreProducto = (String) producto[0];
				precioUnitario = (Float) producto[1];
				System.out.println("Producto " + (i + 1) + ": " + nombreProducto);
				products[i] = new Productos(producto[0].toString(), (Float) producto[1]);
			}

			numeroProducto = pedirNumeroProducto(products.length);

			nombreProducto = products[numeroProducto - 1].getNombreProducto();
			precioUnitario = products[numeroProducto - 1].getPrecioUnitario();

			// Cantidad de productos
			cantidad = pedirCantidadProductos(cantidadMaximaProductos);

			total = precioUnitario * cantidad;

			compras[contadorCompras] = new Compras(dates.pedirDiaHora(), nombreComprador, nombreProducto, cantidad, precioUnitario, total);
			
			/*No entiendo bien cómo funciona esto:
			compras[0].setFecha(dates.pedirDiaHora());
			compras[0].setComprador(nombreComprador);
			compras[0].setProducto(nombreProducto);
			compras[0].setCantidad(cantidad);
			compras[0].setPrecioUnitario(precioUnitario);
			compras[0].setTotal(total);
				
			compras[0].getFecha();
			compras[0].getComprador();
			compras[0].getProducto();
			compras[0].getCantidad();
			compras[0].getPrecioUnitario();
			compras[0].getTotal();
			*/
			
			System.out.println("\nRevise los siguientes datos"
					+ "\nTicket de la compra: "
					+ "\nFecha de la compra: " + dates.pedirDiaHora()
					+ "\nNombre del comprador: " + nombreComprador
					+ "\nProducto solicitado: " + nombreProducto
					+ "\nCantidad: " + cantidad
					+ "\nPrecio por unidad: $" + precioUnitario
					+ "\nTotal a pagar: $" + total
					+ "\nSi los datos no son correctos indique (1). "
					+ "En caso contrario, presione cualquier otra tecla.");

			try {
				salir = true;
				datosCorrectos = input.nextInt();
				if (datosCorrectos == 1) {
					salir = false;
				}
			} catch (Exception e) {
				salir = true;
			} // lo único que importa es que no sea 0, así que si ocurre un error no hay
				// problema, no es que ingresó algún dato incorrectamente
			input.nextLine();
		} while (salir == false);

		contadorCompras++; //se tiene que incrementar una vez que se establecieron todos los datos correctamente
		// recién se ejecuta ofrecerOperaciones una vez que se haya salido del while, o
		// sea, cuando el usuario corrobora que los datos son correctos
		ofrecerOperaciones();
	}

	public static Object[] GenerarProducto(int numero) {
		Object producto[] = new Object[2];
		float precio = 0;
		String nombreProducto = "";

		switch (numero) {
		case 0:
			nombreProducto = "PC";
			precio = 10000;
			break;
		case 1:
			nombreProducto = "Mouse";
			precio = 100;
			break;
		case 2:
			nombreProducto = "Teclado";
			precio = 500;
			break;
		case 3:
			nombreProducto = "Parlante";
			precio = 800;
			break;
		case 4:
			nombreProducto = "Notebook";
			precio = 15000;
			break;
		default:
			break;
		}

		producto[0] = nombreProducto;
		producto[1] = precio;

		return producto;
	}

	public static int pedirNumeroProducto(int max) {
		int numero = 0;
		boolean error = false;

		do {
			try {
				error = false;
				System.out.print("Ingresar número de producto: ");
				numero = input.nextInt();
				if (numero > max || numero <= 0) {
					System.out.println("Debe ingresar un número entero entre 1 y " + max);
					error = true;
				}
			} catch (Exception e) {
				System.out.println("Debe ingresar uno de los números correspondientes a los productos");
				input.nextLine();
				error = true;
			}
		} while (error);

		return numero;
	}

	public static int pedirCantidadProductos(int max) {
		int cantidad = 0;
		boolean error = false;
		do {
			try {
				error = false;
				System.out.print("Ingrese la cantidad de productos: ");
				cantidad = input.nextInt();
				if (cantidad <= 0 || cantidad > max) {
					System.out.println("Debe ingresar una cantidad entera entre 1(mín) y " + max + "(máx)");
					error = true;
				}
			} catch (Exception e) {
				System.out.println("Debe ingresar un número para la cantidad de productos");
				input.nextLine();
				error = true;
			}
		} while (error);

		return cantidad;
	}

	public static void mostrarCompra() {
		for(int i=0;i<compras.length;i++) {
			System.out.println(compras[i].getComprador());
		}
	}

	public static String pedirString(String msg) {
		String res = "";
		res = input.next();
		return res;
	}
}
