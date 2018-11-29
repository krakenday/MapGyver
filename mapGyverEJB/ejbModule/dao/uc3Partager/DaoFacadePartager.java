package dao.uc3Partager;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.PersistenceException;

import business.uc3Partager.Description;
import dao.exception.ViolationPersistenceException;
import dao.uc3Partager.gestion.DaoPartagerGestion;
import entity.partager.DescriptionEntity;

@Singleton
@LocalBean
public class DaoFacadePartager {

	//TODO: Intégrer les classes métier dans entity
	
	@EJB
	private DaoPartagerGestion daoPartagerGestion;
	private entity.partager.DescriptionEntity descriptionEntity;
	
	/*
	 * Création
	 */
	public void addDescription(Description description) throws ViolationPersistenceException, service.exception.ViolationPersistenceException {
		descriptionEntity = new DescriptionEntity(description.getLibelleCommentaire(),
												  description.getDateEdition(),description.getNbLike());
		daoPartagerGestion.addDescription(descriptionEntity);
	}
	
	/*
	 * Modification
	 */
	public void updateDescription(Description description) {
		System.out.println("***************************" + description);
		descriptionEntity = new DescriptionEntity(description.getLibelleCommentaire(),
				  								  description.getDateEdition(),description.getNbLike());
		try {
			daoPartagerGestion.updateDescription(descriptionEntity);
		} catch (Exception e) {
			System.out.println("DAO_FACADE_PARTAGER >>> updateDescription(Description description) - Erreur");
		}
	}

	/*
	 * Suppression par Id
	 */
	public void deleteDescription(int id) {
		try {
			daoPartagerGestion.deleteDescription(id);
		} catch (Exception e) {
			System.out.println("DAO_FACADE_PARTAGER >>> deleteDescription(int id) - Erreur");
		}
	}

	/*
	 * Suppression description
	 */
	public void deleteDescription(Description description) {
		try {
			daoPartagerGestion.deleteDescription(description);
		} catch (Exception e) {
			System.out.println("DAO_FACADE_PARTAGER >>> deleteDescription(Description description) - Erreur");
		}
	}

}
