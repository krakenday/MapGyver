
package entity.uc4Voyage;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dao.util.UtilBdD;

@Entity
@Table(name=UtilBdD.ENTITY_LIEU)
public class EntityLieu extends EntityPointInteret{

	private static final long serialVersionUID = 1L;
	
	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn(name = "id_ville", unique = true, nullable = false)
	private EntityVille ville;

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
		this.ville = ville;
	}

	public EntityVille getVille() {
		return ville;
	}

	public void setVille(EntityVille ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "EntityLieu [ville=" + ville + "]";
	}


	
}
