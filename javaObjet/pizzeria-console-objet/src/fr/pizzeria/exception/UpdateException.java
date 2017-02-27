package fr.pizzeria.exception;

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
}
