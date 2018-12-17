package testJUnit;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import javax.persistence.PersistenceException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import business.uc2Souvenir.Commentaire;
import business.uc2Souvenir.Photo;
import business.uc4Voyage.Voyage;
import dao.exception.uc2Souvenir.DaoSouvenirException;
import dao.uc2Souvenir.DaoSouvenirCreatePhoto;
import dao.uc2Souvenir.FactorySouvenirPhotoComplet;
import entity.uc2Souvenir.EntityPhoto;

public class TestSouvenir {


	private static DaoSouvenirCreatePhoto 	daoSouvenirCreatePhoto;
	private FactorySouvenirPhotoComplet		factorySouvenirPhotoComplet;
	private Photo							photoComplete;
	private Photo							photoErreurCommentaire;
	private Commentaire						commentaire;
	
	//commentaire avec description qui depasse les 500characteres
	private Commentaire				commentaireErreur; 
	private Voyage					voyage;
	private String					description;
	private String					descriptionErreur;
	private byte[]					fileContent;
	
	

	//une seule fois
	@BeforeClass
	public static void initConnexion() {
		daoSouvenirCreatePhoto = new DaoSouvenirCreatePhoto();
	}
//	@AfterClass
//	public static void endConnexion() {
//		
//	}
	
	//avant chaque test
	@Before
	public void avantTest()  {
		System.out.println("before");
		description				= "ma description";
		fileContent				= description.getBytes();
		System.out.println(fileContent);
		
		descriptionErreur		= description.repeat(40);//description dépassant les 500 characteres
		commentaire				= new Commentaire(description);
		commentaireErreur		= new Commentaire(descriptionErreur);
		voyage					= new Voyage(747, "borneo", null, 3, null);
		photoComplete			= new Photo(LocalDate.now(), voyage, "toto", fileContent, commentaire, null);
		photoErreurCommentaire 	= new Photo(LocalDate.now(), voyage, "toto",
									fileContent, commentaireErreur, null);
	}
	
	
	@Test(expected=PersistenceException.class)
	public void descrComTropLong()   { //Non fonctionnel nullPointer qui déclenche
		try {
			daoSouvenirCreatePhoto.createSouvenir(photoErreurCommentaire);
		} catch (DaoSouvenirException e) {
			assertEquals("verifier donnees tables", e.getSolution());
			
		}
			
	}
	
	@Test
	public void testDescrFactorySouvenirPhotoComplet() {//Non fonctionnel : voir jeu d'essai
		EntityPhoto entityPhoto;
		entityPhoto = factorySouvenirPhotoComplet.createEntityPhoto(photoComplete);
		assertEquals(photoComplete.getCommentaire().getDescription(),
				entityPhoto.getCommentaire().getDescription());
		
	}
	
	
	
	

	

	

	

	


}
