package entity.uc4Voyage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import dao.util.UtilBdD;

@Entity
@Table(name=UtilBdD.ENTITY_POINT_INTERET)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EntityPointInteret implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_POI")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seqPOI")
	private int 	id;
	
	@Column(name="nom_POI", length=60, nullable=false)
	private String  nom;
	
	@OneToOne (cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "id_Crd", unique = true, nullable = false)
	private EntityCoordonnee entityCoordonnee;
	
	@ManyToMany(mappedBy = "entityPointInterets", fetch=FetchType.LAZY)
	private List<EntityVoyage> entityVoyages = new ArrayList<EntityVoyage>();
	
	
	// avant remove : on parcourt la collection de documents et on enleve les themes � la main
	@PreRemove
	private void removePOIFromVoyage() {
		if (entityVoyages != null) {
			for (EntityVoyage entityVoyage : entityVoyages) {
				entityVoyage.getEntityPointInterets().remove(this);
			}
		}
	}
	
	@PrePersist
	private void addPoiInVoyage() {
		if (entityVoyages != null) {
			for (EntityVoyage entityVoyage : entityVoyages) {
				entityVoyage.addPoi(this);
			}
		}
	}
	
	
	
	public EntityPointInteret() {
	}
		
	public EntityPointInteret(String nom) {
		this.nom = nom;
	}

	public EntityPointInteret(String nom, EntityCoordonnee entityCoordonnee) {
		this.nom = nom;
		this.entityCoordonnee = entityCoordonnee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<EntityVoyage> getEntityVoyages() {
		return entityVoyages;
	}

	public void setEntityVoyages(List<EntityVoyage> voyages) {
		this.entityVoyages = voyages;
	}

	public EntityCoordonnee getEntityCoordonnee() {
		return entityCoordonnee;
	}

	public void setEntityCoordonnee(EntityCoordonnee coordonnee) {
		this.entityCoordonnee = coordonnee;
	}
	
	@Override
	public String toString() {
		return String.format("EntityPointInteret [id=%s, nom=%s, entityCoordonnee=%s, nb de voyages=%s]", id, nom,
				entityCoordonnee, entityVoyages.size());
	}

	public void add(EntityVoyage entityVoyage) {
		if (entityVoyage != null) {
			if (entityVoyages == null) entityVoyages = new ArrayList<EntityVoyage>();
			if (!entityVoyages.contains(entityVoyage)) {
				entityVoyages.add(entityVoyage);
				entityVoyage.addPoi(this);
			} 
		}
	}

}
