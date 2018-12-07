package dao.exception.uc4Voyage;

public enum DaoVoyageErrorMessage {

	ERR_VIOLATION_CONTRAINT	(300, "Pb de contrainte", "verifi� les donn�es"),
	ERR_INSERT				(301, "insert", "verifi� les donn�es"), 
	ERR_DELETE				(302, "delete", "verifi� les donn�es"), 
	ERR_UPDATE				(303, "update", "verifi� les donn�es"), 
	;

	private final int id;
	private final String msg;
	private final String solution;

	/**
	 * @param id code de l'erreur
	 * @param msg message explicatif de l'erreur
	 * @param solution proposition de solution pour r�soudre le probl�me
	 */
	DaoVoyageErrorMessage(int id, String msg, String solution) {
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
