
package entity.uc4Voyage;

import javax.persistence.Entity;
import javax.persistence.Table;

import dao.util.UtilBdD;

//@Entity
//@Table(name=UtilBdD.ENTITY_VILLE)
public class EntityVille extends EntityPointInteret{

	private static final long serialVersionUID = 1L;
	
	private int 	id;
	private String 	nom;
	
	public EntityVille(int id, String nom) {
		this.id 	= id;
		this.nom 	= nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return String.format("Ville [id=%s, nom=%s]", id, nom);
	}

}
