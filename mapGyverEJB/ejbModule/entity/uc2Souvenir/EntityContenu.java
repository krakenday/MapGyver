//package entity.uc2Souvenir;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
///**
// * 
// * @author Alejandro
// 
// *
// */
//
//@Entity
//@Table(name="contenu")
//public class EntityContenu extends ArrayList<EntitySouvenir> implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//	
//	private int 			id;
//	private String 			nom;
//	
//	@ManyToOne(fetch=FetchType.EAGER)//TODO voir si besoin de charger systemetiquement PointInteret
//	@JoinColumn(name="id_pi", nullable=true)
//	private PointInteret 	pointInteret;
//	
//	@ManyToOne(fetch=FetchType.EAGER)//TODO voir si besoin de charger systemetiquement Voyage
//	@JoinColumn(name="id_voyage", nullable=true)
//	private Voyage 			voyage;
//	
//	
//	/**
//	 * Constructeur pour lier un contenu a un point d'interet
//	 * @param id
//	 * @param nom
//	 * @param pointInteret
//	 */
//	public EntityContenu(int id, String nom, PointInteret pointInteret) {
//		super();
//		this.id = id;
//		this.nom = nom;
//		this.pointInteret = pointInteret;
//	}
//	
//	
//
//	/**
//	 * Constructeur pour lier un contenu a un Voyage
//	 * @param id
//	 * @param nom
//	 * @param voyage
//	 */
//	public EntityContenu(int id, String nom, Voyage voyage) {
//		super();
//		this.id = id;
//		this.nom = nom;
//		this.voyage = voyage;
//	}
//
//
//
//
//	@Override
//	public String toString() {
//		return "Contenu [id=" + id + ", nom=" + nom + "]";
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//}
