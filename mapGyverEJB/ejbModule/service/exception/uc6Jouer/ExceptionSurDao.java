package service.exception.uc6Jouer;

import javax.xml.rpc.ServiceException;

public class ExceptionSurDao extends ServiceException {

	private static final long serialVersionUID = 1L;

	public ExceptionSurDao(String message, Throwable cause) {
		super(message, cause);
	}
}