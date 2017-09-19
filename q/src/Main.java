import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TaskTwo.method();
		String[] a = TaskOne.method(sc.nextLine());
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}

}
