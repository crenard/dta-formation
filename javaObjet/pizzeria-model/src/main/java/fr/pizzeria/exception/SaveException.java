package fr.pizzeria.exception;

public class SaveException extends StockageException {

	public SaveException() {
		super();
	}

	public SaveException(String string) {
		super(string);
	}

	public SaveException(Throwable cause) {
		super(cause);
	}

	public SaveException(String message, Throwable cause) {
		super(message, cause);
	}
}
