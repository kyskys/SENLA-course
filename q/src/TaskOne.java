
public class TaskOne {
	public static String[] method(String s) {
		s = s.replaceAll("[\\W*|-]\\W+", " ");
		s = s.replaceAll(" +", " ");
		s.trim();
		return s.split(" ");

	}
}
