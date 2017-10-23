package com.senla.sort;

public enum SortParameters {
	ALPHABET("alphabet"), BUSY("busy"), ADDED_DATE("added date"), ENDING_DATE("ending date"), PRICE(
			"price"), START_WORKING_ON_DATE("start date");
	SortParameters(String str) {
		this.setStringValue(str);
	}

	private String stringValue;

	public static SortParameters getValueOf(String stringValue) {
		SortParameters[] sortParams = SortParameters.values();
		for (int i = 0; i < sortParams.length; i++) {
			if (sortParams[i].getStringValue().equals(stringValue)) {
				return sortParams[i];
			}
		}
		return null;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

}
