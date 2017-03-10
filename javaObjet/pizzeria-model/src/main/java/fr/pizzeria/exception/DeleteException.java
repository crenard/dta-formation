package fr.pizzeria.exception;

/**
 * Exception liee a la suppression d'un element
 * 
 * @author ETY 10
 *
 */
@SuppressWarnings("serial")
public class DeleteException extends StockageException {

	/**
	 * Creation d'exception
	 * 
	 */
	public DeleteException() {
		super();
	}

	/**
	 * Creation d'exception
	 * 
	 * @param cause
	 */
	public DeleteException(Throwable cause) {
		super(cause);
	}

	/**
	 * Creation d'exception
	 * 
	 * @param message
	 * @param cause
	 */
	public DeleteException(String message, Throwable cause) {
		super(message, cause);
	}
}
