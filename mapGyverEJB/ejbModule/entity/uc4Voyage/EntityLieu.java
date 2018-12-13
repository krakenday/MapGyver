
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
@Table(name=UtilBdD.ENTITY_LIEU)
public class EntityLieu extends EntityPointInteret{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH }, fetch=FetchType.LAZY)  
	@JoinColumn(name = "id_vil", unique = false, nullable = true) 
	private EntityVille entityVille;

	public EntityLieu() {
	}
	
	public EntityLieu(String nom) {
		super(nom);
	}

	public EntityLieu(String nom, EntityCoordonnee entityCoordonnee) {
		super(nom, entityCoordonnee);
	}
	
	public EntityLieu(String nom, EntityCoordonnee entityCoordonne, EntityVille ville) {
		super(nom, entityCoordonne); 
		this.entityVille = ville;
	}

	public EntityVille getEntityVille() {
		return entityVille;
	}

	public void setEntityVille(EntityVille ville) {
		this.entityVille = ville;
	}


	@Override
	public String toString() {
		return "EntityLieu " + super.toString() + String.format("[ville=%s]", entityVille);
	}

	@Override
	public int hashCode() {
		return Objects.hash(entityVille);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof EntityLieu))
			return false;
		EntityLieu other = (EntityLieu) obj;
		return Objects.equals(entityVille, other.entityVille);
	}

	
}
