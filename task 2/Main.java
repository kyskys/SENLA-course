public class Main {
public static void main(String[] args) {
Aspirant a = new Aspirant();
Workplace w = new Workplace();
Education e = new Education();
a.addWorkplace(w);
a.addEducation(e);
Summary s = new Summary();
s.setAspirant(a);
}
}