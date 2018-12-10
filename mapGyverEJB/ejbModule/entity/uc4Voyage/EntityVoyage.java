package entity.uc4Voyage;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import dao.util.UtilBdD;

@Entity
@Table(name=UtilBdD.ENTITY_VOYAGE)
public class EntityVoyage implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_voy")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seqVoyage")
	@SequenceGenerator(name="seqVoyage", sequenceName="VOYAGE_SEQ", initialValue=1, allocationSize=30)
	private int 					id;
	
	@Column(name="nom_voy", length=60, nullable=false)
	private String 					nom;
	
	@Column(name="deb_voy")
	private LocalDate 				dateDebut;
	
	@Column(name="part_voy")
	private Integer 				nbParticipant;
	
	//TODO mettre en place le manytomany avec POI
	@Column(name="poi_voy")
	@ManyToMany(cascade= { CascadeType.PERSIST})
	@JoinTable(name=UtilBdD.ENTITY_VOYPOI, joinColumns = {@JoinColumn(name="id_Voyage")}, inverseJoinColumns = {@JoinColumn(name="id_POI")})
	private List<EntityPointInteret> entityPointInterets = new ArrayList<EntityPointInteret>();
	
	public EntityVoyage() {
		super();
	}

	public EntityVoyage(int id, String nom, LocalDate dateDebut, Integer nbParticipant) {
		this.id = id;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.nbParticipant = nbParticipant;
	}

	public EntityVoyage(String nom, LocalDate dateDebut, Integer nbParticipant) {
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.nbParticipant = nbParticipant;
	}
	
	
	public EntityVoyage(int id, String nom, LocalDate dateDebut, Integer nbParticipant,
			List<EntityPointInteret> entityPointInteret) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.nbParticipant = nbParticipant;
		this.entityPointInterets = entityPointInteret;
	}
	
	public EntityVoyage(String nom, LocalDate dateDebut, Integer nbParticipant,
			List<EntityPointInteret> entityPointInteret) {
		super();
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.nbParticipant = nbParticipant;
		this.entityPointInterets = entityPointInteret;
	}
	
	public EntityVoyage(String nom) {
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

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Integer getNbParticipant() {
		return nbParticipant;
	}

	public void setNbParticipant(Integer nbParticipant) {
		this.nbParticipant = nbParticipant;
	}

	public List<EntityPointInteret> getEntityPointInterets() {
		return entityPointInterets;
	}

	public void setEntityPointInterets(List<EntityPointInteret> entityPointInteret) {
		this.entityPointInterets = entityPointInteret;
	}

	@Override
	public String toString() {
		return String.format("EntityVoyage [id=%s, nom=%s, dateDebut=%s, nbParticipant=%s, entityPointInteret=%s]", id,
				nom, dateDebut, nbParticipant, entityPointInterets);
	}

	public void addPoi(EntityPointInteret entityPointInteret) {
		if (entityPointInteret != null) {
			if (entityPointInterets == null) entityPointInterets = new ArrayList<EntityPointInteret>();
			if (!entityPointInterets.contains(entityPointInteret)) {
				entityPointInterets.add(entityPointInteret);
				entityPointInteret.add(this);
			} 
		}
		
	}

}
