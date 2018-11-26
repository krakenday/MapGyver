package entity.uc6Jouer;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="jeu")
public class JeuEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(length=75)
	private String nom;
	@Column(name="d_crea",nullable=false)
	private LocalDate dateCreation;
	
	public JeuEntity() {
		
	}

	public JeuEntity(String nom, LocalDate dateCreation) {
		this.nom = nom;
		this.dateCreation = dateCreation;
	}

	public JeuEntity(int id, String nom, LocalDate dateCreation) {
		this.id = id;
		this.nom = nom;
		this.dateCreation = dateCreation;
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

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Jeu [id=" + id + ", nom=" + nom + ", dateCreation=" + dateCreation + "]";
	}
}
