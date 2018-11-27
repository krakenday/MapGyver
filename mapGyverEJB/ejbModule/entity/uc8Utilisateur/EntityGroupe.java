package entity.uc8Utilisateur;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name=("GROUPE"))
public class EntityGroupe extends EntityCercle implements Serializable {

	private static final long serialVersionUID = 1L;


	public EntityGroupe() {
	}
	
	public EntityGroupe(String nom) {
		super(nom);
	}

	public EntityGroupe(int id, String nom) {
		super(id, nom);
	}

}
