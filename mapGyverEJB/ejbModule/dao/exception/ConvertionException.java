package dao.exception;

/**
 * Une erreur est survenue lors de la convertion d'une Entity en Metier ou vise
 * Versa.
 * 
 * @author lours
 *
 */

public class ConvertionException extends DaoException {

	private static final long serialVersionUID = 1L;

	public ConvertionException(String message, Throwable cause) {
		super(message, cause);
	}
}
