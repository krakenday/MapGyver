package entity.uc8Utilisateur;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name=("LISTEDIFF"))
public class EntityListeDiffusion extends EntityCercle implements Serializable {

	private static final long serialVersionUID = 1L;


	public EntityListeDiffusion() {
	}
	
	
	public EntityListeDiffusion(String nom) {
		super(nom);
	}


	public EntityListeDiffusion(int id, String nom) {
		super(id, nom);
	}

}
