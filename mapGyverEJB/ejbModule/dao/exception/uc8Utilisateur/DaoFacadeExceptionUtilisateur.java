package dao.exception.uc8Utilisateur;


public class DaoFacadeExceptionUtilisateur extends Exception {

	private static final long serialVersionUID = 1L;
	
	private int code;

	public DaoFacadeExceptionUtilisateur(String message) {
		super(message);
	}

	public DaoFacadeExceptionUtilisateur(int code, String message) {
		super(message); 
		this.code= code;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
}
