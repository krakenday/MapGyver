package entity.uc2Souvenir;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Un Souvenir est soit un Commentaire, soit une Photo
 *  choix de la strategie: Une table par classe concrete
 * + requetes possibles sur EntitySouvenir ce qui permettra
 * de pouvoir retrouver facilement des souvenirs ayant une meme
 * date par exemple.
 */



@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class EntitySouvenir implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="ddate_enre", length=20, nullable=false)
	private LocalDate dateEnregistre;
	

	//constructeur necessaire a la classe fille "photo"
	//car id genere automatiquement
	public EntitySouvenir(LocalDate dateEnregistre) {
		this.dateEnregistre = dateEnregistre;
	}

	//cc par defaut
	public EntitySouvenir() {
	}

	@Override
	public String toString() {
		return "Souvenir [id=" + id + ", dateEnregistre=" + dateEnregistre + "]";
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateEnregistre() {
		return dateEnregistre;
	}

	public void setDateEnregistre(LocalDate dateEnregistre) {
		this.dateEnregistre = dateEnregistre;
	}
	

}
