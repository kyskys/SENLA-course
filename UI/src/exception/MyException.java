package exception;

public class MyException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MyException(Throwable cause) {
		super(cause);
	}

}
