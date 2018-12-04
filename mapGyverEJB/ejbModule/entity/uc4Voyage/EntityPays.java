
package entity.uc4Voyage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import dao.util.UtilBdD;

@Entity
@Table(name=UtilBdD.ENTITY_PAYS)
public class EntityPays extends EntityPointInteret{

	private static final long serialVersionUID = 1L;
	
	private int 		id;
	private String 		nom;
	
	@Column(name="capt_pays", nullable=false)
	private String		capitale;
	public final int 	NB_TOTAL = 197;
	
	public EntityPays(int id, String nom) {
		super();
		this.id 	= id;
		this.nom 	= nom;
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

	public String getCapitale() {
		return capitale;
	}

	public void setCapitale(String capitale) {
		this.capitale = capitale;
	}
	
	@Override
	public String toString() {
		return String.format("Pays [id = %s, nom = %s, capitale = %s]",
				id, nom, capitale);
	}
	
}
