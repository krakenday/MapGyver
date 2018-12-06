package entity.uc4Voyage;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
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

	public EntityCoordonnee getCoordonnee() {
		return entityCoordonnee;
	}

	public void setCoordonnee(EntityCoordonnee entityCoordonnee) {
		this.entityCoordonnee = entityCoordonnee;
	}
	
	@Override
	public String toString() {
		return "EntityPOI [id=" + id + ", nom=" + nom + ", coord. =" + entityCoordonnee + "]";
	}



}
