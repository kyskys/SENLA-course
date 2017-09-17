public class Aspirant extends Man{
private Workplace[] workplace = new Workplace[1];
private Education[] education = new Education[1];
private String characteristics;
public Aspirant() {
super();
System.out.println("aspirant created");
}
public Workplace getWorkplace(int num) {
return workplace[num];
}
public Education getEducation(int num) {
return education[num];
}
public void addWorkplace(Workplace w) {
System.out.println("workplace added");
workplace[0]=w;
}
public void addEducation(Education e) {
System.out.println("education added");
education[0]=e;
}
public String getCharacteristics() {
return characteristics;
}
public void showProfessions() {
}
public void showEducations() {
}
} 