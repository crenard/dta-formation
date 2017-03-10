package fr.pizzeria.exception;

/**
 * Exception liee au credit d'un client
 * 
 * @author ETY 10
 *
 */
@SuppressWarnings("serial")
public class CreditException extends SoldeException {
	/**
	 * Creation d'exception
	 */
	public CreditException() {
		super();
	}

	/**
	 * Creation d'exception
	 * 
	 * @param message
	 * @param cause
	 */
	public CreditException(String message, Throwable cause) {
		super(message, cause);
	}

}
