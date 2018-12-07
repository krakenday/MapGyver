package dao.exception.uc4Voyage;

public enum DaoVoyageErrorMessage {

	ERR_VIOLATION_CONTRAINT	(300, "Pb de contrainte", "verifié les données"),
	ERR_INSERT				(301, "insert", "verifié les données"), 
	ERR_DELETE				(302, "delete", "verifié les données"), 
	ERR_UPDATE				(303, "update", "verifié les données"), 
	;

	private final int id;
	private final String msg;
	private final String solution;

	/**
	 * @param id code de l'erreur
	 * @param msg message explicatif de l'erreur
	 * @param solution proposition de solution pour rï¿½soudre le problï¿½me
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
