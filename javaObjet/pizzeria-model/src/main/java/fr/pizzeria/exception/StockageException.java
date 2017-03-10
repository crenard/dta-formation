package fr.pizzeria.exception;

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
	public StockageException(String string) {
		super(string);
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
