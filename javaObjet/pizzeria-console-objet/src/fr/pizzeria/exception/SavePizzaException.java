package fr.pizzeria.exception;

public class SavePizzaException extends StockageException {

	public SavePizzaException() {
		super();
	}

	public SavePizzaException(String string) {
		super(string);
	}

	public SavePizzaException(Throwable cause) {
		super(cause);
	}
}
