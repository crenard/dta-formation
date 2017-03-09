package fr.pizzeria.exception;

@SuppressWarnings("serial")
public class UpdateException extends StockageException {

	public UpdateException() {
		super();
	}

	public UpdateException(String string) {
		super(string);
	}

	public UpdateException(Throwable cause) {
		super(cause);
	}

	public UpdateException(String message, Throwable cause) {
		super(message, cause);
	}
}
