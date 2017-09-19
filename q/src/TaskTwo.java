
public class TaskTwo {
	public static void method() {
		int a = generate(100);
		int b = generate(100);
		int c = generate(100);
		int res = Integer.parseInt((a+""+b))-c;
		System.out.println(res);
	}
	public static int generate(int n) {
		int res = new java.util.Random().nextInt(n);
		System.out.println(res);
		return res;
		
	}
}
