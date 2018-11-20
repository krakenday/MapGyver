package dao.uc4Voyage;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dao.util.UtilBdD;

@Entity
@Table(name=UtilBdD.ENTITY_VOYAGE)
public class EntityVoyage {
	
	@Id
	@Column(name="id_voyage")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int 					id;
	
	@Column(name="nom_voyage", length=60, nullable=false)
	private String 					nom;
	
	@Column(name="deb_voyage")
	private LocalDate 				dateDebut;
	
	@Column(name="part_voyage")
	private int 					nbParticipant;	
	
	public EntityVoyage() {
		super();
	}

	public EntityVoyage(int id, String nom, LocalDate dateDebut, int nbParticipant) {
		this.id = id;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.nbParticipant = nbParticipant;
	}

	public EntityVoyage(String nom, LocalDate dateDebut, int nbParticipant) {
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.nbParticipant = nbParticipant;
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

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getNbParticipant() {
		return nbParticipant;
	}

	public void setNbParticipant(int nbParticipant) {
		this.nbParticipant = nbParticipant;
	}

	@Override
	public String toString() {
		return String.format("EntityVoyage [id= %s, nom= %s, dateDebut= %s, nbParticipant= %s]", id, nom, dateDebut,
				nbParticipant);
	}

	
}
