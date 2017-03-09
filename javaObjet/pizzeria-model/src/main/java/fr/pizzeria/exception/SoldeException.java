package fr.pizzeria.exception;

@SuppressWarnings("serial")
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

	public SoldeException(String message, Throwable cause) {
		super(message, cause);
	}
}
