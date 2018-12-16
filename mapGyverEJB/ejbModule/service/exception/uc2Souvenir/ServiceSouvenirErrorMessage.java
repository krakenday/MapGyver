package service.exception.uc2Souvenir;

public enum ServiceSouvenirErrorMessage {
	
	ERR_LONGUEUR			(203, "Le commentaire est trop long (max 500 characteres)",
			"saisir un commentaire moins long"),
	;

	private final int codeErreur;
	private final String msg;
	private final String solution;

	/**
	 * @param codeErreur: code de l'erreur
	 * @param msg: message explicatif de l'erreur
	 * @param solution: proposition de solution pour resoudre le probleme
	 */
	ServiceSouvenirErrorMessage(int codeErreur, String msg, String solution) {
		this.codeErreur = codeErreur;
		this.msg = msg;
		this.solution = solution;
	}

	public int getCodeErreur() {
		return this.codeErreur;
	}

	public String getMsg() {
		return this.msg;
	}

	public String getSolution() {
		return solution;
	}

}
