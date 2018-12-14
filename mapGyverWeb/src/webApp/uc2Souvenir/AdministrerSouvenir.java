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
	private List<Souvenir> 		catalogueSouvenirs;
	

	
	

	@Override
	public String execute() throws Exception {
		
		//TODO tester si file est null
		fileContent = new FileInputStream(file);
		contentLenght =(long) fileContent.available();
		System.out.println("AdministrerSouvenir-execute: hop je suis dans mon beab ACTION!");
		
		controles = new ControlesAjouter();
		souvenir = controles.controleDesParametres(this.fileFileName, this.fileContent,
				this.contentLenght, this.comm, this.idVoyage);
		System.out.println("****************ControlSouvenirAjouter- Valeur SOUVENIR =" + souvenir);
		
		//appel de mon service
		iServiceFacade.createSouvenir(souvenir);
		
		//rafraichir jsp
		afficheSouvenirsVoyage();
		
		
		System.out.println("****************Apres appel du service");
		
		return "success";
	}
	
	public String afficheSouvenirsVoyage() {
		
		System.out.println("*****AdministrerSouvenir-afficheSouvenirsVoyage() ");
		System.out.println("*****Valeur de idVoyage =  "+ this.idVoyage);
		//Test pour recup List de Souvenirs (voir si creer un autre ActionBean pour cela)
		catalogueSouvenirs = iServiceFacade.getSouvenirsByIdVoyage(this.idVoyage);
		
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
	
	public List<Souvenir> getCatalogueSouvenirs() {
		return catalogueSouvenirs;
	}
	
	


	//m�thode execut�e automatiquement
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
