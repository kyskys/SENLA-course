import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("task one: input string to find words");
		Scanner sc = new Scanner(System.in);
		String[] a = TaskOne.method(sc.nextLine());
		System.out.print("words:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println("\n\ntask two:");
		TaskTwo.method();
		sc.close();
	}
}
