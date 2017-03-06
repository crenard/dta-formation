package fr.pizzeria.exception;

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

}
