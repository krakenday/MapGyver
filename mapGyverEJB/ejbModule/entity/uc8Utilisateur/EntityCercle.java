package entity.uc8Utilisateur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


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
	@Column(name= "id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column(name="nom", length=70, nullable=false)
	private String nom;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id_utilisateur", nullable= false)
	private EntityUtilisateur utilisateur;
	
	// A voir après
	@OneToMany(mappedBy="cercle", cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	private Collection<EntityUtilisateurCercle> utilisateurs= new ArrayList<EntityUtilisateurCercle>();
	
	public EntityCercle() {
		super();
	}
	
	public EntityCercle(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public EntityCercle(String nom) {
		super();
		this.nom = nom;
	}

	public EntityCercle(int id, String nom, EntityUtilisateur utilisateur) {
		super();
		this.id = id;
		this.nom = nom;
		this.utilisateur = utilisateur;
	}
	
	public EntityCercle(String nom, EntityUtilisateur utilisateur) {
		super();
		this.nom = nom;
		this.utilisateur = utilisateur;
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
	
	public EntityUtilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(EntityUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EntityCercle [id=" + id + ", nom=" + nom + ", utilisateur=" + utilisateur + "]";
	}
}
