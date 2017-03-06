package fr.pizzeria.exception;

public class StockageException extends Exception {

	public StockageException() {
		super();
	}

	public StockageException(String string) {
		super(string);
	}

	public StockageException(Throwable cause) {
		super(cause);
	}
}
