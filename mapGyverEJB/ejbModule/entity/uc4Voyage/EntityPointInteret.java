package entity.uc4Voyage;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import dao.util.UtilBdD;

@Entity
@Table(name=UtilBdD.ENTITY_POINT_INTERET)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract  class EntityPointInteret implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_POI")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seqPOI")
	private int 	id;
	
	@Column(name="nom_POI", length=60, nullable=false)
	private String  nom;

	public EntityPointInteret() {
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

}
