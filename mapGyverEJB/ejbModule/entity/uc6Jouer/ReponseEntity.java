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
@Table(name = "reponse")
public class ReponseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="d_emi",nullable=false)
	private LocalDate dateEmission;
	
	public ReponseEntity() {
		
	}

	public ReponseEntity(LocalDate dateEmission) {
		this.dateEmission = dateEmission;
	}

	public ReponseEntity(int id, LocalDate dateEmission) {
		this.id = id;
		this.dateEmission = dateEmission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(LocalDate dateEmission) {
		this.dateEmission = dateEmission;
	}

	@Override
	public String toString() {
		return "Reponse [id=" + id + ", dateEmission=" + dateEmission + "]";
	}
}

