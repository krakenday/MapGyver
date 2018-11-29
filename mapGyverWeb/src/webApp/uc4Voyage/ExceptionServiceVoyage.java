
package webApp.uc4Voyage;

public class ExceptionServiceVoyage  extends Exception {

	private static final long serialVersionUID = 3L;
	
	private int code;
	public enum ERROR_MSG {SAISIES, TITRE, DATE, PARTICIPANTS};

	public ExceptionServiceVoyage(int code, ERROR_MSG message) {
		super(message.name()); 
		this.code= code;
	}

	public ExceptionServiceVoyage(ERROR_MSG errorMsg) {
		super(errorMsg.name());
	}

	public int getCode() {
		return code;
	}
}

