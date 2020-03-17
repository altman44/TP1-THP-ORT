package tp1;
import java.util.Scanner;

public class ejercicio3 {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		String name = "";
		name = input.nextLine();
		input.close();
		System.out.println("Welcome " + name + "!");
	}
}
