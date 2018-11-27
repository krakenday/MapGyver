package entity.uc8Utilisateur;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * @author Djallal
 * 
 * Classe entity Cercle
 */

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class EntityCercle implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name= "idCercle")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column(name="nom",  length=70, nullable=false)
	private String nom;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id", nullable= true)
	private EntityUtilisateur utilisateur;
	
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
