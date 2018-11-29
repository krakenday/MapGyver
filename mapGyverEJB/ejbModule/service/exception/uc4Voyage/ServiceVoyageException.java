package service.exception.uc4Voyage;

public class ServiceVoyageException extends Exception {

	private static final long serialVersionUID = 3L;
	
	private int code;

	public ServiceVoyageException(String message) {
		super(message);
	}

	public ServiceVoyageException(int code, String message) {
		super(message); 
		this.code= code;
	}

	public ServiceVoyageException(ServiceVoyageErrorMessage error) {
		error.getMsg();
	}

	/**
	 * @return the code
	 */
	
	public int getCode() {
		return code;
	}
}
