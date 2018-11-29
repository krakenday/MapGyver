package entity.partager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dao.util.partager.UtilBdD;

@Entity
@Table(name = UtilBdD.ENTITY_MEDIA)
public class MediaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public MediaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MediaEntity(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CLASSE ENTITY MEDIA >>> Media [id=" + id + "]";
	}
}
