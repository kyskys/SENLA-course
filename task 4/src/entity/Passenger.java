package entity;

public class Passenger extends AEntity {

	private String name;
	// � ��������� ���� ��� - ��� ����� �����������

	public Passenger(String passportNumber, String name) {
		super(passportNumber);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
