package fr.pizzeria.exception;

public class SoldeException extends RuntimeException {

	public SoldeException() {
		super();
	}

	public SoldeException(String message) {
		super(message);
	}

	public SoldeException(Throwable cause) {
		super(cause);
	}
}
