package business.uc8Utilisateur;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Projet - MapGyver Cette classe premt d'instancier un objet de type
 * utilisateur, cet utilisateur beneficiera d'un accès pour les fonctionnalités
 * de l'application <Br>
 * 
 * @author Djallal
 * @version 1.0 AFPA ECF2 Projet MapGyver
 * 
 *          TODO renseigner les régles de gestions possible
 * 
 */

public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String telephone;
	private LocalDate dateInscrip;
	private LocalDate dateNaiss;
	private Password motDePasse;
//	private Ville ville;
//	private Pays pays;

	public Utilisateur() {
		super();
	}

	/**
	 * @param nom    : nom de l'utilisateur
	 * @param prenom : prenom de l'utilisateur
	 */
	public Utilisateur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * @param id     : id de l'utilisateur
	 * @param nom    : nom de l'utilisateur
	 * @param prenom : prenom de l'utilisateur
	 * @param email  : email de l'utilisateur
	 */
	public Utilisateur(int id, String nom, String prenom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	/**
	 * @param id          : id de l'utilisateur
	 * @param nom         : nom de l'utilisateur
	 * @param prenom      : prenom de l'utilisateur
	 * @param adresse     : adresse de l'utilisateur
	 * @param email       : email de l'utilisateur
	 * @param telephone   : telephone de l'utilisateur
	 * @param dateInscrip : date d'inscription de l'utilisateur sur l'application
	 * @param dateNaiss   : date de naissance de l'utilisateur
	 */
	public Utilisateur(int id, String nom, String prenom, String adresse, String email, String telephone,
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
	 * @param nom         : nom de l'utilisateur
	 * @param prenom      : prenom de l'utilisateur
	 * @param adresse     : adresse de l'utilisateur
	 * @param email       : email de l'utilisateur
	 * @param telephone   : telephone de l'utilisateur
	 * @param dateInscrip : date d'inscription de l'utilisateur sur l'application
	 * @param dateNaiss   : date de naissance de l'utilisateur
	 * @param motDePasse  : mot de passe de l'utilisateur
	 */
	public Utilisateur(String nom, String prenom, String adresse, String email, String telephone, LocalDate dateInscrip,
			LocalDate dateNaiss, Password motDePasse) {
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

	public Password getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(Password motDePasse) {
		this.motDePasse = motDePasse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EntityUtilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", email=" + email + ", telephone=" + telephone + ", dateInscrip=" + dateInscrip + ", dateNaiss="
				+ dateNaiss + "]";
	}

}
