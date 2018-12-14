
package entity.uc4Voyage;

import javax.persistence.Entity;
import javax.persistence.Table;

import dao.util.UtilBdD;

@Entity
@Table(name=UtilBdD.ENTITY_PAYS)
public class EntityPays extends EntityPointInteret{

	private static final long serialVersionUID = 1L;
	public static final int NB_TOTAL = 197;
	
	public EntityPays() {
	}
	
	public EntityPays(String nom) {
		super(nom);
	}

	public EntityPays(String nom, EntityCoordonnee entityCoordonnee) {
		super(nom, entityCoordonnee);
	}

	@Override
	public String toString() {
		return "EntityPays " + super.toString();
	}
	
	
	
}
