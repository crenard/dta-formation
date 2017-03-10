package fr.pizzeria.exception;

/**
 * Exception liee a la BDD
 * 
 * @author ETY 10
 *
 */
@SuppressWarnings("serial")
public class ConnectionException extends StockageException {

	/**
	 * Creation d'exception
	 * @param message
	 * @param cause
	 */
	public ConnectionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creation d'exception
	 * @param message
	 */
	public ConnectionException(String message) {
		super(message);
	}

	/**
	 * Creation d'exception
	 * @param cause
	 */
	public ConnectionException(Throwable cause) {
		super(cause);
	}

}
