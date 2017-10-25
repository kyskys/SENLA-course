package annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public enum TypeParser {
	BOOLEAN(Boolean.class) {
		public Object parse(String toParse) {
			return Boolean.valueOf(toParse);
		}
	},
	INTEGER(Integer.class) {
		@Override
		public Object parse(String toParse) {
			return Integer.valueOf(toParse);
		}
	},
	LONG(Long.class) {
		@Override
		public Object parse(String toParse) {
			return Long.valueOf(toParse);
		}
	},
	ARRAY(Arrays.class) {
		@Override
		public Object[] parse(String toParse) {//TODO make massive from string
			return null;
		}
	},
	COLLECTION(Collections.class) {
		@Override
		public Object parse(String toParse) {
			return new ArrayList<Object>();//TODO make collection from string
		}
	};
	private TypeParser(Class<?> clazz) {
		this.clazz = clazz;
	}

	public abstract Object parse(String toParse);

	public Class<?> clazz;
}
