package clientServeur.exception;

public enum ServiceFacadeErrorMessageVoyage {

	ERR_INSERT(300, "Erreur insert", "Verifier les données"), 
	ERR_DELETE(301, "Erreur delete", "Verifier les données"),

	;

	private final int id;
	private final String msg;
	private final String solution;

	/**
	 * @param id code de l'erreur
	 * @param msg message explicatif de l'erreur
	 * @param solution proposition de solution pour r�soudre le probl�me
	 */
	ServiceFacadeErrorMessageVoyage(int id, String msg, String solution) {
		this.id = id;
		this.msg = msg;
		this.solution = solution.toLowerCase();
	}

	public int getId() {
		return this.id;
	}

	public String getMsg() {
		return this.msg;
	}

	public String getSolution() {
		return solution;
	}

}
