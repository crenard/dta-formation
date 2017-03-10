package fr.pizzeria.exception;

/**
 * Exception liee a l'ajout d'un element
 * 
 * @author ETY 10
 *
 */
@SuppressWarnings("serial")
public class SaveException extends StockageException {

	/**
	 * Creation d'exception
	 * 
	 */
	public SaveException() {
		super();
	}

	/**
	 * Creation d'exception
	 * 
	 * @param cause
	 */
	public SaveException(Throwable cause) {
		super(cause);
	}

	/**
	 * Creation d'exception
	 * 
	 * @param message
	 * @param cause
	 */
	public SaveException(String message, Throwable cause) {
		super(message, cause);
	}
}
