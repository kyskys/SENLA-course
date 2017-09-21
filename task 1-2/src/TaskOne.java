
public class TaskOne {
	public static String[] method(String s) {
		s = s.replaceAll("([^-\\w]|\\W{2,})", " ");
		s = s.replaceAll(" +", " ");
		s = s.trim();
		return s.split(" ");
// !?!?!?! aas a-3 3-a sine-zelenoe a--a a;=a a;a A
	}
}
