package dao.exception.uc3Partager;

import dao.exception.DaoException;

public class ViolationPersistenceException extends DaoException {

	private static final long serialVersionUID = 8219046749974036577L;

	public ViolationPersistenceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
}
