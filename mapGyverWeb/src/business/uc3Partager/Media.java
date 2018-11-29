package business.uc3Partager;

import java.io.Serializable;

public class Media implements Serializable{

	private static final long serialVersionUID = 3376855106287451740L;
	
	private int id;

	public Media(int id) {
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
		return "CLASSE METIER MEDIA >>>Media [id=" + id + "]";
	}
	
	
}
