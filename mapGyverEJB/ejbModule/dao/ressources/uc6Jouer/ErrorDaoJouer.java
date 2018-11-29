package dao.ressources.uc6Jouer;

public enum ErrorDaoJouer {

	DOC_DOUBLON(1), 
	DOC_LOC_AFFECTEE(2),
	DOC_INEXISTANT(3),
	DOC_NULL(50),
	
	
	LOC_INEXISTANT(30),
	LOC_DOUBLON(31),
	
	
	
	DIVERS(999);

	private int code;
	
	private ErrorDaoJouer(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public String action() {
		switch(this) {
			case DOC_DOUBLON 		: return "Le document existe déjà";
			case DOC_LOC_AFFECTEE 	: return "La localisation est déjà affectée";
			case DOC_INEXISTANT 	: return "Le document n'existe pas";
			case DOC_NULL		 	: return "Le document est null";
			case LOC_INEXISTANT 	: return "La localisation n'existe pas";
			case LOC_DOUBLON 		: return "La localisation existe déjà";
			case DIVERS 			: return "Erreur non referencee";
			default 				: return "";
		}
 	}

}

