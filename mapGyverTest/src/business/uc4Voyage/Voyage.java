package business.uc4Voyage;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Projet MapGyver
 * <br>
 * Cet classe permet d'instancier un objet de type voyage. 
 * Un voyage est : une periode durant laquelle une personne 
 * suit un ou plusieurs itinéraires.
 * <br>
 * cet objet voyage comprend : 
 * <br> id 				: numero de reference du voyage
 * <br> nom 			: nom du voyage
 * <br> dateDebut 		: date de debut du voyage
 * <br> nbParticipant 	: nb de personnes participant a ce voyage
 * <br> pointInteret 	: ensemble de lieux parcouru lors du voyage
 * <p>
 * @author Idriss
 * @version Afpa ECF3 Projet MapGyver version Novembre 2018
 */
public class Voyage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int 					id;
	private String 					nom;
	private LocalDate 				dateDebut;
	private Integer					nbParticipant;
	private ArrayList<PointInteret> pointInteret;
	
	/**
	 * @param id 			: numero de reference du voyage
	 * @param nom 			: nom du voyage
	 * @param dateDebut 	: date de debut du voyage
	 * @param nbParticipant : nb de personnes participant a ce voyage
	 * @param pointInteret 	: ensemble de lieux parcouru lors du voyage
	 */
	public Voyage(int id, String nom, LocalDate dateDebut, 
			Integer nbParticipant, ArrayList<PointInteret> pointInteret) {
		this.id 			= id;
		this.nom 			= nom;
		this.dateDebut 		= dateDebut;
		this.nbParticipant 	= nbParticipant;
		this.pointInteret 	= pointInteret;
	}

	/**
	 * @param nom           : nom du voyage
	 * @param dateDebut     : date de debut du voyage
	 * @param nbParticipant : nb de personnes participant a ce voyage
	 * @param pointInteret  : ensemble de lieux parcouru lors du voyage
	 */
	public Voyage(String nom, LocalDate dateDebut,
			Integer nbParticipant, ArrayList<PointInteret> pointInteret) {
		this.nom 			= nom;
		this.dateDebut 		= dateDebut;
		this.nbParticipant 	= nbParticipant;
		this.pointInteret 	= pointInteret;
	}

	/**
	 * @param nom           : nom du voyage
	 */
	public Voyage(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @return numero de reference du voyage
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id : numero de reference du voyage
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return nom du voyage
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom : nom du voyage
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return date de debut du voyage
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut : date de debut du voyage
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return nb de personnes participant a ce voyage
	 */
	public Integer getNbParticipant() {
		return nbParticipant;
	}

	/**
	 * @param nbParticipant : nb de personnes participant a ce voyage
	 */
	public void setNbParticipant(Integer nbParticipant) {
		this.nbParticipant = nbParticipant;
	}

	/**
	 * @return ensemble de lieux parcouru lors du voyage
	 */
	public ArrayList<PointInteret> getPointInteret() {
		return pointInteret;
	}

	/**
	 * @param pointInteret : ensemble de lieux parcouru lors du voyage
	 */
	public void setPointInteret(ArrayList<PointInteret> pointInteret) {
		this.pointInteret = pointInteret;
	}

	@Override
	public String toString() {
		return String.format("Voyage [id= %s, nom= %s, dateDebut= %s, nbParticipant= %s, pointInteret= %s]",
				id, nom, dateDebut, nbParticipant, pointInteret);
	}
	
}
