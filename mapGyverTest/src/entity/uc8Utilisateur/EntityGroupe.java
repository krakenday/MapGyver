package entity.uc8Utilisateur;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * Projet - MapGyver
 * <Br> 
 * @author Djallal
 * @version 1.0 AFPA ECF2 Projet MapGyver
 * 
 * Un groupe est un cercle
 *  
 */

@Entity
@Table(name=("GROUPE"))
public class EntityGroupe extends EntityCercle implements Serializable {

	private static final long serialVersionUID = 1L;


	public EntityGroupe() {
	}
	
	public EntityGroupe(int id, String nom) {
		super(id, nom);
	}
	
	public EntityGroupe(String nom) {
		super(nom);
	}

	public EntityGroupe(int id, String nom, EntityUtilisateur utilisateur) {
		super(id, nom, utilisateur);
	}

	public EntityGroupe(String nom, EntityUtilisateur utilisateur) {
		super(nom, utilisateur);
	}
	
}

