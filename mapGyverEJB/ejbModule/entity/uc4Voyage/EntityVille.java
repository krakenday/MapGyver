
package entity.uc4Voyage;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dao.util.UtilBdD;

@Entity
@Table(name=UtilBdD.ENTITY_VILLE)
public class EntityVille extends EntityPointInteret {

	private static final long serialVersionUID = 1L;

	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn(name = "id_pays", unique = true, nullable = false)
	private EntityPays Pays;

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
		Pays = pays;
	}

	public EntityPays getPays() {
		return Pays;
	}

	public void setPays(EntityPays pays) {
		Pays = pays;
	}

	@Override
	public String toString() {
		return "EntityVille [Pays=" + Pays + "]";
	}

}