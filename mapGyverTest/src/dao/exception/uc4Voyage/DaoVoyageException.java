package dao.exception.uc4Voyage;

public class DaoVoyageException extends Exception {

	private static final long serialVersionUID = 3L;
	
	private int code;

	public DaoVoyageException(String message) {
		super(message);
	}

	public DaoVoyageException(int code, String message) {
		super(message); 
		this.code= code;
	}

	public DaoVoyageException(DaoVoyageErrorMessage error) {
		super(error.getMsg());
		this.code = error.getId();
	}

	/**
	 * @return the code
	 */
	
	public int getCode() {
		return code;
	}
}
