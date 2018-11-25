package entity.uc8Utilisateur;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//import javax.persistence.Entity;

@Entity
@AttributeOverride(name="id", column=@Column(name="id_Groupe"))
@Table(name=("Groupe"))
public class EntityGroupe extends EntityCercle {

	public EntityGroupe() {
	}

	
	public EntityGroupe(String nom) {
		super(nom);
	}


	public EntityGroupe(int id, String nom) {
		super(id, nom);
	}

}
