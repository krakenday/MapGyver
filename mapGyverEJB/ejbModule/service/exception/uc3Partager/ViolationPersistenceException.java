package service.exception.uc3Partager;

import service.exception.ServiceException;

public class ViolationPersistenceException extends ServiceException{

	// DM 28-11 ajout pour eviter erreur compil avec DaoFacade addDescription
	//TODO addDescription
	public ViolationPersistenceException() {
		super();
	}
	public ViolationPersistenceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -6968564581017610093L;

}
