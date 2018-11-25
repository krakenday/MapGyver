package entity.uc8Utilisateur;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//import javax.persistence.Entity;

@Entity
@AttributeOverride(name="id", column=@Column(name="id_Liste"))
@Table(name=("ListeDiff"))
public class EntityListeDiffusion extends EntityCercle {
	

	public EntityListeDiffusion() {
		
	}
	
	
	public EntityListeDiffusion(String nom) {
		super(nom);
	}


	public EntityListeDiffusion(int id, String nom) {
		super(id, nom);
	}

}
