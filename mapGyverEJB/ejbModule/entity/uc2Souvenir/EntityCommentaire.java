package entity.uc2Souvenir;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MPG_comentaire")
public class EntityCommentaire extends EntitySouvenir {

	private static final long serialVersionUID = 1L;
	
	@Column(name="descr", length=500, nullable=true) //TODO voir si rendre com obligatoire
	private String description;
	
	

	
	
	
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
