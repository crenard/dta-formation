package fr.pizzeria.exception;

/**
 * Exception liee a la mise a jour d'un element
 * 
 * @author ETY 10
 *
 */
@SuppressWarnings("serial")
public class UpdateException extends StockageException {
	/**
	 * Creation d'exception
	 * 
	 */
	public UpdateException() {
		super();
	}

	/**
	 * Creation d'exception
	 * 
	 * @param cause
	 */
	public UpdateException(Throwable cause) {
		super(cause);
	}

	/**
	 * Creation d'exception
	 * 
	 * @param message
	 * @param cause
	 */
	public UpdateException(String message, Throwable cause) {
		super(message, cause);
	}
}
