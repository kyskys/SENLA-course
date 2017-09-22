package util;

public class Utilite {
	public static void method(String s) {
		String[] res = splitter(s);
		System.out.print("words:");
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}
// !?!?!?! aas a-3 3-a sine-zelenoe a--a a;=a a;a A
	}
	private static String[] splitter(String s) {
		s = s.replaceAll("([^-\\w]|\\W{2,})", " ");
		s = s.replaceAll(" +", " ");
		s = s.trim();
		return s.split(" ");
	}
	
}
