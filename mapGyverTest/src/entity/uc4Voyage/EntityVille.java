
package entity.uc4Voyage;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dao.util.UtilBdD;

@Entity
@Table(name=UtilBdD.ENTITY_VILLE)
public class EntityVille extends EntityPointInteret {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.LAZY)  
	@JoinColumn(name = "id_pay", unique = false, nullable = true) 
	private EntityPays entityPays;

	public EntityVille() {
	}
	
	public EntityVille(String nom) {
		super(nom);
	}

	public EntityVille(String nom, EntityCoordonnee entityCoordonnee) {
		super(nom, entityCoordonnee);
	}
	
	public EntityVille(String nom, EntityCoordonnee entityCoordonnee, EntityPays pays) {
		super(nom, entityCoordonnee);
		this.entityPays = pays;
	}

	public EntityPays getEntityPays() {
		return entityPays;
	}

	public void setEntityPays(EntityPays pays) {
		this.entityPays = pays;
	}

	@Override
	public String toString() {
		return "EntityVille " + super.toString() + String.format("[Pays=%s]", entityPays);
	}
}
