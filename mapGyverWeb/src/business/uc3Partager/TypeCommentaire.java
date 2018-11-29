package business.uc3Partager;

/**
 * Class Enum permettant de définir le type de description crée par un utilisateur
 * @author AlexM
 */
public enum TypeCommentaire {

	BON_PLAN("1"),
	ARNAQUE("2"),
	IMMANQUABLE("3"),
	NON_INDIQUE("4");
	
	private String typeDescription;

	private TypeCommentaire(String typeDescription) {
		this.typeDescription = typeDescription;
	}
	
	public String action() {
		switch(this) {
			case BON_PLAN   	: return "Bon plan";
			case ARNAQUE 		: return "Arnaque";
			case IMMANQUABLE 	: return "Immanquable";
			case NON_INDIQUE 	: return "Non indiqué";
			default : return "";
		}
 	}

	public String getTypeDescription() {
		return typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}
		
}
