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
 * Une liste de diffusion est un cercle
 *  
 */

@Entity
@Table(name=("LISTEDIFF"))
public class EntityListeDiffusion extends EntityCercle implements Serializable {

	private static final long serialVersionUID = 1L;

	
	public EntityListeDiffusion() {
	}
	
	public EntityListeDiffusion(int id, String nom) {
		super(id, nom);
	}
	
	public EntityListeDiffusion(String nom) {
		super(nom);
	}

	public EntityListeDiffusion(int id, String nom, EntityUtilisateur utilisateur) {
		super(id, nom, utilisateur);
	}

	public EntityListeDiffusion(String nom, EntityUtilisateur utilisateur) {
		super(nom, utilisateur);
	}
}
