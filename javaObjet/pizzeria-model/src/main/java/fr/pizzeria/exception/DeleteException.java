package fr.pizzeria.exception;

@SuppressWarnings("serial")
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

	public DeleteException(String message, Throwable cause) {
		super(message, cause);
	}
}
