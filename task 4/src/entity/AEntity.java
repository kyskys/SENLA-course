package entity;

public abstract class AEntity {
	protected String entityNumber;
	//������� � �������� ����� ���������� ���� - ����� ��������\������ (���������� �������������)
	
	public AEntity(String entityNumber) {
		this.entityNumber=entityNumber;
	}
	public String getNumber() {
		return entityNumber;
	}

	public void setNumber(String name) {
		this.entityNumber = name;
	}
}
