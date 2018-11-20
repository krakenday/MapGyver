package webApp.uc4Voyage;

public enum ControleurVoyageMsg {

	ERROR_INSERT(300, "Erreur insert", "Verifier les données à inserer"), 
	ERROR_DELETE(301, "Erreur delete", "Verifier les données à supprimer"), 
	ERROR_SAISIES(302, "Erreur de saisies", "Verifier les données saisies"), 
	
	SUCCESS_INSERT(399, "Insertion réussit", "Enregistrement effectué"), 
	;

	private final int id;
	private final String msg;
	private final String solution;

	/**
	 * @param id code de l'erreur
	 * @param msg message explicatif de l'erreur
	 * @param solution proposition de solution pour r�soudre le probl�me
	 */
	ControleurVoyageMsg(int id, String msg, String solution) {
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
