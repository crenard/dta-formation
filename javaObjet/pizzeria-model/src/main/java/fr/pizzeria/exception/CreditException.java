package fr.pizzeria.exception;

@SuppressWarnings("serial")
public class CreditException extends SoldeException {

	public CreditException() {
		super();
	}

	public CreditException(String message) {
		super(message);
	}

	public CreditException(Throwable cause) {
		super(cause);
	}

	public CreditException(String message, Throwable cause) {
		super(message, cause);
	}

}
