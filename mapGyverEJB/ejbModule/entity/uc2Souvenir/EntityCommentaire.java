package entity.uc2Souvenir;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import entity.uc4Voyage.EntityVoyage;

@Entity
@Table(name="MPG_comentaire")
public class EntityCommentaire extends EntitySouvenir {

	private static final long serialVersionUID = 1L;
	
	@Column(name="descr", length=500, nullable=true) //TODO voir si rendre com obligatoire
	private String description;

	

	
	/**
	 * Constructeur pour photos ayant un commentaire
	 * @param description
	 */
	public EntityCommentaire(EntityVoyage entityVoyage, LocalDate dateEnregistre, String description) {
		super(entityVoyage, dateEnregistre);
		this.description = description;
	}
	
	

	
	
	
//TODO decomenter
//	public EntityCommentaire(int id, LocalDate dateEnregistre, String description) {
//		super(id, dateEnregistre);
//		this.description = description;
//	}
//
//	@Override
//	public String toString() {
//		return "Commentaire [description=" + description + "]";
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
	
	
}
