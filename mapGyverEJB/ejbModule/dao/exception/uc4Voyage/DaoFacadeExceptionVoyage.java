package dao.exception.uc4Voyage;

public class DaoFacadeExceptionVoyage extends Exception {

	private static final long serialVersionUID = 3L;
	
	private int code;

	public DaoFacadeExceptionVoyage(String message) {
		super(message);
	}

	public DaoFacadeExceptionVoyage(int code, String message) {
		super(message); 
		this.code= code;
	}

	public DaoFacadeExceptionVoyage(DaoVoyageErrorMessage error) {
		error.getMsg();
	}

	/**
	 * @return the code
	 */
	
	public int getCode() {
		return code;
	}
}
