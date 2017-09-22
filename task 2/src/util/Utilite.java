package util;

public class Utilite {

	public static void method() {
		int a = generate();
		int b = generate();
		int c = generate();
		int res = Integer.parseInt((a + "" + b)) - c;
		System.out.println(res);
	}

	public static int generate() {
		int res = new java.util.Random().nextInt(899) + 100;
		System.out.println(res);
		return res;

	}
}
