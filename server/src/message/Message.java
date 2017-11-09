package message;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Message {
	private String methodName;
	private Parameter[] parameters;

	public Message(Method m) {
		this.setParameters(m.getParameters());
		this.setMethodName(m.getName());
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Parameter[] getParameters() {
		return parameters;
	}

	public void setParameters(Parameter[] parameters) {
		this.parameters = parameters;
	}
}
