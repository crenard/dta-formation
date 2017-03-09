package fr.pizzeria.exception;

@SuppressWarnings("serial")
public class DebitException extends SoldeException {

	public DebitException() {
		super();
	}

	public DebitException(String message) {
		super(message);
	}

	public DebitException(Throwable cause) {
		super(cause);
	}

	public DebitException(String message, Throwable cause) {
		super(message, cause);
	}

}
