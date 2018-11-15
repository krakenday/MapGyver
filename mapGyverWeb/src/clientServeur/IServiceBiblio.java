package clientServeur;

import java.util.List;

import business.uc4Voyage.Document;

public interface IServiceBiblio {
		
		public void create(Document document);
		public List<Document> readbyName();
		public void update(Document document);
		public void delete(int ref);
		public List<Document> readbyRef();
		public void deleteAll();
		public Document findbyRef(int ref);
		
}
