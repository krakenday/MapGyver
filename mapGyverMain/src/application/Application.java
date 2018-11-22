package application;

import java.time.LocalDate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import business.uc3Partager.Description;
import client.serveur.partager.IGestion;
import client.serveur.partager.exception.UserException;


public class Application {

	public static void main(String[] args) throws UserException {
		
		try {
			Context context 			= new InitialContext();
			IGestion serviceGestion 	= (IGestion) context.lookup("ejb:/mapGyverEJB/ServiceFacade!client.serveur.partager.IGestion");
			
			//Jeu d'essai
			Description description 	= new Description(1,"Test création", LocalDate.now(), 10);
			Description description1 	= new Description("Ce voyage est trop beau", LocalDate.now(), 20);
			Description description2 	= new Description("Road trip en californie", LocalDate.now(), 30);
			Description description3 	= new Description("Restaurant italien", LocalDate.now(), 40);
			
			//Création
			serviceGestion.addDescription(description);
			serviceGestion.addDescription(description1);
			serviceGestion.addDescription(description2);
			serviceGestion.addDescription(description3);
			
			//Suppression
//			serviceGestion.deleteDescription(description.getId());
//			serviceGestion.deleteDescription(description);
			
			//Modification
//			serviceGestion.updateDescription(description);

			System.out.println(description);
	        System.out.println("Main projet Partager OK");
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (UserException e) {
			System.out.println(e.getMessage());
	}
}

}
