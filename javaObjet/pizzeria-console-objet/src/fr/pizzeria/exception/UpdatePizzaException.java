package fr.pizzeria.exception;

public class UpdatePizzaException extends StockageException {

	public UpdatePizzaException() {
		super();
	}

	public UpdatePizzaException(String string) {
		super(string);
	}

	public UpdatePizzaException(Throwable cause) {
		super(cause);
	}
}
