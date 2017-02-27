package fr.pizzeria.exception;

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

}
