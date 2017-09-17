public class Summary {
private Aspirant aspirant;
private String targetPosition;
private String extraInformation;
public Summary() {
System.out.println("summary created");
}
public Aspirant getAspirant() {
return aspirant;
}
public String getTargetPosition() {
return targetPosition;
}
public String extraInformation() {
return extraInformation;
}
public void setAspirant(Aspirant a) {
System.out.println("aspirant added");
aspirant=a;
}
}