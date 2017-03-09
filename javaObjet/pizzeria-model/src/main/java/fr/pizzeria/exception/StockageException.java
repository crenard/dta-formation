package fr.pizzeria.exception;

@SuppressWarnings("serial")
public class StockageException extends RuntimeException {

	public StockageException() {
		super();
	}

	public StockageException(String string) {
		super(string);
	}

	public StockageException(Throwable cause) {
		super(cause);
	}

	public StockageException(String message, Throwable cause) {
		super(message, cause);
	}
}
