package webApp.uc4Voyage;

public enum ControleurVoyageMsg {

	ERROR_SAISIES(300, "Erreur de saisies", "Verifier les données saisies"), 
	ERROR_INSERT(301, "Erreur insert", "Verifier les données à inserer"), 
	ERROR_DELETE(302, "Erreur delete", "Verifier les données à supprimer"), 
	ERROR_UPDATE(303, "Modification réussit", "Modification effectué"),
	
	SUCCESS_UPDATE(397, "Modification réussit", "Modification effectué"),
	SUCCESS_DELETE(398, "Suppression réussit", "Suppression effectué"),
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
