package ressources;

public enum Erreur {
	
		DOC_DOUBLON(1), 
		DOC_LOC_AFFECTEE(2),
		DOC_INEXISTANT(3),
		
		
		LOC_INEXISTANT(30),
		LOC_DOUBLON(31),
		
		
		
		DIVERS(999);

		private int code;
		
		private Erreur(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		public String action() {
			switch(this) {
				case DOC_DOUBLON : 				return "Le document existe déjà";
				case DOC_LOC_AFFECTEE : 		return "La localisation est déjà affectée";
				case DOC_INEXISTANT : 			return "Le document n'existe pas";
				case LOC_INEXISTANT : 			return "La localisation n'existe pas";
				case LOC_DOUBLON : 				return "La localisation existe déjà";
				case DIVERS : 					return "Erreur non referencee";
				default : 						return "";
			}
	 	}

}
