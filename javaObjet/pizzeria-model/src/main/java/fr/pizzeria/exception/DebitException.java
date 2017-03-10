package fr.pizzeria.exception;

/**
 * Exception liee au debit d'un client
 * 
 * @author ETY 10
 *
 */
@SuppressWarnings("serial")
public class DebitException extends SoldeException {

	/**
	 * Creation d'exception
	 * 
	 */
	public DebitException() {
		super();
	}

	/**
	 * Creation d'exception
	 * 
	 * @param message
	 * @param cause
	 */
	public DebitException(String message, Throwable cause) {
		super(message, cause);
	}

}
