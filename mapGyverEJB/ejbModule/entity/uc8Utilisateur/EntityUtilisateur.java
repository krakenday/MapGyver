package entity.uc8Utilisateur;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 
 * Projet - MapGyver
 * <Br> 
 * @author Djallal
 * @version 1.0 AFPA ECF2 Projet MapGyver
 * 
 */

@Entity
@Table(name="UTILISATEUR")
public class EntityUtilisateur implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column(length=50, nullable= false)
	private String nom;
	@Column(length=50, nullable= false)
	private String prenom;
	@Column(length=100, nullable= false)
	private String adresse;
	@Column(length=50,  unique= true, nullable= false)
	private String email;
	@Column(length=20, nullable= false)
	private String telephone; 
	@Column(nullable= false)
	private LocalDate dateInscrip;
	@Column(nullable= false)
	private LocalDate dateNaiss;
	@Column(length=100, name="pw", nullable= false)
	@Embedded
	private EntityPassword motDePasse;
	
//	private Ville ville;
//	private Pays pays
	
	@OneToMany(mappedBy="utilisateur", cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
	private Collection<EntityCercle> lesCercles= new ArrayList<EntityCercle>();
	
	//A voir plus tard
//	@OneToMany(mappedBy="utilisateur", cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
//	private Collection<EntityUtilisateurCercle> cercles= new ArrayList<EntityUtilisateurCercle>();
	
	@ManyToMany
	@JoinTable(name="UTILISATEUR_CERCLE",
	joinColumns = @JoinColumn(name="id_utilisateur") ,
	inverseJoinColumns = @JoinColumn(name="id_cercle") )
	private Collection<EntityCercle> cercles = new ArrayList<EntityCercle>();
	
	public EntityUtilisateur() {
	}
	
	/**
	 * @param id : id de l'utilisateur
	 * @param nom : nom de l'utilisateur
	 * @param prenom : prenom de l'utilisateur
	 * */
	public EntityUtilisateur(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	/**
	 * @param nom : nom de l'utilisateur
	 * @param prenom : prenom de l'utilisateur
	 * */
	public EntityUtilisateur( String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/**
	 * @param id : id de l'utilisateur
	 * @param nom : nom de l'utilisateur
	 * @param prenom : prenom de l'utilisateur
	 * @param email : email de l'utilisateur
	 * */
	public EntityUtilisateur(int id, String nom, String prenom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	/**
	 * @param nom : nom de l'utilisateur
	 * @param prenom : prenom de l'utilisateur
	 * @param email : email de l'utilisateur
	 * */
	public EntityUtilisateur(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	/**
	 * @param id : id de l'utilisateur 
	 * @param nom : nom de l'utilisateur
	 * @param prenom : prenom de l'utilisateur
	 * @param adresse : adresse de l'utilisateur
	 * @param telephone : telephone de l'utilisateur
	 */
	public EntityUtilisateur(int id, String nom, String prenom, String adresse, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	
	/**
	 * @param nom : nom de l'utilisateur
	 * @param prenom : prenom de l'utilisateur
	 * @param adresse : adresse de l'utilisateur
	 * @param telephone : telephone de l'utilisateur
	 */
	public EntityUtilisateur(String nom, String prenom, String adresse, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	
	/**
	 * @param id : id de l'utilisateur
	 * @param nom : nom de l'utilisateur
	 * @param prenom : prenom de l'utilisateur
	 * @param adresse : adresse de l'utilisateur
	 * @param email : email de l'utilisateur
	 * @param telephone : telephone de l'utilisateur
	 * @param dateInscrip : date d'inscription de l'utilisateur sur l'application
	 * @param dateNaiss : date de naissance de l'utilisateur
	 * */
	public EntityUtilisateur(int id, String nom, String prenom, String adresse, String email, String telephone,
			LocalDate dateInscrip, LocalDate dateNaiss) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.dateInscrip = dateInscrip;
		this.dateNaiss = dateNaiss;
	}
	
	/**
	 * @param nom : nom de l'utilisateur
	 * @param prenom : prenom de l'utilisateur
	 * @param adresse : adresse de l'utilisateur
	 * @param email : email de l'utilisateur
	 * @param telephone : telephone de l'utilisateur
	 * @param dateInscrip : date d'inscription de l'utilisateur sur l'application
	 * @param dateNaiss : date de naissance de l'utilisateur
	 * @param motDePasse : mot de passe de l'utilisateur
	 * */
	public EntityUtilisateur( String nom, String prenom, String adresse, String email, String telephone,
			LocalDate dateInscrip, LocalDate dateNaiss, EntityPassword motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.dateInscrip = dateInscrip;
		this.dateNaiss = dateNaiss;
		this.setMotDePasse(motDePasse);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the dateInscrip
	 */
	public LocalDate getDateInscrip() {
		return dateInscrip;
	}

	/**
	 * @param dateInscrip the dateInscrip to set
	 */
	public void setDateInscrip(LocalDate dateInscrip) {
		this.dateInscrip = dateInscrip;
	}

	/**
	 * @return the dateNaiss
	 */
	public LocalDate getDateNaiss() {
		return dateNaiss;
	}

	/**
	 * @param dateNaiss the dateNaiss to set
	 */
	public void setDateNaiss(LocalDate dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	
	public EntityPassword getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(EntityPassword motDePasse) {
		this.motDePasse = motDePasse;
	}
	

	@Override
	public String toString() {
		return "EntityUtilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email="
				+ email + ", telephone=" + telephone + ", dateInscrip=" + dateInscrip + ", dateNaiss=" + dateNaiss
				+ "]";
	}

}
