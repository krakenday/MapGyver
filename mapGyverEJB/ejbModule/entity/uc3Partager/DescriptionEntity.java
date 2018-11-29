package entity.uc3Partager;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Any;

import business.uc3Partager.Partageable;
import business.uc3Partager.TypeCommentaire;

import dao.util.partager.UtilBdD;
import entity.uc8Utilisateur.EntityUtilisateur;

@Entity
@Table(name = UtilBdD.ENTITY_DESCRIPTION)
public class DescriptionEntity implements Serializable{

	private static final long serialVersionUID = 1921720978293410798L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = UtilBdD.ENTITY_COMMENTAIRE, nullable = false)
	private String libelleCommentaire;
	@Column(name = UtilBdD.ENTITY_DATE_CREATION, nullable = true)
	private LocalDate dateEdition;
	@Column(name = UtilBdD.ENTITY_NOMBRE_LIKE)
	private int nbLike;
	@Enumerated(EnumType.STRING)
	@Column(name= dao.util.partager.UtilBdD.ENTITY_TYPE_COMMENTAIRE, nullable=true, updatable=false)
	private TypeCommentaire typeCommentaire;
	@Any(
            metaDef = "ProprietePartageable",
            metaColumn = @Column( name = UtilBdD.ENTITY_TYPE_PARTAGEABLE )
        )
    @JoinColumn( name = "id_Partageable" )
	private Partageable partageable;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_Utilisateur", nullable = false)
	private EntityUtilisateur utilisateur;
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "id_ListAvis")
	private List<AvisEntity> avisEntities;
	
	public DescriptionEntity() {
		super();
	}

	public DescriptionEntity(String libelleCommentaire, LocalDate dateEdition, int nbLike) {
		super();
		this.libelleCommentaire = libelleCommentaire;
		this.dateEdition = dateEdition;
		this.nbLike = nbLike;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelleCommentaire() {
		return libelleCommentaire;
	}

	public void setLibelleCommentaire(String libelleCommentaire) {
		this.libelleCommentaire = libelleCommentaire;
	}

	public LocalDate getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(LocalDate dateEdition) {
		this.dateEdition = dateEdition;
	}

	public int getNbLike() {
		return nbLike;
	}

	public void setNbLike(int nbLike) {
		this.nbLike = nbLike;
	}
	
	public TypeCommentaire getTypeCommentaire() {
		return typeCommentaire;
	}

	public void setTypeCommentaire(TypeCommentaire typeCommentaire) {
		this.typeCommentaire = typeCommentaire;
	}

	public Partageable getPartageable() {
		return partageable;
	}

	public void setPartageable(Partageable partageable) {
		this.partageable = partageable;
	}

	public EntityUtilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(EntityUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<AvisEntity> getAvisEntities() {
		return avisEntities;
	}

	public void setAvisEntities(List<AvisEntity> avisEntities) {
		this.avisEntities = avisEntities;
	}

	@Override
	public String toString() {
		return "CLASSE ENTITY DESCRIPTION >>> Description [id=" + id + ", libelleCommentaire=" + libelleCommentaire + ", dateEdition=" + dateEdition
				+ ", nbLike=" + nbLike + "]";
	}
}
