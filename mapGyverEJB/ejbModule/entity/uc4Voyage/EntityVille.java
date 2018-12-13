
package entity.uc4Voyage;

import java.util.Objects;

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
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH }, fetch=FetchType.LAZY)
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

	@Override
	public int hashCode() {
		return Objects.hash(entityPays);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof EntityVille))
			return false;
		EntityVille other = (EntityVille) obj;
		return Objects.equals(entityPays, other.entityPays);
	}
}
