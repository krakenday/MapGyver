package entity.uc8Utilisateur;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Djallal
 * 
 * Classe entity Cercle
 */

@MappedSuperclass
public abstract class EntityCercle {
	@Id
	@Column(name= "idCercle")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String nom;
	
	public EntityCercle() {
		super();
	}

	public EntityCercle(String nom) {
		super();
		this.nom = nom;
	}
	
	public EntityCercle(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
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

	@Override
	public String toString() {
		return "Cercle [id=" + id + ", nom=" + nom + "]";
	}
	
	
}
