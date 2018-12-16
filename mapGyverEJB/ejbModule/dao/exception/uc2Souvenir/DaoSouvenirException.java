package dao.exception.uc2Souvenir;

public class DaoSouvenirException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private int code;
	private String solution;

//	public DaoSouvenirException(String message) {
//		super(message);
//	}

	public DaoSouvenirException(int code, String message) {
		super(message); 
		this.code= code;
	}

	public DaoSouvenirException(DaoSouvenirErrorMessage error) {
		super(error.getMsg());
		this.code = error.getCodeErreur();
		this.solution = (error.getSolution());
		System.out.println("DaoSouvenirException-DaoSouvenirException- Exception cree");
	}

	
	public int getCode() {
		return code;
	}

	public String getSolution() {
		return solution;
	}

}
