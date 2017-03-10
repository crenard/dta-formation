package fr.pizzeria.exception;

/**
 * Exception liee a la modification du solde d'un client
 * 
 * @author ETY 10
 *
 */
@SuppressWarnings("serial")
public class SoldeException extends RuntimeException {
	/**
	 * Creation d'exception
	 * 
	 */
	public SoldeException() {
		super();
	}

	/**
	 * Creation d'exception
	 * 
	 * @param message
	 * @param cause
	 */
	public SoldeException(String message, Throwable cause) {
		super(message, cause);
	}
}
