package business.uc2Souvenir;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Alejandro
 * Un contenu est lié a un point d'interet ou a un voyage
 *
 */

public class Contenu extends ArrayList<Souvenir> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int 			id;
	private String 			nom;
//	private PointInteret 	pointInteret;
//	private Voyage 			voyage;
	
	
	/**
	 * Constructeur pour lier un contenu a un point d'interet
	 * @param id
	 * @param nom
	 * @param pointInteret
	 */
//	public Contenu(int id, String nom, PointInteret pointInteret) {
//		super();
//		this.id = id;
//		this.nom = nom;
//		this.pointInteret = pointInteret;
//	}
	
	

	/**
	 * Constructeur pour lier un contenu a un Voyage
	 * @param id
	 * @param nom
	 * @param voyage
	 */
//	public Contenu(int id, String nom, Voyage voyage) {
//		super();
//		this.id = id;
//		this.nom = nom;
//		this.voyage = voyage;
//	}




	@Override
	public String toString() {
		return "Contenu [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
	
	
	
	
	
	

}
