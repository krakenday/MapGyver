package business.uc4Voyage;

import java.util.List;

public class RoadBook {

	private int id;
	private List<Voyage> voyage;
	
	public RoadBook(int id, List<Voyage> voyage) {
		this.id = id;
		this.voyage = voyage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Voyage> getVoyage() {
		return voyage;
	}

	public void setVoyage(List<Voyage> voyage) {
		this.voyage = voyage;
	}

	@Override
	public String toString() {
		return String.format("RoadBook [id= %s, voyage= %s]", 
				id, voyage);
	}
	
}
