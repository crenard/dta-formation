package fr.pizzeria.exception;

/**
 * Exception liee au stockage
 * 
 * @author ETY 10
 *
 */
@SuppressWarnings("serial")
public class StockageException extends RuntimeException {
	/**
	 * Creation d'exception
	 * 
	 */
	public StockageException() {
		super();
	}

	/**
	 * Creation d'exception
	 * 
	 * @param message
	 */
	public StockageException(String message) {
		super(message);
	}

	/**
	 * Creation d'exception
	 * 
	 * @param cause
	 */
	public StockageException(Throwable cause) {
		super(cause);
	}

	/**
	 * Creation d'exception
	 * 
	 * @param message
	 * @param cause
	 */
	public StockageException(String message, Throwable cause) {
		super(message, cause);
	}
}
