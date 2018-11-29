package service.exception.uc4Voyage;

public enum ServiceVoyageErrorMessage {

	ERR_INSERT(300, "ServiceVoyage Erreur insert", "verifié les données"), 
	ERR_DELETE(301, "ServiceVoyage Erreur delete", "verifié les données"),

	;

	private final int id;
	private final String msg;
	private final String solution;

	/**
	 * @param id code de l'erreur
	 * @param msg message explicatif de l'erreur
	 * @param solution proposition de solution pour r�soudre le probl�me
	 */
	ServiceVoyageErrorMessage(int id, String msg, String solution) {
		this.id = id;
		this.msg = msg;
		this.solution = solution;
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
