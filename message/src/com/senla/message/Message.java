package com.senla.message;

import java.io.Serializable;

public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object message;
	private Object[] parameters;

	public Message(Object message) {
		this.message = message;
	}

	public Message(Object message, Object... parameters) {
		this.parameters = parameters;
		this.message = message;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public Object[] getParameters() {
		return parameters;
	}

	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}
}
