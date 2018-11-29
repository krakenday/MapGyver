package entity.uc4Voyage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import dao.util.UtilBdD;

@Entity
@Table(name=UtilBdD.ENTITY_ROADBOOK)
public class EntityRoadBook implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_roadbook")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seqRoadBook")
	@SequenceGenerator(name="seqRoadBook", sequenceName="ROADBOOK_SEQ", initialValue=1, allocationSize=30)
	private int id;
	
	@OneToMany(fetch=FetchType.LAZY)
	private List<EntityVoyage> voyages = new ArrayList<EntityVoyage>();
	
	public EntityRoadBook(int id, List<EntityVoyage> voyage) {
		this.id 	= id;
		this.voyages = voyage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<EntityVoyage> getVoyage() {
		return voyages;
	}

	public void setVoyage(List<EntityVoyage> voyage) {
		this.voyages = voyage;
	}

	@Override
	public String toString() {
		return String.format("RoadBook [id= %s, voyages = %s]", 
				id, voyages);
	}
	
}
