package dao.exception.uc2Souvenir;

public enum DaoSouvenirErrorMessage {
	
	ERR_VIOLATION_CONTRAINTE(200, "violation de contrainte", "verifier donnees tables"),
	ERR_INSERT				(201, "probleme insertion", "verifier donnees tables"),  
	ERR_INEXISTANT			(202, "inexistant", "verifier donnees tables"),
	ERR_LONGUEUR			(203, "ORA-12899: value too large for column", "verifier donnees tables"),
	;

	private final int codeErreur;
	private final String msg;
	private final String solution;

	/**
	 * @param codeErreur: code de l'erreur
	 * @param msg: message explicatif de l'erreur
	 * @param solution: proposition de solution pour resoudre le probleme
	 */
	DaoSouvenirErrorMessage(int codeErreur, String msg, String solution) {
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
