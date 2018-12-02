package entity.uc4Voyage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import dao.util.UtilBdD;
import entity.uc8Utilisateur.EntityUtilisateur;

@Entity
@Table(name=UtilBdD.ENTITY_ROADBOOK)
public class EntityRoadBook implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_Roadbook")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seqRoadBook")
	@SequenceGenerator(name="seqRoadBook", sequenceName="ROADBOOK_SEQ", initialValue=1, allocationSize=30)
	private int id;

	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn(name = "id", unique = true, nullable = false)
	private EntityUtilisateur entityUtilisateur;

	@OneToMany(fetch=FetchType.LAZY)
	private List<EntityVoyage> voyages = new ArrayList<EntityVoyage>();

	public EntityRoadBook() {

	}

	public EntityRoadBook(EntityUtilisateur entityUtilisateur, List<EntityVoyage> voyages) {
		super();
		this.entityUtilisateur = entityUtilisateur;
		this.voyages = voyages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<EntityVoyage> getVoyages() {
		return voyages;
	}

	public void setVoyages(List<EntityVoyage> voyages) {
		this.voyages = voyages;
	}

	public EntityUtilisateur getEntityUtilisateur() {
		return entityUtilisateur;
	}

	public void setEntityUtilisateur(EntityUtilisateur entityUtilisateur) {
		this.entityUtilisateur = entityUtilisateur;
	}

	@Override
	public String toString() {
		return "EntityRoadBook [id=" + id + ", entityUtilisateur=" + entityUtilisateur + ", voyages="/* + voyages */+ "]";
	}

}
