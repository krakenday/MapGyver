package service.exception.uc2Souvenir;

public class ServiceSouvenirException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private int code;
	private String solution;


	public ServiceSouvenirException(int code, String message) {
		super(message); 
		this.code= code;
	}

	public ServiceSouvenirException(ServiceSouvenirErrorMessage error) {
		super(error.getMsg());
		this.code = error.getCodeErreur();
		this.solution = (error.getSolution());
		System.out.println("ServiceSouvenirException-ServiceSouvenirException- Exception cree");
	}

	
	public int getCode() {
		return code;
	}

	public String getSolution() {
		return solution;
	}

}
