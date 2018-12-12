package webApp.uc2Souvenir;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.opensymphony.xwork2.Preparable;

import business.uc2Souvenir.Photo;
import business.uc2Souvenir.Souvenir;
import clientServeur.IServiceFacade;
import utilitaire.Constantes;
import webApp.ApplicationSupport;

public class AdministrerSouvenir extends ApplicationSupport implements Preparable {

	private static final long serialVersionUID = 1L;
	
	//recuperation contenu, titrePhoto, longueurFichier
	private InputStream 		fileContent;
	private File				file;
	private String				fileContentType;//recupere le type de fichier (non utilise pourl'instant)
	private String				fileFileName;
	private String				comm;
	private String				idVoyage;
	private	Long 				contentLenght;
	private IServiceFacade 		iServiceFacade;
	private	ControlesAjouter 	controles;
	private	Souvenir			souvenir;
	

	
	@Override
	public String execute() throws Exception {
		fileContent = new FileInputStream(file);
		contentLenght =(long) fileContent.available();
		System.out.println("AdministrerSouvenir-execute: hop je suis dans mon beab ACTION!");
//		System.out.println("Valeur de comm =" + comm);
//		System.out.println("Valeur de idVoyage =" + idVoyage);
//		System.out.println("Valeur de file =" + file);
//		System.out.println("Valeur de fileContentType =" + fileContentType);
//		System.out.println("Valeur de fileFileName =" + fileFileName);
//		System.out.println("Valeur de InputStream ="+ fileContent);
//		System.out.println("Valeur de contentLenght ="+ contentLenght);
		
		controles = new ControlesAjouter();
		souvenir = controles.controleDesParametres(this.fileFileName, this.fileContent,
				this.contentLenght, this.comm, this.idVoyage);
		System.out.println("****************ControlSouvenirAjouter- Valeur SOUVENIR =" + souvenir);
		
		//appel de mon service
		//iServiceFacade.createSouvenir(souvenir);
		
		//Test pour recup List de Souvenirs (voir si creer un autre ActionBean pour cela)
		List<Souvenir> catalogueSouvenirs = iServiceFacade.getSouvenirsByIdVoyage("3");
		for (Souvenir souvenir : catalogueSouvenirs) {
			 if(souvenir instanceof Photo) {
				 System.out.println(((Photo) souvenir).getNom());
			 }
			
		}
		
		System.out.println("****************Apres appel du service");
		
		return "success";
	}
	
	
	
	public void setComm(String comm) {
		this.comm = comm;
	}


	public String getIdVoyage() {
		return idVoyage;
	}


	public void setIdVoyage(String idVoyage) {
		this.idVoyage = idVoyage;
	}
	
	public void setFile(File file) {
		this.file = file;
	}


	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}


	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}


	//méthode executée automatiquement
	@Override
	public void prepare() throws Exception {
		try {
			Context context = new InitialContext();

			iServiceFacade = (IServiceFacade) context.lookup(Constantes.LOOKUP_SOUVENIR_AJOUTER);

		} catch (NamingException e) {
			e.printStackTrace();
			// TODO exception
		}
		
	}

}
