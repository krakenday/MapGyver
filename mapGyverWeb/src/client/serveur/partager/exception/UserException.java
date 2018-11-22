package client.serveur.partager.exception;

import utilitaire.partager.Erreur;

/*
 * Classe Exception qui possède les messages et code d'erreur
 */
public class UserException extends Exception{

	private static final long serialVersionUID = -6466983831223912450L;

	private int code;

//	public UserException(int code) {						TODO: A Supprimer 
//		super();
//		this.code = code;
//	}
	
//	public UserException(String message, int code) {
//		super(message);
//		this.code = code;
//	}
	
	public UserException(Erreur erreur) {
		super(erreur.action());
		this.code = erreur.getCode();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
