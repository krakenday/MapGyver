package business.uc4Voyage;

import java.util.ArrayList;
import java.util.List;


public class RoadBook {

	private int id;
	private List<Voyage> voyages = new ArrayList<Voyage>();
	
	public RoadBook(int id, List<Voyage> voyage) {
		this.id 	= id;
		this.voyages = voyage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Voyage> getVoyage() {
		return voyages;
	}

	public void setVoyage(List<Voyage> voyage) {
		this.voyages = voyage;
	}

	@Override
	public String toString() {
		return String.format("RoadBook [id= %s, voyages = %s]", 
				id, voyages);
	}
	
}
