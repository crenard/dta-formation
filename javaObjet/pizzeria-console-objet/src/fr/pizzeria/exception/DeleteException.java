package fr.pizzeria.exception;

public class DeleteException extends StockageException {

	public DeleteException() {
		super();
	}

	public DeleteException(String string) {
		super(string);
	}

	public DeleteException(Throwable cause) {
		super(cause);
	}
}
