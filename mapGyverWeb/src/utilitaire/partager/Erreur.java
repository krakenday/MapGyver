package utilitaire.partager;

/*
 * La classe Enum permet la gestion des messages d'erreur.
 */
public enum Erreur {
	
	DESC_DOUBLON(1), 
	DESC_LOC_AFFECTEE(20),
	DESC_INEXISTANT(30),
	DESC_NULL(40),
		
	LOC_INEXISTANT(50),
	LOC_DOUBLON(60),
	
	//Coté utilisateur
	DESC_REUSSI(70),
	DESC_IMPOSSIBLE(80);
	
	private int code;
	
	private Erreur(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public String action() {
		switch(this) {
			case DESC_DOUBLON 		: return "La description existe déjà";
			case DESC_LOC_AFFECTEE 	: return "La localisation de la description est déjà affectée";
			case DESC_INEXISTANT 	: return "La description n'existe pas";
			case DESC_NULL		 	: return "La description est null";
			
			case LOC_INEXISTANT 	: return "La localisation n'existe pas";
			case LOC_DOUBLON 		: return "La localisation existe déjà";
			
			case DESC_REUSSI 		: return "La création de votre description a été effectué";
			case DESC_IMPOSSIBLE 	: return "Un problème est survenu lors de la crétion de votre description";
			
			
			
			default 				: return "";
		}
 	}

}
