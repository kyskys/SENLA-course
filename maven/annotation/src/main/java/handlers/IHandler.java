package handlers;

import java.lang.reflect.Field;

public interface IHandler {
	void handle(Object object, Field field) throws Throwable;
}
