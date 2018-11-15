package business.uc4Voyage;

import java.io.Serializable;

public class Document implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int 	cote;
	private String  titre;
	private String  descriptif;
	private int  	nbExemplaireDispo;

	public Document(int cote, String titre, String descriptif, int nbExemplaireDispo) {
		super();
		this.cote = cote;
		this.titre = titre;
		this.descriptif = descriptif;
		this.nbExemplaireDispo = nbExemplaireDispo;
	}

	public Document(String titre, String descriptif, int nbExemplaireDispo) {
		super();
		this.titre = titre;
		this.descriptif = descriptif;
		this.nbExemplaireDispo = nbExemplaireDispo;
	}
	
	public int getCote() {
		return cote;
	}

	public void setCote(int cote) {
		this.cote = cote;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public int getNbExemplaireDispo() {
		return nbExemplaireDispo;
	}

	public void setNbExemplaireDispo(int nbExemplaireDispo) {
		this.nbExemplaireDispo = nbExemplaireDispo;
	}

	
}
