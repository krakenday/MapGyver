package service.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	// DM 28-11 ajout pour eviter erreur compil avec DaoFacade addDescription
	// TODO addDescription
	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
