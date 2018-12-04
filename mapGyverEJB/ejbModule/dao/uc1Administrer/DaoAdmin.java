package dao.uc1Administrer;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import business.uc8Utilisateur.Utilisateur;
import dao.DaoParam;
import dao.exception.uc1Administrer.DaoInexistantException;
import entity.uc8Utilisateur.EntityPassword;
import entity.uc8Utilisateur.EntityUtilisateur;

@Singleton
@LocalBean
public class DaoAdmin {

	@PersistenceContext(unitName=DaoParam.CONTEXT_PERSISTANCE)
	private EntityManager 		em;

	/**
	 * Retourne EntityUtilisateur par id
	 * si pas trouve : new InexistantException()
	 * @throws DaoInexistantException 
	 */
	public EntityUtilisateur getUserById(int id) throws DaoInexistantException {

		EntityUtilisateur user = null;
		try { 
			user = em.find(EntityUtilisateur.class, id);
		} catch (PersistenceException e) {				
			// recherche de la cause
			Throwable t = e.getCause();
			while ((t != null) && !(t instanceof NoResultException)) {
				t = t.getCause();
			}
			if (t instanceof NoResultException) {
				throw new DaoInexistantException();
			}			
		}
		System.out.println("DM - dao.uc1Administrer.DaoAdmin - getUserById(int id) : user : " + user);
		if (user == null) throw new DaoInexistantException();
		return user;
	}

	public EntityUtilisateur getUserByEmail(String email) throws DaoInexistantException {
		EntityUtilisateur user = null;
		try { 
			Query query = em.createQuery(
					"select p from EntityUtilisateur p left outer join fetch p.motDePasse where p.email = :email order by p.id asc");
			query.setParameter("email", email);
			
			@SuppressWarnings("unchecked")
			List<EntityUtilisateur> liste = query.getResultList();
			if (liste.size()==0) throw new DaoInexistantException();
			
			user = (EntityUtilisateur) query.getResultList().get(0);			
		} catch (PersistenceException e) {				
			Throwable t = e.getCause();
			while ((t != null) && !(t instanceof NoResultException)) {
				t = t.getCause();
			}
			if (t instanceof NoResultException) {
				throw new DaoInexistantException();
			}			
		}
		if (user == null) throw new DaoInexistantException();
		return user;
	}
	
	public Utilisateur uc1CreerUserPourTest(Utilisateur user) {
		EntityUtilisateur entityUser = 
				new EntityUtilisateur(user.getId(), user.getNom(), user.getPrenom(), user.getEmail());
		//DM le mot de passe est obligatoire 
		// s'il est null => plante voir dao.uc8Utilisateur.FabriqueEntity.createEntityPassword()
		entityUser.setMotDePasse(new EntityPassword("totopw"));
		// DM l'adresse est iobligatoire sinon plante
		//  java.sql.SQLIntegrityConstraintViolationException: ORA-01400: impossible d'insérer NULL dans ("MULLER"."UTILISATEUR"."ADRESSE")
		entityUser.setAdresse("adresse user");
		// DM les dates sont obligatoires sinon plante
		// java.sql.SQLIntegrityConstraintViolationException: ORA-01400: impossible d'insérer NULL dans ("MULLER"."UTILISATEUR"."DATEINSCRIP")
		entityUser.setDateInscrip(LocalDate.now());
		entityUser.setDateNaiss(LocalDate.now());
		//DM tel obligatoire sinon plante
		// Caused by: java.sql.SQLIntegrityConstraintViolationException: ORA-01400: impossible d'insérer NULL dans ("MULLER"."UTILISATEUR"."TELEPHONE")
		entityUser.setTelephone("0404040404");
		
		em.persist(entityUser);
		if (entityUser != null) {
			user = new Utilisateur(	entityUser.getId(), 
					entityUser.getNom(), 
					entityUser.getPrenom(), 
					entityUser.getEmail());
		}
		return user;
	}
}
