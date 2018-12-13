package entity.uc2Souvenir;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import entity.uc4Voyage.EntityVoyage;

/**
 * Un Souvenir est soit un Commentaire, soit une Photo, soit 
 * une photo avec un commentaire choix de la strategie: Une 
 * table par classe concrete + requetes possibles sur EntitySouvenir
 * ce qui permettra de pouvoir retrouver facilement des souvenirs
 * ayant une meme date par exemple.
 */



@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class EntitySouvenir implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDD")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	//Lazy, pas besoin de charger le voyage
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_voyage", nullable=false)
	private EntityVoyage entityVoyage;
	
	@Column(name="ddate_enre", length=20, nullable=true)
	private LocalDate dateEnregistre;
	

	
	
	/**
	 * Constructeur necessaire pour enregistrer Souvenirs (Photo et Commentaire)
	 * @param id
	 * @param entityVoyage
	 * @param dateEnregistre
	 */
	public EntitySouvenir(EntityVoyage entityVoyage, LocalDate dateEnregistre) {
		this.entityVoyage = entityVoyage;
		this.dateEnregistre = dateEnregistre;
	}
	
	public EntitySouvenir(EntityVoyage entityVoyage) {
		this.entityVoyage = entityVoyage;
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

	public EntityVoyage getEntityVoyage() {
		return entityVoyage;
	}

	public void setEntityVoyage(EntityVoyage entityVoyage) {
		this.entityVoyage = entityVoyage;
	}
	
	

}
