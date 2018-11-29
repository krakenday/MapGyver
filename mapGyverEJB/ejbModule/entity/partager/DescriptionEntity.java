package entity.partager;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dao.util.partager.UtilBdD;

@Entity
@Table(name = UtilBdD.ENTITY_DESCRIPTION)
public class DescriptionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = UtilBdD.ENTITY_COMMENTAIRE, nullable = false)
	private String libelleCommentaire;
	@Column(name = UtilBdD.ENTITY_DATE_CREATION, nullable = true)
	private LocalDate dateEdition;
	@Column(name = UtilBdD.ENTITY_NOMBRE_LIKE)
	private int nbLike;
	
	
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

	@Override
	public String toString() {
		return "CLASSE ENTITY DESCRIPTION >>> Description [id=" + id + ", libelleCommentaire=" + libelleCommentaire + ", dateEdition=" + dateEdition
				+ ", nbLike=" + nbLike + "]";
	}
}
