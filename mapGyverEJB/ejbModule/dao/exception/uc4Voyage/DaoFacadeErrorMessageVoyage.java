package dao.exception.uc4Voyage;

public enum DaoFacadeErrorMessageVoyage {

	ERR_INSERT(300, "DaoFacade Erreur insert", "verifi� les donn�es"), 
	ERR_DELETE(301, "DaoFacade Erreur delete", "verifi� les donn�es"),

	;

	private final int id;
	private final String msg;
	private final String solution;

	/**
	 * @param id code de l'erreur
	 * @param msg message explicatif de l'erreur
	 * @param solution proposition de solution pour r�soudre le probl�me
	 */
	DaoFacadeErrorMessageVoyage(int id, String msg, String solution) {
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
