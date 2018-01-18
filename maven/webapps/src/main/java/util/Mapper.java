package util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
	private final static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
	}
	public static ObjectMapper getMapper() {
		return mapper;
	}
}
